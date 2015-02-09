/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ImageOper;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.util.*;
import FileTransfer.*;
import java.util.ArrayList;
/**
 *
 * @author adima
 */
public class Encoder 
{
    int cnt;
    
    public Encoder()
    {
        cnt=1;
    }
    public String convert(String msg)
    {
       
        String op="D:/y.jpg";
        try
        {
            BufferedImage bg=ImageIO.read(new File("D:/bg.jpg"));
            System.out.println("BG accessed");
            BufferedImage bi=null;
            ImageOverlay io=new ImageOverlay();
            for(int i=0;i<msg.length();)
            {
                
                File f=findFile(msg.charAt(i++)+"");
                System.out.println(f.getName());
                BufferedImage fg=ImageIO.read(f);
                bi=io.overlay(bg, fg);
                ImageIO.write(bi, "JPG", new File(op));
                bg=ImageIO.read(new File(op));
            }
            //new Client("localhost").send(op);
            //cnt=0;
             
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return op;
    }
    
    public File findFile(String a)
    {
        
        File dir=new File("D:/ImagePool");
        //Vector f_list=new Vector();
        int i;
        try
        {
            
            File[] f=dir.listFiles();
            for(i=0;i<f.length;i++)
            {
                if( f[i].getName().substring(0, f[i].getName().indexOf(".")).contains(a) && f[i].getName().substring(0, f[i].getName().indexOf(".")).length()%6==cnt)
                {
                    cnt++;
                    if(cnt==6)
                    {
                        cnt=1;
                    }
                    return f[i];
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
            
        }
        return null;
    }
    
    public static void main(String args[])throws Exception
    {
        new Encoder().convert("eg");
    }
    
}
