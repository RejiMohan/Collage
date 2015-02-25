package com.collage.forms;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;

public class Updates extends JFrame {

    private DatabaseProcess databaseProcess = new DatabaseProcess();

    /**
     * Creates new form Updates
     */
    public Updates() {
        initComponents();
        Point center = getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
            Vector v = databaseProcess.getList();
            userJList.setListData(v);
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
        btnBack = new JButton();
        btnTryAgain = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("The following Clients' Imagepools were not updated last time :");

        jScrollPane1.setViewportView(userJList);

        btnBack.setFont(new Font("Verdana", 0, 11)); // NOI18N
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed();
            }
        });

        btnTryAgain.setFont(new Font("Verdana", 0, 11)); // NOI18N
        btnTryAgain.setForeground(new Color(51, 51, 51));
        btnTryAgain.setText("Try Again");
        btnTryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tryAgainActionPerformed();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        110, PREFERRED_SIZE)
                                                .addGap(106, 106, 106)
                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                        .addComponent(btnBack, DEFAULT_SIZE,
                                                                DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnTryAgain)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)))
                                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        180, PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addComponent(btnTryAgain)
                                                .addGap(31, 31, 31)
                                                .addComponent(btnBack)))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }

    private void backActionPerformed() {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void tryAgainActionPerformed() {
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
    private JButton btnBack;
    private JButton btnTryAgain;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JList userJList;

}
