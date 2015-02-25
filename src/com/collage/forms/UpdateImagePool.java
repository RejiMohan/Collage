package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Admin;

public class UpdateImagePool extends javax.swing.JFrame {

    /**
     * Creates new form UpdateImagePool
     */
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private static Vector users = new Vector();
    private List ipList = new ArrayList();

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

        btnUpdate = new JButton();
        jScrollPane1 = new JScrollPane();
        ulist = new JList();
        btnBack = new JButton();
        btnTryAgain = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnUpdate.setFont(new java.awt.Font("Verdana", 0, 11));
        btnUpdate.setForeground(new java.awt.Color(51, 51, 51));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed();
            }
        });

        jScrollPane1.setViewportView(ulist);

        btnBack.setFont(new java.awt.Font("Verdana", 0, 11));
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        btnTryAgain.setFont(new java.awt.Font("Verdana", 0, 11));
        btnTryAgain.setForeground(new java.awt.Color(51, 51, 51));
        btnTryAgain.setText("Try Again");
        btnTryAgain.setEnabled(false);
        btnTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TryAgainActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(btnBack)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        98, PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(btnTryAgain))
                                        .addComponent(btnUpdate))
                                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnUpdate)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, 140, PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack)
                                .addContainerGap(26, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(150, Short.MAX_VALUE)
                                .addComponent(btnTryAgain)
                                .addGap(127, 127, 127))
        );

        pack();
    }

    private void UpdateActionPerformed() {
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
                    JOptionPane.showMessageDialog(null, "All files sent to " + databaseProcess
                            .getUsernameFromIpAddress(ipList.get(i)
                            .toString()));
                    if (users.contains(ipList.get(i)))

                        users.remove(ipList.get(i));
                    databaseProcess.setStatus(ipList.get(i).toString(), "0");
                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool Updation of " + databaseProcess.getUsernameFromIpAddress(ipList.get
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
                btnTryAgain.setEnabled(true);
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
            File[] files = dir.listFiles();
            int fileCount = 0;
            for (int i = 0; i < users.size(); i++) {
                for (File file : files) {
                    if (new Admin(users.elementAt(i).toString()).sendImage(file.toString()) == 1) {
                        fileCount++;
                    }
                }
                if (fileCount == files.length) {
                    JOptionPane.showMessageDialog(null, "All files sent to " + databaseProcess.getUsernameFromIpAddress(users
                            .elementAt(i).toString
                                    ()));
                    users.remove(i);
                    databaseProcess.setStatus(users.elementAt(i).toString(), "0");
                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool updation of " + databaseProcess.getUsernameFromIpAddress(users
                            .elementAt(i)
                            .toString()) + " not successful");
                    databaseProcess.setStatus(users.elementAt(i).toString(), "1");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    public void update(String ipAddress) {
        try {
            if (databaseProcess.getList().contains(ipAddress)) {
                File dir = new File("D:/ImagePool");
                File[] files = dir.listFiles();
                int fileCount = 0;

                for (File file : files) {
                    if (new Admin(ipAddress).sendImage(file.toString()) == 1) {
                        fileCount++;
                    }
                }
                if (fileCount == files.length) {
                    if (users.contains(ipAddress))
                        users.remove(ipAddress);
                    databaseProcess.setStatus(ipAddress, "0");
                } else {
                    if (!(users.contains(ipAddress)))
                        users.add(ipAddress);
                    databaseProcess.setStatus(ipAddress, "1");
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
    private JButton btnBack;
    private JButton btnTryAgain;
    private JButton btnUpdate;
    private JScrollPane jScrollPane1;
    private JList ulist;
}
