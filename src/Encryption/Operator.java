package Encryption;



import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
 
import java.security.spec.AlgorithmParameterSpec;
 
public class Operator
{
	Cipher ecipher;
	Cipher dcipher;
   

	
	public Operator(SecretKey key)
	{
  	 byte[] iv = new byte[]
 	 {
	  0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
	 };
  	 AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
	 try
	 {
	  ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	  dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
  	  ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
	  dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	 }
	 catch (Exception e)
	 {
	  System.out.println(e);
	 }
	}
	
	byte[] buf = new byte[1024];
	
	public ByteArrayOutputStream encrypt(InputStream in, ByteArrayOutputStream outt)
	{
 	 try
	 {
            OutputStream out=outt;
  	  out = new CipherOutputStream(out, ecipher);
 	  int numRead = 0;
	  while ((numRead = in.read(buf)) >= 0)
	  {
	   out.write(buf, 0, numRead);
	  }
	  out.close();
	  
         }
	 catch (Exception e)
	 {System.out.println(e);}
        return  outt;
	}
	
	public String decrypt(ByteArrayInputStream inn, ByteArrayOutputStream out)
	{
            String dec="";
		try
		{
                   InputStream in=inn;
		 in = new CipherInputStream(in, dcipher);
		 int numRead = 0;
		 while ((numRead = in.read(buf)) >= 0)
		 {
		  out.write(buf, 0, numRead);
		 }
		 //out.close();
		 byte h[]=out.toByteArray();
                    System.out.println("Encrypted String "+new String(h));
                    dec = new String(h);
                }
               
		catch (Exception e)
		{System.out.println(e);}
                return dec;
	}
}
