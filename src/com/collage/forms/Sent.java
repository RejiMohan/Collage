package com.collage.forms;

import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Sent extends javax.swing.JFrame {

    /**
     * Creates new form Sent
     */
    public static String r_name = "";

    public Sent() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            List userList = new ArrayList();
            File dir = new File("./sent/" + Login.getUsername());

            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
                userList.add(files[i].getName().substring(0, files[i].getName().indexOf(".")));
            }
            userJList.setListData(userList.toArray());
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
        userJList = new javax.swing.JList();
        ViewMessage = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Estrangelo Edessa", 3, 14));
        jLabel1.setText("Sent");

        jScrollPane1.setViewportView(userJList);

        ViewMessage.setText("View Message");
        ViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMessageActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(83, 83, 83)
                                                                .addComponent(ViewMessage))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED, javax.swing
                                                                        .GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Back)
                                                                .addGap(25, 25, 25))))
                                        .addComponent(jLabel1))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(ViewMessage)
                                                .addGap(40, 40, 40)
                                                .addComponent(Back)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void ViewMessageActionPerformed(java.awt.event.ActionEvent evt) {
        r_name = userJList.getSelectedValue().toString();
        System.out.println("Receiver :" + r_name);
        this.setVisible(false);
        new MessageOut().setVisible(true);
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new UserHome().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sent().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Back;
    private javax.swing.JButton ViewMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList userJList;

}
