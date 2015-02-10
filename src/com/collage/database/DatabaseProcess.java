package com.collage.database;

import com.collage.User;

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
            String query = "select * from login where " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(query);

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

    public boolean insertUser(User user) {
        String name = user.getName();
        String address = user.getAddress();
        String email = user.getEmail();
        String designation = user.getDesignation();
        String username = user.getUsername();
        try {
            String query = "insert into registration values('" + name + "','" + address + "','" + email + "','" +
                    designation + "','" + username + "')";
            return (dbConnection.updateQuery(query) > 0) ? true : false;
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            return false;
        }
    }

    public boolean insertUserInLogin(String username, String password) {
        try {
            String query = "insert into login values('" + username + "','" + password + "','user','0')";
            return (dbConnection.updateQuery(query) > 0) ? true : false;
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            return false;
        }
    }

    public int change(String username, String password) {
        try {
            String query = "update login set pwd='" + password + "' where  " + USERNAME + "='" + username + "'";
            return dbConnection.updateQuery(query);
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
        return 0;
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
        try {
            String query = "update login set status='1' where  " + USERNAME + "='" + username + "'";
            return dbConnection.updateQuery(query);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return 0;
    }

    public int rejectUser(String username) {
        try {
            String query = "delete from login where  " + USERNAME + "='" + username + "'";
            dbConnection.updateQuery(query);
            query = "delete from registration where  " + USERNAME + "='" + username + "'";
            return dbConnection.updateQuery(query);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return 0;
    }


    public String[] showDetails(String username) {
        String a[] = new String[4];
        try {
            String query = "select * from registration where  " + USERNAME + "='" + username + "'";
            resultSet = dbConnection.executeQuery(query);
            while (resultSet.next()) {
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

    public List getIPList() {
        String qry = "select * from ipaddr";
        List ipList = new ArrayList();
        try {
            resultSet = dbConnection.executeQuery(qry);
            while (resultSet.next()) {
                ipList.add(resultSet.getString("ip"));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return ipList;
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
        try {
            return dbConnection.updateQuery(qry);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return 0;
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
