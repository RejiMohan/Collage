package com.collage.connector;

import com.collage.database.DatabaseProcess;
import com.collage.forms.Login;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class UserConnector {
    Socket socket = null;
    OutputStream outputStream = null;
    PrintStream printStream = null;
    DatabaseProcess dbProcess = new DatabaseProcess();

    public UserConnector(String ipAddress) {
        try {
            socket = new Socket(ipAddress, 9070);
            outputStream = socket.getOutputStream();
            printStream = new PrintStream(outputStream);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void connectToAdmin() {
        try {
            printStream.println("ip");
            printStream.println(dbProcess.getIP(Login.getUsername()));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

}
