package com.collage.imageOper;

import java.io.File;
import java.util.ArrayList;

public class FileFinder {

    /**
     * Finds the images corresponding to the character
     *
     * @param character
     * @return
     */
    public ArrayList getImages(String character) {
        ArrayList imageList = new ArrayList();
        try {
            int count = 0;
            File directory = new File("D:/ImagePool");
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.getName().substring(0, file.getName().indexOf(".")).contains(character)) {
                    imageList.add(file);
                    count++;
                    if (count == 5) {
                        return imageList;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return imageList;
    }

}
