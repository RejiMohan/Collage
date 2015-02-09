/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FileTransfer;

import java.net.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author adima
 */
public class Admin 
{
    Socket s=null;
    OutputStream os=null;
    PrintStream ps=null;
    
    public Admin(String ip)
    {
        try
        {
            s=new Socket(ip,9080);
            os=s.getOutputStream();
            ps=new PrintStream(os);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cannot connect to "+ip);
            System.out.println("Exception "+e);
        }
    }
    
    public int sendImage(String fname)
    {
        int i=0;
        try 
        {
            File file=new File(fname);
            FileInputStream fis=new FileInputStream(file);
            int len=fis.available();
            ps.println("image");
            ps.println(""+len);
            ps.println(file.getName());
            int ch=0,cnt=0;
            byte[] b=new byte[1024];
            while((ch=fis.read(b))!=-1)
            {
                cnt+=ch;
                os.write(b,0,ch);
            }
            fis.close();
            os.close();
            i=1;
        }
        catch (Exception e)
        {
            System.out.println("Exception "+e);
        }
        return i;
    }
            

}
