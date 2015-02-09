package com.collage.fileTransfer;

import com.collage.forms.Login;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Client {
    private Socket socket = null;
    private OutputStream outputStream = null;
    private PrintStream printStream = null;
    private FileInputStream fileInputStream = null;

    public Client(String ip) {
        try {
            socket = new Socket(ip, 9090);
            outputStream = socket.getOutputStream();
            printStream = new PrintStream(outputStream);
            System.out.println("Client started");
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void send(String fname, String rec) {
        try {
            Calendar cal = new GregorianCalendar();
            File file = new File(fname);
            String t_hr = new String();
            String t_min = new String();
            String t_sec = new String();
            String fn = rec + ".jpg";
            fileInputStream = new FileInputStream(file);
            int len = fileInputStream.available();
            //System.out.println("Size:"+len);
            File f = new File("./sent/" + Login.getUsername());
            f.mkdirs();
            int hr = cal.get(Calendar.HOUR_OF_DAY);
            if (hr < 10) {
                t_hr = "0" + Integer.toString(hr);
            } else {
                t_hr = Integer.toString(hr);
            }
            int min = cal.get(Calendar.MINUTE);
            if (min < 10) {
                t_min = "0" + Integer.toString(min);
            } else {
                t_min = Integer.toString(min);
            }
            int sec = cal.get(Calendar.SECOND);
            if (sec < 10) {
                t_sec = "0" + Integer.toString(sec);
            } else {
                t_sec = Integer.toString(sec);
            }

            //t_sec=Integer.toString(cal.get(cal.SECOND));
            if (t_hr.equals("0")) {
                t_hr = "12";
            }
            FileOutputStream fos = new FileOutputStream("./sent/" + Login.getUsername() + "/" + t_hr + "-" + t_min +
                    "-" +
                    t_sec + "  " + fn);
            printStream.println("file");
            printStream.println("" + len);
            printStream.println(Login.getUsername() + ".jpg");
            printStream.println(rec);

            int ch = 0, cnt = 0;
            byte b[] = new byte[1024];
            while ((ch = fileInputStream.read(b)) != -1) {
                cnt += ch;
                outputStream.write(b, 0, ch);
                fos.write(b, 0, ch);
                //System.out.println(cnt);
            }
            fileInputStream.close();
            printStream.close();
            outputStream.close();
            fos.close();

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }


    }

    public static void main(String args[]) throws Exception {
        //new Client("localhost").send("D:/g.jpg");
    }
}
