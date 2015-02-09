/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ImageOper;

import javax.swing.filechooser.FileFilter;
import java.io.*;

/**
 *
 * @author adima
 */
public class JPEGFilter extends FileFilter implements java.io.FileFilter
{
    
    public boolean accept(File ref)
    {
        if(ref.getName().endsWith(".jpeg"))
            return true;
        if(ref.getName().endsWith(".jpg"))
            return true;
        return false;
    }
    public String getDescription()
    {
        return "JPEG Files";
    }
    
}
