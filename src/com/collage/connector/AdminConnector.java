package com.collage.connector;

import com.collage.forms.UpdateImagePool;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AdminConnector implements Runnable {
    private ServerSocket serverSocket = null;
    private Socket socket = null;

    public AdminConnector() {
        try {
            serverSocket = new ServerSocket(9070);
            Thread thread = new Thread(this);
            thread.start();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    class Admin extends Thread {
        Socket socket1 = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;

        public Admin(Socket socket2) {
            try {
                socket1 = socket2;
                inputStream = socket2.getInputStream();
                dataInputStream = new DataInputStream(inputStream);
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        public void run() {
            try {
                if (dataInputStream.readLine().equals("ip")) {
                    String a = dataInputStream.readLine();
                    new UpdateImagePool().update(a);
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
                new Admin(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }

}
