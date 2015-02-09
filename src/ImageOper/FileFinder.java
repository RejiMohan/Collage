/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ImageOper;

import java.io.*;
import java.util.*;

/**
 *
 * @author adima
 */
public class FileFinder 
{
    public Vector findFile(String ch)
    {
        File[] files=null;
        Vector v=new Vector();
        try
        {
            int cnt=0;
            File dir=new File("D:/ImagePool");
            File[] f=dir.listFiles();
            
            for(int i=0;i<f.length;i++)
            {
                if(f[i].getName().substring(0, f[i].getName().indexOf(".")).contains(ch))
                {
                    //System.out.println(f[i].toString());
                    v.add(f[i]);
                    cnt++;
                    if(cnt==5)
                    {
                        return v;
                    }
                }
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return v;
    }

}
