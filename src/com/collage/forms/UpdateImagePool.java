package com.collage.forms;

import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Admin;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UpdateImagePool extends javax.swing.JFrame {

    /**
     * Creates new form UpdateImagePool
     */
    DatabaseProcess databaseProcess = new DatabaseProcess();
    public static Vector users = new Vector();
    List ipList = new ArrayList();

    public UpdateImagePool() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ipList = databaseProcess.getIPList();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void initComponents() {

        Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ulist = new javax.swing.JList();
        Back = new javax.swing.JButton();
        TryAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Update.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Update.setForeground(new java.awt.Color(51, 51, 51));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ulist);

        Back.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Back.setForeground(new java.awt.Color(51, 51, 51));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        TryAgain.setFont(new java.awt.Font("Verdana", 0, 11)); 
        TryAgain.setForeground(new java.awt.Color(51, 51, 51));
        TryAgain.setText("Try Again");
        TryAgain.setEnabled(false);
        TryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TryAgainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Back)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(TryAgain))
                                        .addComponent(Update))
                                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(Update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Back)
                                .addContainerGap(26, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(150, Short.MAX_VALUE)
                                .addComponent(TryAgain)
                                .addGap(127, 127, 127))
        );

        pack();
    }

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            File dir = new File("D:/ImagePool");
            File[] f = dir.listFiles();

            int f_cnt = 0;
            for (int i = 0; i < ipList.size(); i++) {
                for (int j = 0; j < f.length; j++) {
                    //System.out.println(userList.elementAt(i));
                    if (new Admin(ipList.get(i).toString()).sendImage(f[j].toString()) == 1) {
                        f_cnt++;
                    }
                }
                if (f_cnt == f.length) {
                    JOptionPane.showMessageDialog(null, "All files sent to " + databaseProcess.getUser(ipList.get(i)
                            .toString()));
                    if (users.contains(ipList.get(i)))

                        users.remove(ipList.get(i));
                    databaseProcess.setStatus(ipList.get(i).toString(), "0");
                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool Updation of " + databaseProcess.getUser(ipList.get
                            (i).toString
                            ()) + " not successful");
                    if (!(users.contains(ipList.get(i)))) {
                        users.add(ipList.get(i).toString());
                        databaseProcess.setStatus(ipList.get(i).toString(), "1");
                    }
                }
                f_cnt = 0;
            }
            if (users.size() > 0) {
                TryAgain.setEnabled(true);
                ulist.setListData(users);
            }
            for (int k = 0; k < users.size(); k++)
                System.out.println(users.elementAt(k));

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }


    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void TryAgainActionPerformed(ActionEvent evt) {
        try {
            File dir = new File("D:/ImagePool");
            File[] f = dir.listFiles();
            int f_cnt = 0;
            for (int i = 0; i < users.size(); i++) {
                for (int j = 0; j < f.length; j++) {
                    if (new Admin(users.elementAt(i).toString()).sendImage(f[j].toString()) == 1) {
                        f_cnt++;
                    }
                }
                if (f_cnt == f.length) {
                    JOptionPane.showMessageDialog(null, "All files sent to " + databaseProcess.getUser(users
                            .elementAt(i).toString
                            ()));
                    users.remove(i);
                    databaseProcess.setStatus(users.elementAt(i).toString(), "0");
                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool updation of " + databaseProcess.getUser(users
                            .elementAt(i)
                            .toString()) + " not successful");
                    databaseProcess.setStatus(users.elementAt(i).toString(), "1");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void update(String ip) {
        try {
            if (databaseProcess.getList().contains(ip)) {
                File dir = new File("D:/ImagePool");
                File[] f = dir.listFiles();
                int f_cnt = 0;

                for (int i = 0; i < f.length; i++) {
                    if (new Admin(ip).sendImage(f[i].toString()) == 1) {
                        f_cnt++;
                    }
                }
                if (f_cnt == f.length) {
                    if (users.contains(ip))
                        users.remove(ip);
                    databaseProcess.setStatus(ip, "0");
                } else {
                    if (!(users.contains(ip)))
                        users.add(ip);
                    databaseProcess.setStatus(ip, "1");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateImagePool().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Back;
    private javax.swing.JButton TryAgain;
    private javax.swing.JButton Update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList ulist;
}
