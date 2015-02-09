package com.collage.forms;

import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Vector;

public class UpdateImagePool extends javax.swing.JFrame {

    /**
     * Creates new form UpdateImagePool
     */
    DatabaseProcess dp = new DatabaseProcess();
    public static Vector users = new Vector();
    Vector v = new Vector();

    public UpdateImagePool() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            v = dp.getIPList();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ulist = new javax.swing.JList();
        Back = new javax.swing.JButton();
        TryAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Update.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Update.setForeground(new java.awt.Color(51, 51, 51));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ulist);

        Back.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Back.setForeground(new java.awt.Color(51, 51, 51));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        TryAgain.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
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
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
// TODO add your handling code here:
        try {
            File dir = new File("D:/ImagePool");
            File[] f = dir.listFiles();


            int f_cnt = 0;
            int i, j;
            for (i = 0; i < v.size(); i++) {
                for (j = 0; j < f.length; j++) {
                    //System.out.println(v.elementAt(i));
                    if (new Admin(v.elementAt(i).toString()).sendImage(f[j].toString()) == 1) {
                        f_cnt++;
                    }

                }
                if (f_cnt == f.length) {
                    JOptionPane.showMessageDialog(null, "All files sent to " + dp.getUser(v.elementAt(i).toString()));
                    if (users.contains(v.elementAt(i)))

                        users.remove(v.elementAt(i));
                    dp.setStatus(v.elementAt(i).toString(), "0");


                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool Updation of " + dp.getUser(v.elementAt(i).toString
                            ()) + " not successful");
                    if (!(users.contains(v.elementAt(i)))) {
                        users.add(v.elementAt(i).toString());
                        dp.setStatus(v.elementAt(i).toString(), "1");
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
    }//GEN-LAST:event_UpdateActionPerformed


    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
// TODO add your handling code here:
        this.setVisible(false);
        new A_home().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void TryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TryAgainActionPerformed
// TODO add your handling code here:
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
                    JOptionPane.showMessageDialog(null, "All files sent to " + dp.getUser(users.elementAt(i).toString
                            ()));
                    users.remove(i);
                    dp.setStatus(users.elementAt(i).toString(), "0");
                } else {
                    JOptionPane.showMessageDialog(null, "ImagePool updation of " + dp.getUser(users.elementAt(i)
                            .toString()) + " not successful");
                    dp.setStatus(users.elementAt(i).toString(), "1");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }//GEN-LAST:event_TryAgainActionPerformed

    public void update(String ip) {
        try {
            if (dp.getList().contains(ip)) {
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
                    dp.setStatus(ip, "0");
                } else {
                    if (!(users.contains(ip)))
                        users.add(ip);
                    dp.setStatus(ip, "1");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton TryAgain;
    private javax.swing.JButton Update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList ulist;
    // End of variables declaration//GEN-END:variables

}
