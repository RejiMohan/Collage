package com.collage.connector;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import com.collage.database.DatabaseProcess;
import com.collage.forms.Login;

public class UserConnector {
    private Socket socket = null;
    private OutputStream outputStream = null;
    private PrintStream printStream = null;
    private DatabaseProcess dbProcess = new DatabaseProcess();

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
            printStream.println(dbProcess.getIpAddress(Login.getUsername()));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

}
