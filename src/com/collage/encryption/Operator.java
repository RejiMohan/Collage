package com.collage.encryption;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;

public class Operator {

    private Cipher encryptionCipher;
    private Cipher decryptionCipher;

    private byte[] buf = new byte[1024];

    public Operator(SecretKey key) {
        byte[] iv = new byte[]
                {
                        0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f
                };
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
        try {
            encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            encryptionCipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            decryptionCipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ByteArrayOutputStream encrypt(InputStream in, ByteArrayOutputStream outt) {
        try {
            OutputStream out = outt;
            out = new CipherOutputStream(out, encryptionCipher);
            int numRead = 0;
            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return outt;
    }

    public String decrypt(ByteArrayInputStream inn, ByteArrayOutputStream out) {
        String dec = "";
        try {
            InputStream in = inn;
            in = new CipherInputStream(in, decryptionCipher);
            int numRead = 0;
            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
            //out.close();
            byte h[] = out.toByteArray();
            System.out.println("Encrypted String " + new String(h));
            dec = new String(h);
        } catch (Exception e) {
            System.out.println(e);
        }
        return dec;
    }
}
