package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.*;
import java.awt.*;

public class Registration extends JFrame {

    private DatabaseProcess databaseProcess = new DatabaseProcess();

    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        name = new JTextField();
        dsgn = new JTextField();
        uname = new JTextField();
        pword = new JPasswordField();
        pword1 = new JPasswordField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        adrs = new JTextArea();
        jLabel7 = new JLabel();
        email = new JTextField();
        jButton3 = new JButton();
        jLabel9 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText("Name");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel3.setText("Designation");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel6.setText("Retype Password");

        jButton1.setFont(new java.awt.Font("Verdana", 0, 11));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new Font("Verdana", 0, 11));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24));
        jLabel2.setText("Account Details");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel8.setText("Address");

        adrs.setColumns(20);
        adrs.setRows(3);
        jScrollPane1.setViewportView(adrs);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel7.setText("E-mail");

        jButton3.setFont(new java.awt.Font("Verdana", 0, 11));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new ImageIcon("C:\\Documents and Settings\\Sreedutt\\My " +
                "Documents\\NetBeansProjects\\Collage Steganography\\src\\Forms\\Img\\images.jpg"));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addComponent(pword1)
                                                        .addComponent(pword)
                                                        .addComponent(uname)
                                                        .addComponent(dsgn)
                                                        .addComponent(email)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(name, GroupLayout.PREFERRED_SIZE,
                                                                176, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton1)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement
                                                                .RELATED)
                                                        .addComponent(jButton2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement
                                                                .RELATED)
                                                        .addComponent(jButton3))
                                                .addComponent(jLabel2)))
                                .addContainerGap(206, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(598, Short.MAX_VALUE)
                                .addComponent(jLabel9))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, jButton1, jButton2, jButton3);

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(name, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                        62, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(email, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dsgn, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(uname, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pword, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pword1, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0, j = 0;
        String n;
        String a;
        String e;
        String d;
        String username;
        String p;
        String p1;
        boolean usernameAlreadyExists;
        //String b[]=new String[3];
        try {
            n = name.getText();
            a = adrs.getText();
            e = email.getText();
            d = dsgn.getText();
            username = uname.getText();
            p = pword.getText();
            p1 = pword1.getText();
            usernameAlreadyExists = databaseProcess.isAlreadyExistingUsername(username);

            if (usernameAlreadyExists) {
                JOptionPane.showMessageDialog(this, "Username not available");
            } else if (n.equals("") || a.equals("") || e.equals("") || d.equals("") || username.equals("") || p
                    .equals("")) {
                JOptionPane.showMessageDialog(this, "No field can be left blank");
            } else if (p.equals(p1)) {
                i = databaseProcess.update(n, a, e, d, username);
                j = databaseProcess.updatel(username, p);
                if (i >= 1) {
                    JOptionPane.showMessageDialog(this, "Request sent successfully");
                    this.setVisible(false);
                    new Login().show();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            }
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        name.setText("");
        adrs.setText("");
        email.setText("");
        dsgn.setText("");
        uname.setText("");
        pword.setText("");
        pword1.setText("");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JTextArea adrs;
    private JTextField dsgn;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JTextField name;
    private JPasswordField pword;
    private JPasswordField pword1;
    private JTextField uname;
}
