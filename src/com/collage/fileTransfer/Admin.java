package com.collage.fileTransfer;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Admin {
    private OutputStream outputStream = null;
    private PrintStream printStream = null;

    public Admin(String ipAddress) {
        try {
            Socket socket = new Socket(ipAddress, 9080);
            outputStream = socket.getOutputStream();
            printStream = new PrintStream(outputStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to " + ipAddress);
            System.out.println("Exception " + e);
        }
    }

    public int sendImage(String fileName) {
        int i = 0;
        int ch, cnt = 0;
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            int len = fis.available();
            printStream.println("image");
            printStream.println("" + len);
            printStream.println(file.getName());
            byte[] b = new byte[1024];
            while ((ch = fis.read(b)) != -1) {
                cnt += ch;
                outputStream.write(b, 0, ch);
            }
            fis.close();
            outputStream.close();
            i = 1;
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return i;
    }
}
