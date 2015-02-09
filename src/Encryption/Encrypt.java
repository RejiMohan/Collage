package Encryption;


import java.io.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Encrypt {

    Cipher ecipher;
    SecretKey key;
    byte[] buf = new byte[1024];

   
    public Encrypt() {
        
    }
    public String encryption(byte [] data)
    {
        byte enc[] = new byte[1024];
        String str="";
        try {
            FileInputStream fin = new FileInputStream("KeyData.key");
            byte[] bt = new byte[fin.available()];
            fin.read(bt);
            fin.close();
            key = new SecretKeySpec(bt, "AES");
            keyInit(key);
            SecretKeySpec key1 = new SecretKeySpec(bt, "AES");
            Operator encrypter = new Operator(key1);
            ByteArrayInputStream bin = new ByteArrayInputStream(data);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout = encrypter.encrypt(bin, bout);
            enc = bout.toByteArray();
            BASE64Encoder be = new BASE64Encoder();
            str = be.encode(enc);
          
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return  str;
    }
    public String decrypter( String bc)
    {
        String dec = "";
        try 
        {
            BASE64Decoder de = new BASE64Decoder();
            byte[] bo = de.decodeBuffer(bc);
        FileInputStream fin = new FileInputStream("KeyData.key");
            byte[] bt = new byte[fin.available()];
            fin.read(bt);
            fin.close();
            key = new SecretKeySpec(bt, "AES");
            keyInit(key);
            SecretKeySpec key1 = new SecretKeySpec(bt, "AES");
            Operator encrypter = new Operator(key1);
        ByteArrayInputStream binn=new ByteArrayInputStream(bo);

            ByteArrayOutputStream bouu = new ByteArrayOutputStream();
          dec=  encrypter.decrypt(binn, bouu); 
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return dec;
    }

    

    public void keyInit(SecretKey key1) {
        byte[] iv = new byte[]{
            0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
        };

        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
        try {
            ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(Cipher.ENCRYPT_MODE, key1, paramSpec);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void startfencription(byte[] data) {

        try {
           
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
