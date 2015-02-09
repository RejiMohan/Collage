/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;
import java.sql.*;
/**
 *
 * @author adima
 */
public class Dbcon
{
    Connection con;
    Statement st;
    ResultSet rs;
    
    public Dbcon()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/collage","root", "root");
            st=con.createStatement();
            System.out.println("Connection Created");
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    public ResultSet executeQ(String qry)
    {
        try
        {
            rs=st.executeQuery(qry);
            
        }
        catch (Exception e) 
        {
            System.out.println("Exception"+e);
        }
        return rs;
    }
    
    public int updateQ(String qry)
    {
        int i=0;
        try
        {
            i=st.executeUpdate(qry);
        }
        catch (Exception e) 
        {
            System.out.println("Exception"+e);
        }
        return i;
    }
    public static void main(String[] args) {
        new Dbcon();
    }
}
