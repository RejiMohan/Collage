package com.collage.image;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/*
 * This class implements a generic file name filter that allows the listing/selection
 * of JPEG files.
 */
public class JPEGImageFileFilter extends FileFilter implements java.io.FileFilter {
    public boolean accept(File f) {
        if (f.getName().toLowerCase().endsWith(".jpeg")) return true;
        if (f.getName().toLowerCase().endsWith(".jpg")) return true;
        return false;
    }

    public String getDescription() {
        return "JPEG files";
    }

}
