package com.collage.steganography;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;

public class Steganography {
    public boolean encode(String file, String ch, String d_file) {

        try {
            //ch=new Encrypt().encryption(ch.getBytes());
            //System.out.println("Encrypted string : "+ch);
            String file_name = file.substring(0, file.indexOf("."));
            System.out.println("Fname:" + file_name);
            String file_ext = file.substring(file.indexOf(".") + 1, file.length());
            File f = new File(file);
            String f_name = f.getName();
            f_name = f_name.substring(0, f_name.indexOf("."));
            System.out.println("Filename : " + f_name);
            BufferedImage img_orig = ImageIO.read(f);
            BufferedImage img = user_space(img_orig);
            img = add_char(img, ch);
            return setImage(img, new File(d_file + "/" + f_name + "_new." + file_ext), "png");

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return true;
    }

    private BufferedImage user_space(BufferedImage img) {
        BufferedImage img1 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img1.createGraphics();
        g.drawRenderedImage(img, null);
        g.dispose();
        return img;
    }

    private BufferedImage add_char(BufferedImage image, String ch) {
        try {
            byte img[] = get_byte(image);
            byte c[] = ch.getBytes();
            byte len[] = bit_con(ch.length());
            encode_char(img, len, 0);
            encode_char(img, c, 32);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return image;
    }

    private byte[] get_byte(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
        return buffer.getData();
    }

    private byte[] bit_con(int i) {
        return (new byte[]{0, 0, 0, (byte) (i & 0x000000FF)});
    }

    private byte[] encode_char(byte[] img, byte[] addition, int offset) {
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

    private byte[] decode_char(byte[] image) {
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
            //String results=new String(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public String decode(String name) {
        byte[] decode;
        try {
            BufferedImage image = user_space(ImageIO.read(new File(name)));
            decode = decode_char(get_byte(image));
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
        //System.out.println("Decoded");
        //System.out.println(b);
    }

}
