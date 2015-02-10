package com.collage.imageOper;

import java.io.File;
import java.util.Vector;

public class FileFinder {
    public Vector findFile(String ch) {
        Vector v = new Vector();
        try {
            int count = 0;
            File directory = new File("D:/ImagePool");
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.getName().substring(0, file.getName().indexOf(".")).contains(ch)) {
                    //System.out.println(f[i].toString());
                    v.add(file);
                    count++;
                    if (count == 5) {
                        return v;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return v;
    }

}
