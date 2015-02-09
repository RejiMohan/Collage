/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;
import java.sql.*;
import java.util.*;

/**
 *
 * @author adima
 */
public class Dbprocess {
    private static final String USERNAME = "u_name";
	private static final String STATUS = "status";
	private static final String USER_TYPE = "u_type";
	private static final String PASSWORD = "pwd";
	ResultSet rs;
    int i;
    Dbcon db=new Dbcon();
    
    
    public String[] validate(String u)
    {
        String a[]=new String[4];
        try 
        {
            //System.out.println(u);
            String qry="select * from login where " + USERNAME + "='"+u+"'";
            rs=db.executeQ(qry);    
            //System.out.println("executed");
            
            while(rs.next())
            {
                //System.out.println("in Chekking");
                a[0]=rs.getString(PASSWORD);
                a[1]=rs.getString(USER_TYPE);
                a[2]=rs.getString(STATUS);
                a[3]=rs.getString(USERNAME);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception"+e);
        }
        return a;
    }
    
    public int sel(String u)
    {
        i=0;
        try
        {
            String qry="select * from login where  " + USERNAME + "='"+u+"'";
            rs=db.executeQ(qry);
            if(rs.next())
            {
                i=1;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return i;
    }
    
    public int update(String n,String a,String e,String d,String u)
    {
        i=0;
        try 
        {
            String qry="insert into registration values('"+n+"','"+a+"','"+e+"','"+d+"','"+u+"')";
            i=db.updateQ(qry);
            
        }
        catch (Exception ex) 
        {
            System.out.println("Exception "+ex);
        }
        return i;
    }
    
    public int updatel(String u,String p)
    {
        i=0;
        try 
        {
            String qry="insert into login values('"+u+"','"+p+"','user','0')";
            i=db.updateQ(qry);
            
        }
        catch (Exception ex) 
        {
            System.out.println("Exception "+ex);
        }
        return i;
    }
    
    public int change(String u,String p)
    {
        i=0;
        try
        {
            String qry="update login set pwd='"+p+"' where  " + USERNAME + "='"+u+"'";
            i=db.updateQ(qry);
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception "+ex);
        }
        return i;
    }
    
    public Vector listUsers(String a)
    {
        Vector v=new Vector();
        try 
        {
            String qry="select * from login where status='"+a+"' and u_type='user'";
            rs=db.executeQ(qry);
            while(rs.next())
            {
                v.add(rs.getString(USERNAME));
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return v;
    }
    
    public int addUser(String u)
    {
        try 
        {
            String qry="update login set status='1' where  " + USERNAME + "='"+u+"'";
            i=db.updateQ(qry);
                                  
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return i;
    }
    
    public int rejectUser(String u)
    {
        try 
        {
            String qry="delete from login where  " + USERNAME + "='"+u+"'";
            i=db.updateQ(qry);
            qry="delete from registration where  " + USERNAME + "='"+u+"'";
            i=db.updateQ(qry);
                                  
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return i;
    }
    
    
    
    public String[] showDetails(String u)
    {
        String a[]=new String[4];
        try 
        {
            String qry="select * from registration where  " + USERNAME + "='"+u+"'";
            rs=db.executeQ(qry);    
            //System.out.println("executed");
            
            while(rs.next())
            {
                //System.out.println("in Chekking");
                a[0]=rs.getString("name");
                a[1]=rs.getString("addr");
                a[2]=rs.getString("email");
                a[3]=rs.getString("desn");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Exception "+e);
        }
        return a;
    }
    
    public String showip(String u)
    {
        String ip="";
        try
        {
            String qry="select * from ipaddr where  " + USERNAME + "='"+u+"'";
            rs=db.executeQ(qry);
            ip="";
            if(rs.next())
            {
                ip=rs.getString("ip");
            }
            else
            {
                ip="0.0.0.0";
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return ip;
    }
    
    public int addip(String u,String ip)
    {
        i=0;
        try 
        {
            String qry="select * from ipaddr where ip='"+ip+"'";
            ResultSet rs1=db.executeQ(qry);
            if(rs1.next())
            {
                i=-1;
            }
            else
            {
                qry="select * from ipaddr where  " + USERNAME + "='"+u+"'";
                rs=db.executeQ(qry);
                String qry1="";
                if(rs.next())
                {
                    qry="update ipaddr set ip='"+ip+"' where  " + USERNAME + "='"+u+"'";
                    qry1="update imgstat set ip='"+ip+"' where  " + USERNAME + "='"+u+"'";
                }
                else
                {
                    qry="insert into ipaddr values('"+u+"','"+ip+"')";
                    qry1="insert into imgstat values ('"+u+"','"+ip+"','0')";
                }
                i=db.updateQ(qry);
                int j=db.updateQ(qry1);
                System.out.println(j);
                //System.out.println(i);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return i;
    }
    
    public String getIP(String u_name)
    {
        String qry="select * from ipaddr where  " + USERNAME + "='"+u_name+"'";
        rs=db.executeQ(qry);
        try
        {
            if(rs.next())
            {
                return rs.getString("ip");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return "Error";
    }
    
    public Vector getIPList()
    {
        String qry="select * from ipaddr";
        Vector v=new Vector();
        try 
        {
            rs=db.executeQ(qry);
            while(rs.next())
            {
                v.add(rs.getString("ip"));
            }
        } 
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return v;
    }
    
    public String getUser(String u_ip)
    {
        String user="";
        String qry="select * from ipaddr where ip='"+u_ip+"'";
        try 
        {
            rs=db.executeQ(qry);
            while(rs.next())
            {
                user=rs.getString(USERNAME);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return user;
    }
     
    public int setStatus(String ip,String k)
    {
        String qry="update imgstat set status='"+k+"' where ip='"+ip+"'";
        int j=0;
        try
        {
            j=db.updateQ(qry);
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return j;
    }

    public Vector getList()
    {
        Vector v=new Vector();
        String qry="select * from imgstat where status='1'";
        try
        {
            rs=db.executeQ(qry);
            while(rs.next())
            {
                v.add(rs.getString("ip"));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
            
        }
        return v;
    }
}
