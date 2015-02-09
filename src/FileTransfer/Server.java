/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FileTransfer;

import java.net.*;
import java.io.*;
import java.util.*;
//import Image.*;
//import Forms.*;

/**
 *
 * @author adima
 */
public class Server implements Runnable
{
    
    ServerSocket ss=null;
    Socket s=null;
    
    public Server()throws Exception
    {
        try
        {
            System.out.println("Server started");
            ss=new ServerSocket(9090);
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
        Socket cs=null;
        InputStream is=null;
        DataInputStream dis=null;
        FileOutputStream fos=null;
        
        public Receiver(Socket s)
        {
            try
            {
                cs=s;
                is=cs.getInputStream();
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
                String t_hr=new String();
                String t_min=new String();
                String t_sec=new String();
                String a=dis.readLine();
                if(a.equals("file"))
                {
                    String size=dis.readLine();
                    int len=Integer.parseInt(size);
                    String fname=dis.readLine();
                    String rec=dis.readLine(); 
                    System.out.println(rec);
                    File f=new File("./inbox/"+rec);
                    f.mkdirs();
                    Calendar cal=new GregorianCalendar();
                    int hr=cal.get(cal.HOUR_OF_DAY);
                    if(hr<10)
                    {
                        t_hr="0"+Integer.toString(hr);
                    }
                    else
                    {
                        t_hr=Integer.toString(hr);
                    }
                    int min=cal.get(cal.MINUTE);
                    if(min<10)
                    {
                        t_min="0"+Integer.toString(min);
                    }
                    else
                    {
                        t_min=Integer.toString(min);
                    }
                    int sec=cal.get(cal.SECOND);
                    if(sec<10)
                    {
                        t_sec="0"+Integer.toString(sec);
                    }
                    else
                    {
                        t_sec=Integer.toString(sec);
                    }
                    String target="./inbox/"+rec+"/"+t_hr+"-"+t_min+"-"+t_sec+"  "+fname;
                    fos=new FileOutputStream(target);
                    byte b[]=new byte[1024];
                    int ch=0,cnt=0;
                    while((ch=is.read(b,0,1024))!=-1)
                    {
                        cnt+=ch;
                        fos.write(b,0,ch);
                        if(cnt>=len)
                            break;
                    }
                    fos.close();
                    
                    
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
            
            //System.out.println("Accepted");
            //c_ip.addElement(s);
            new Receiver(s).start();
            }
        }
        catch (Exception e) 
        {
            System.out.println("Exception "+e);
        }
        
    }
    
    
    
    public static void main(String args[])throws Exception
    {
        Server s=new Server();
    }
}
