package com.collage.fileTransfer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class User implements Runnable {

    private ServerSocket serverSocket = null;
    private Socket socket = null;

    public User() throws Exception {
        try {
            System.out.println("");
            serverSocket = new ServerSocket(9080);
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    class Receiver extends Thread {
        Socket socket1 = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;

        public Receiver(Socket aSocket) throws Exception {
            try {
                socket1 = aSocket;
                inputStream = socket1.getInputStream();
                dataInputStream = new DataInputStream(inputStream);
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        public void run() {
            try {
                if (dataInputStream.readLine().equals("image")) {
                    int len = Integer.parseInt(dataInputStream.readLine());
                    String fname = dataInputStream.readLine();
                    File dir = new File("D:/ImagePool");
                    dir.mkdirs();
                    File file = new File("D:/ImagePool/" + fname);
                    fileOutputStream = new FileOutputStream(file);
                    byte[] b = new byte[1024];
                    int ch = 0, cnt = 0;
                    while ((ch = inputStream.read(b, 0, 1024)) != -1) {
                        cnt += ch;
                        fileOutputStream.write(b, 0, ch);
                        if (ch >= len)
                            break;
                    }
                }
                fileOutputStream.close();
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
    }

    public void run() {
        try {
            while (true) {
                socket = serverSocket.accept();
                new Receiver(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
