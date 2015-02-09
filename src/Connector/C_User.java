/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connector;

import java.net.*;
import java.io.*;
import Database.*;
import Forms.*;

/**
 *
 * @author adima
 */
public class C_User
{
    Socket s=null;
    OutputStream os=null;
    PrintStream ps=null;
    Dbprocess dp=new Dbprocess();
    
    public C_User(String ip)
    {
        try
        {
            s=new Socket(ip,9070);
            os=s.getOutputStream();
            ps=new PrintStream(os);
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    
    public void connectToAdmin()
    {
        try
        {
            ps.println("ip");
            ps.println(dp.getIP(new Login().u));
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    
}
