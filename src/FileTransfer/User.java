/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FileTransfer;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author adima
 */
public class User implements Runnable
{
    ServerSocket ss=null;
    Socket s=null;
    
    public User() throws Exception
    {
        try
        {
            System.out.println("");
            ss=new ServerSocket(9080);
            Thread t=new Thread(this);
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
    }
    
    class Receiver extends Thread
    {
        Socket us=null;
        InputStream is=null;
        DataInputStream dis=null;
        FileOutputStream fos=null;
        
        public Receiver(Socket s)throws Exception
        {
            try
            {
                us=s;
                is=us.getInputStream();
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
                if(dis.readLine().equals("image"))
                {
                    int len=Integer.parseInt(dis.readLine());
                    String fname=dis.readLine();
                    File dir=new File("D:/ImagePool");
                    dir.mkdirs();
                    File file=new File("D:/ImagePool/"+fname);
                    fos=new FileOutputStream(file);
                    byte[] b=new byte[1024];
                    int ch=0,cnt=0;
                    while((ch=is.read(b, 0, 1024))!=-1)
                    {
                        cnt+=ch;
                        fos.write(b, 0, ch);
                        if(ch>=len)
                            break;
                    }
                }
                fos.close();
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
                new Receiver(s).start();
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        
    }

    
}
