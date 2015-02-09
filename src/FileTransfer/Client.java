/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FileTransfer;

import java.net.*;
import java.io.*;
import Forms.*;
import java.util.*;

/**
 *
 * @author adima
 */
public class Client
{
    Socket s=null;
    OutputStream os=null;
    PrintStream ps=null;
    FileInputStream fis=null;
    
    public Client(String ip)
    {
        try 
        {
            
            s=new Socket(ip,9090);
            
            os=s.getOutputStream();
            ps=new PrintStream(os);
            System.out.println("Client started");
        }
        catch (Exception e) 
        {
            System.out.println("Exception "+e);
        }
        
    }
    public void send(String fname,String rec)
    {
        try 
        {
            
            Calendar cal=new GregorianCalendar();
            File file=new File(fname);
            String t_hr=new String();
            String t_min=new String();
            String t_sec=new String();
            String fn=rec+".jpg";
            fis=new FileInputStream(file);
            int len=fis.available();
            //System.out.println("Size:"+len);
            File f=new File("./sent/"+new Login().u);
            f.mkdirs();
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
            
            //t_sec=Integer.toString(cal.get(cal.SECOND));
            if(t_hr.equals("0"))
            {
               t_hr="12"; 
            }
            FileOutputStream fos=new FileOutputStream("./sent/"+new Login().u+"/"+t_hr+"-"+t_min+"-"+t_sec+"  "+fn);
            ps.println("file");
            ps.println(""+len);
            ps.println(new Login().u+".jpg");
            ps.println(rec);
            
            int ch=0,cnt=0;
            byte b[]=new byte[1024];
            while((ch=fis.read(b))!=-1)
            {
                cnt+=ch;
                os.write(b,0,ch);
                fos.write(b,0,ch);
                //System.out.println(cnt);
            }
            fis.close();
            ps.close();
            os.close();
            fos.close();
            
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        
        
        
    }
    public static void main(String args[])throws Exception
        {
            //new Client("localhost").send("D:/g.jpg");
        }
}
