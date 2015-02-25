package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

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
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        userJList = new JList();
        btnViewMessage = new JButton();
        btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Estrangelo Edessa", 3, 14));
        jLabel1.setText("Sent");

        jScrollPane1.setViewportView(userJList);

        btnViewMessage.setText("View Message");
        btnViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMessageActionPerformed();
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        136, PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(83, 83, 83)
                                                                .addComponent(btnViewMessage))
                                                        .addGroup(TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnBack)
                                                                .addGap(25, 25, 25))))
                                        .addComponent(jLabel1))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        231, PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(btnViewMessage)
                                                .addGap(40, 40, 40)
                                                .addComponent(btnBack)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    private void ViewMessageActionPerformed() {
        r_name = userJList.getSelectedValue().toString();
        System.out.println("Receiver :" + r_name);
        this.setVisible(false);
        new MessageOut().setVisible(true);
    }

    private void BackActionPerformed() {
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
    private JButton btnBack;
    private JButton btnViewMessage;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JList userJList;

}
