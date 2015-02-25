package com.collage.image;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

import com.collage.encryption.Encrypt;

public class Steganography {

    public boolean encode(String file, String message) {
        String fileName = file.substring(0, file.indexOf("."));
        String fileExtension = file.substring(file.indexOf(".") + 1, file.length());
        BufferedImage originalImage = getImage(file);
        BufferedImage image = userSpace(originalImage);
        image = addText(image, message);
        return (setImage(image, new File(fileName + "_new." + fileExtension), "png"));
    }

    public String decode(String name) {
        byte[] decode;
        try {
            BufferedImage image = userSpace(getImage(name));
            decode = decodeText(getByteData(image));
            return (new Encrypt().decrypter(new String(decode)));
        } catch (Exception e) {
            return "";
        }
    }

    private BufferedImage getImage(String fileName) {
        BufferedImage image = null;
        File file = new File(fileName);
        try {
            image = ImageIO.read(file);
        } catch (Exception ex) {
            showMessageDialog(null,
                    "Image could not be read! " + fileName, "Error", ERROR_MESSAGE);
        }
        return image;
    }

    private boolean setImage(BufferedImage image, File file, String extension) {
        try {
            file.delete();
            ImageIO.write(image, extension, file);
            return true;
        } catch (Exception e) {
            showMessageDialog(null,
                    "File could not be saved!", "Error", ERROR_MESSAGE);
            return false;
        }
    }

    private BufferedImage addText(BufferedImage image, String text) {
        byte img[] = getByteData(image);
        byte msg[] = text.getBytes();
        byte len[] = bitConversion(msg.length);
        try {
            encodeText(img, len, 0);
            encodeText(img, msg, 32);
        } catch (Exception e) {
            showMessageDialog(null, "Target File cannot hold message!", "Error", ERROR_MESSAGE);
        }
        return image;
    }


    private BufferedImage userSpace(BufferedImage image) {
        BufferedImage new_img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = new_img.createGraphics();
        graphics.drawRenderedImage(image, null);
        graphics.dispose();
        return new_img;
    }


    private byte[] getByteData(BufferedImage image) {
        WritableRaster raster = image.getRaster();
        DataBufferByte buffer = (DataBufferByte) raster.getDataBuffer();
        return buffer.getData();
    }


    private byte[] bitConversion(int i) {
        byte byte3 = (byte) ((i & 0xFF000000) >>> 24);
        byte byte2 = (byte) ((i & 0x00FF0000) >>> 16);
        byte byte1 = (byte) ((i & 0x0000FF00) >>> 8);
        byte byte0 = (byte) ((i & 0x000000FF));

        return (new byte[]{byte3, byte2, byte1, byte0});
    }


    private byte[] encodeText(byte[] image, byte[] addition, int offset) {
        if (addition.length + offset > image.length) {
            throw new IllegalArgumentException("File not long enough!");
        }
        for (int i = 0; i < addition.length; ++i) {
            int add = addition[i];
            for (int bit = 7; bit >= 0; --bit, ++offset) {
                int b = (add >>> bit) & 1;
                image[offset] = (byte) ((image[offset] & 0xFE) | b);
            }
        }
        return image;
    }

    private byte[] decodeText(byte[] image) {
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
    }

}
