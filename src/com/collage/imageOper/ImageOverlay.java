package com.collage.imageOper;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageOverlay {
    private static int x = 0;
    private static int y = 0;
    private static int z = 0;

    public ImageOverlay() {
        x = 0;
        y = 0;
        z = 0;
    }

    public BufferedImage overlay(BufferedImage bg, BufferedImage fg) {
        try {
            Graphics2D g = bg.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawImage(bg, 0, 0, null);
            int w = bg.getWidth();
            int h = bg.getHeight();

            //int k=0;
            /*for(int i=0;i<10;i++)
            {
                for(int j=0;j<5;j++)
                {
                    g.drawImage(fg, x, y, 30, 30, null);
                    x+=30;
                    
                }
                y+=30;
            }*/

            g.drawImage(fg, x, y, 50, 50, null);
            z++;
            x += 50;
            if (z >= w / 50) {
                x = 0;
                y += 50;
                z = 0;
            }
            g.dispose();

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return bg;
    }
    
    /*public static void main(String args[])throws Exception
    {
        try{
        ImageOverlay ob=new ImageOverlay();
        BufferedImage bg=ImageIO.read(new File("D:/e.jpg"));
        BufferedImage fg=null;
        File f=new File("D:/b");
        File[] files=f.listFiles();
        for(int i=0;i<files.length;i++)
        {
            fg=ImageIO.read(files[i]);
            
            BufferedImage bi=ob.overlay(bg, fg);
            ImageIO.write(bi, "JPG", new File("D:/e.jpg"));
            bg=ImageIO.read(new File("D:/e.jpg"));
        }
        }
        catch(Exception e)
        {
            System.out.println("Exception in main "+e);
        }
        
    }*/
}
