package com.collage.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DatabaseProcess {
    private static final String USERNAME = "u_name";
    private static final String STATUS = "status";
    private static final String USER_TYPE = "u_type";
    private static final String PASSWORD = "pwd";

    private ResultSet resultSet;
    private DatabaseConnection dbConnection;

    public DatabaseProcess() {
        dbConnection = DatabaseConnection.getInstance();
    }

    public String[] validate(String username) {
        String a[] = new String[4];
        try {
            //System.out.println(username);
            String query = "select * from login where " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(query);
            //System.out.println("executed");

            while (resultSet.next()) {
                a[0] = resultSet.getString(PASSWORD);
                a[1] = resultSet.getString(USER_TYPE);
                a[2] = resultSet.getString(STATUS);
                a[3] = resultSet.getString(USERNAME);
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return a;
    }

    public boolean isAlreadyExistingUsername(String username) {
        try {
            String query = "select * from login where  " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(query);
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
            return false;
        }
        return false;
    }

    public int update(String name, String address, String email, String designation, String username) {
        int i = 0;
        try {
            String query = "insert into registration values('" + name + "','" + address + "','" + email + "','" +
                    designation + "','" + username + "')";
            i = dbConnection.updateQuery(query);

        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        return i;
    }

    public int updatel(String username, String password) {
        int i = 0;
        try {
            String query = "insert into login values('" + username + "','" + password + "','user','0')";
            i = dbConnection.updateQuery(query);

        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        return i;
    }

    public int change(String username, String password) {
        int i = 0;
        try {
            String query = "update login set pwd='" + password + "' where  " + USERNAME + "='" + username + "'";
            i = dbConnection.updateQuery(query);

        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        return i;
    }

    public List listUsers(int status) {
        ArrayList list = new ArrayList();
        try {
            String query = "select * from login where status='" + status + "' and u_type='user'";
            resultSet = dbConnection.executeQuery(query);
            while (resultSet.next()) {
                list.add(resultSet.getString(USERNAME));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return list;
    }

    public List getApprovalPendingUserList() {
        return listUsers(0);
    }

    public int getPendingApprovalCount() {
        return listUsers(0).size();
    }

    public int addUser(String username) {
        int i = 0;
        try {
            String query = "update login set status='1' where  " + USERNAME + "='" + username + "'";
            i = dbConnection.updateQuery(query);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return i;
    }

    public int rejectUser(String username) {
        int i = 0;
        try {
            String query = "delete from login where  " + USERNAME + "='" + username + "'";
            i = dbConnection.updateQuery(query);
            query = "delete from registration where  " + USERNAME + "='" + username + "'";
            i = dbConnection.updateQuery(query);

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return i;
    }


    public String[] showDetails(String username) {
        String a[] = new String[4];
        try {
            String query = "select * from registration where  " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(query);
            //System.out.println("executed");

            while (resultSet.next()) {
                //System.out.println("in Chekking");
                a[0] = resultSet.getString("name");
                a[1] = resultSet.getString("addr");
                a[2] = resultSet.getString("email");
                a[3] = resultSet.getString("desn");
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return a;
    }

    public String showip(String username) {
        String ipAddress = "";
        try {
            String qry = "select * from ipaddr where  " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(qry);
            ipAddress = "";
            if (resultSet.next()) {
                ipAddress = resultSet.getString("ip");
            } else {
                ipAddress = "0.0.0.0";
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return ipAddress;
    }

    public int addIpAddress(String username, String ipAddress) {
        int i = 0;
        try {
            String query1 = "select * from ipaddr where ip='" + ipAddress + "'";
            ResultSet resultSet1 = dbConnection.executeQuery(query1);
            if (resultSet1.next()) {
                i = -1;
            } else {
                query1 = "select * from ipaddr where  " + USERNAME + "='" + username + "'";
                resultSet = dbConnection.executeQuery(query1);
                String query2 = "";
                if (resultSet.next()) {
                    query1 = "update ipaddr set ip='" + ipAddress + "' where  " + USERNAME + "='" + username + "'";
                    query2 = "update imgstat set ip='" + ipAddress + "' where  " + USERNAME + "='" + username + "'";
                } else {
                    query1 = "insert into ipaddr values('" + username + "','" + ipAddress + "')";
                    query2 = "insert into imgstat values ('" + username + "','" + ipAddress + "','0')";
                }
                i = dbConnection.updateQuery(query1);
                int j = dbConnection.updateQuery(query2);
                System.out.println(j);
                //System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return i;
    }

    public String getIP(String username) {
        String query = "select * from ipaddr where  " + USERNAME + "='" + username + "'";
        resultSet = dbConnection.executeQuery(query);
        try {
            if (resultSet.next()) {
                return resultSet.getString("ip");
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return "Error";
    }

    public Vector getIPList() {
        String qry = "select * from ipaddr";
        Vector v = new Vector();
        try {
            resultSet = dbConnection.executeQuery(qry);
            while (resultSet.next()) {
                v.add(resultSet.getString("ip"));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return v;
    }

    public String getUser(String userIpAddress) {
        String user = "";
        String qry = "select * from ipaddr where ip='" + userIpAddress + "'";
        try {
            resultSet = dbConnection.executeQuery(qry);
            while (resultSet.next()) {
                user = resultSet.getString(USERNAME);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return user;
    }

    public int setStatus(String ipAddress, String status) {
        String qry = "update imgstat set status='" + status + "' where ip='" + ipAddress + "'";
        int j = 0;
        try {
            j = dbConnection.updateQuery(qry);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return j;
    }

    public Vector getList() {
        Vector list = new Vector();
        String qry = "select * from imgstat where status='1'";
        try {
            resultSet = dbConnection.executeQuery(qry);
            while (resultSet.next()) {
                list.add(resultSet.getString("ip"));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);

        }
        return list;
    }
}
