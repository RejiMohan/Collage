package com.collage.steganography;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Steganography {
    public boolean encode(String sourceFile, String character, String destintaionFile) {

        try {
            //ch=new Encrypt().encryption(ch.getBytes());
            //System.out.println("Encrypted string : "+ch);
            String fileName = sourceFile.substring(0, sourceFile.indexOf("."));
            System.out.println("Fname:" + fileName);
            String file_ext = sourceFile.substring(sourceFile.indexOf(".") + 1, sourceFile.length());
            File f = new File(sourceFile);
            String f_name = f.getName();
            f_name = f_name.substring(0, f_name.indexOf("."));
            System.out.println("Filename : " + f_name);
            BufferedImage img_orig = ImageIO.read(f);
            BufferedImage img = userSpace(img_orig);
            img = addChar(img, character);
            return setImage(img, new File(destintaionFile + "/" + f_name + "_new." + file_ext), "png");

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return true;
    }

    private BufferedImage userSpace(BufferedImage img) {
        BufferedImage img1 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img1.createGraphics();
        g.drawRenderedImage(img, null);
        g.dispose();
        return img;
    }

    private BufferedImage addChar(BufferedImage image, String ch) {
        try {
            byte img[] = getByte(image);
            byte c[] = ch.getBytes();
            byte len[] = bitConvertion(ch.length());
            encodeChar(img, len, 0);
            encodeChar(img, c, 32);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return image;
    }

    private byte[] getByte(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
        return buffer.getData();
    }

    private byte[] bitConvertion(int i) {
        return (new byte[]{0, 0, 0, (byte) (i & 0x000000FF)});
    }

    private byte[] encodeChar(byte[] img, byte[] addition, int offset) {
        if (addition.length + offset > img.length) {
            throw new IllegalArgumentException("File not long enough");
        }
        int add;
        for (byte anAddition : addition) {
            add = anAddition;
            for (int bit = 7; bit >= 0; bit--, offset++) {
                int b = (add >>> bit) & 1;
                img[offset] = (byte) ((img[offset] & 0xFE) | b);
            }
        }
        return img;
    }

    private boolean setImage(BufferedImage img, File file, String ext) {
        try {
            file.delete();
            ImageIO.write(img, ext, file);
            return true;

        } catch (Exception e) {
            System.out.println("Exception " + e);
            return false;
        }
    }

    private byte[] decodeChar(byte[] image) {
        try {
            int length = 0;
            int offset = 32;
            for (int i = 0; i < 32; ++i) {
                length = (length << 1) | (image[i] & 1);
            }
            byte[] result = new byte[length];

            for (int b = 0; b < result.length; ++b) {
                for (int i = 0; i < 8; ++i, ++offset) {
                    result[b] = (byte) ((result[b] << 1) | (image[offset] & 1));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public String decode(String name) {
        byte[] decode;
        try {
            BufferedImage image = userSpace(ImageIO.read(new File(name)));
            decode = decodeChar(getByte(image));
            System.out.println(new String(decode));
            return (new String(decode));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "There is no hidden message in this image!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    public static void main(String args[]) throws Exception {
        Steganography s = new Steganography();

        if (s.encode("D:/s.jpg", "0", "D:")) {
            System.out.println("Encoded");
        }

        String a = s.decode("D:/s_new.jpg");
        //String b=new Encrypt().decrypter(a);

        System.out.println(a);
    }

}
