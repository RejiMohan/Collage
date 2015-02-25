package com.collage.image;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/*
 * This class implements a generic file name filter that allows the listing/selection
 * of JPEG files.
 */
public class JPEGImageFileFilter extends FileFilter implements java.io.FileFilter {

    public boolean accept(File file) {
        if (file.getName().toLowerCase().endsWith(".jpeg") || file.getName().toLowerCase().endsWith(".jpg"))
            return true;
        return false;
    }

    public String getDescription() {
        return "JPEG files";
    }

}
