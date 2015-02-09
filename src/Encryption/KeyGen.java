package Encryption;



import java.io.*;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class KeyGen implements Serializable
{
    public static SecretKey key;
    public static Cipher ecipher;

    public static void main(String[] args)
    {
        try
        {
         System.out.println("Generating Keys...");
         KeyGenerator kgen = KeyGenerator.getInstance("AES");
         kgen.init(128);
         key = kgen.generateKey();
         keyInit(key);
         byte[] bt = key.getEncoded();
         FileOutputStream fout=new FileOutputStream("KeyData.key");
         fout.write(bt);
         fout.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println("Key Generation Successfull...");
    }

    public static void keyInit(SecretKey key1)
    {
     byte[] iv = new byte[]
     {
      0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
     };

     AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
     try
     {
      ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ecipher.init(Cipher.ENCRYPT_MODE, key1, paramSpec);
     }
     catch (Exception e)
     {
      System.out.println(e);
     }
    }
}
