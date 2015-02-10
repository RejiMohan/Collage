package com.collage.fileTransfer;

import com.collage.forms.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.time.LocalDateTime;

public class Client {
    private Socket socket = null;
    private OutputStream outputStream = null;
    private PrintStream printStream = null;
    private FileInputStream fileInputStream = null;

    public Client(String ipAddress) {
        try {
            socket = new Socket(ipAddress, 9090);
            outputStream = socket.getOutputStream();
            printStream = new PrintStream(outputStream);
            System.out.println("Client started");
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void send(String fileName, String rec) {
        try {
            File file = new File(fileName);
            int hour = LocalDateTime.now().getHour();
            int minute = LocalDateTime.now().getMinute();
            int second = LocalDateTime.now().getSecond();

            String fn = rec + ".jpg";
            fileInputStream = new FileInputStream(file);
            int len = fileInputStream.available();
            File f = new File("./sent/" + Login.getUsername());
            f.mkdirs();

            FileOutputStream fos = new FileOutputStream("./sent/" + Login.getUsername() + "/" + hour + "-" + minute +
                    "-" + second + "  " + fn);
            printStream.println("file");
            printStream.println("" + len);
            printStream.println(Login.getUsername() + ".jpg");
            printStream.println(rec);

            int ch, cnt = 0;
            byte b[] = new byte[1024];
            while ((ch = fileInputStream.read(b)) != -1) {
                cnt += ch;
                outputStream.write(b, 0, ch);
                fos.write(b, 0, ch);
            }
            fileInputStream.close();
            printStream.close();
            outputStream.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
