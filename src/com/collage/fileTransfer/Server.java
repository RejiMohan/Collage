package com.collage.fileTransfer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server implements Runnable {

    private ServerSocket serverSocket = null;
    private Socket socket = null;

    public Server() throws Exception {
        try {
            System.out.println("Server started");
            serverSocket = new ServerSocket(9090);
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    class Receiver extends Thread {
        Socket cs = null;
        InputStream is = null;
        BufferedReader bufferedReader = null;
        FileOutputStream fos = null;

        public Receiver(Socket s) {
            try {
                cs = s;
                is = cs.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(is));
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        public void run() {
            try {
                int t_hr = LocalDateTime.now().getHour();
                int t_min = LocalDateTime.now().getMinute();
                int t_sec = LocalDateTime.now().getSecond();

                String a = bufferedReader.readLine();
                if (a.equals("file")) {
                    String size = bufferedReader.readLine();
                    int len = Integer.parseInt(size);
                    String fname = bufferedReader.readLine();
                    String rec = bufferedReader.readLine();
                    System.out.println(rec);
                    File f = new File("./inbox/" + rec);
                    f.mkdirs();
                    String target = "./inbox/" + rec + "/" + t_hr + "-" + t_min + "-" + t_sec + "  " + fname;
                    fos = new FileOutputStream(target);
                    byte b[] = new byte[1024];
                    int ch, cnt = 0;
                    while ((ch = is.read(b, 0, 1024)) != -1) {
                        cnt += ch;
                        fos.write(b, 0, ch);
                        if (cnt >= len)
                            break;
                    }
                    fos.close();
                }
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
