/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connector;

import java.io.*;
import java.net.*;
import Forms.*;

/**
 *
 * @author adima
 */
public class C_Admin implements Runnable
{
    ServerSocket ss=null;
    Socket s=null;
    public C_Admin()
    {
        try
        {
            ss=new ServerSocket(9070);
            Thread t=new Thread(this);
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    class Admin extends Thread
    {
        Socket as=null;
        InputStream is=null;
        DataInputStream dis=null;
        
        public Admin(Socket a)
        {
            try
            {
                as=a;
                is=a.getInputStream();
                dis=new DataInputStream(is);
            }
            catch(Exception e)
            {
                System.out.println("Exception "+e);
            }
        }
        
        public void run()
        {
            try 
            {
                if(dis.readLine().equals("ip"))
                {
                    String a=dis.readLine();
                    new UpdateImagePool().update(a);
                }
            }
            catch (Exception e) 
            {
                System.out.println("Exception "+e);
            }
        }
    }
    public void run()
    {
        try 
        {
            while(true)
            {
                s=ss.accept();
                new Admin(s).start();
            }
        }
        catch (Exception e) 
        {
            System.out.println("Exception "+e);
        }
     
    }
    
}
