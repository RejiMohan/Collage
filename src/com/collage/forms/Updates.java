package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Vector;

public class Updates extends javax.swing.JFrame {

    private DatabaseProcess databaseProcess = new DatabaseProcess();

    /**
     * Creates new form Updates
     */
    public Updates() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Vector v = databaseProcess.getList();
            ulist.setListData(v);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ulist = new javax.swing.JList();
        Back = new javax.swing.JButton();
        TryAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("The following Clients' Imagepools were not updated last time :");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(106, 106, 106)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(TryAgain)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)))
                                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(TryAgain)
                                                .addGap(31, 31, 31)
                                                .addComponent(Back)))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void TryAgainActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updates().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Back;
    private javax.swing.JButton TryAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList ulist;

}
