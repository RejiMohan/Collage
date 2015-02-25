package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;

public class ChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form ChangePassword
     */
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private static String username = Login.getUsername();

    public ChangePassword() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        oldPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        btnOK = new JButton();
        btnCancel = new JButton();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Current Password");

        jLabel2.setFont(new Font("Verdana", 0, 11));
        jLabel2.setText("New Password");

        jLabel3.setFont(new Font("Verdana", 0, 11));
        jLabel3.setText("Retype Password");

        btnOK.setForeground(new Color(51, 51, 51));
        btnOK.setText("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                okActionPerformed();
            }
        });

        btnCancel.setForeground(new Color(51, 51, 51));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cancelActionPerformed();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnOK)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnCancel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                                        .addComponent(oldPasswordField,
                                                                                DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                                        .addComponent(newPasswordField)
                                                                        .addComponent(confirmPasswordField)))))
                                        .addGroup(TRAILING, layout
                                                .createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1, DEFAULT_SIZE, 380,
                                                        Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(oldPasswordField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, PREFERRED_SIZE, 10, PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(newPasswordField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(confirmPasswordField, PREFERRED_SIZE,
                                                DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(btnOK)
                                        .addComponent(btnCancel))
                                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }

    private void okActionPerformed() {
        String a[];
        String p = new String(oldPasswordField.getPassword());
        String np1 = new String(newPasswordField.getPassword());
        String np2 = new String(confirmPasswordField.getPassword());

        try {
            a = databaseProcess.getUserLoginDetails(username);
            if (p.equals(a[0])) {
                if (np1.equals(np2)) {
                    int k = databaseProcess.updatePassword(username, np1);
                    if (k > 0) {
                        JOptionPane.showMessageDialog(this, "Password Changed");
                        this.setVisible(false);
                        if (username.equals("admin")) {
                            new AdminHome().setVisible(true);
                        } else {
                            new UserHome().setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Error");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Passwords do not match");
                    oldPasswordField.setText("");
                    newPasswordField.setText("");
                    confirmPasswordField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Password");
            }

        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            oldPasswordField.setText("");
            newPasswordField.setText("");
            confirmPasswordField.setText("");
        }
    }

    private void cancelActionPerformed() {
        this.setVisible(false);
        if (Login.getUsername().equals("admin")) {
            new AdminHome().setVisible(true);
        } else {
            new UserHome().setVisible(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnCancel;
    private JButton btnOK;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JSeparator jSeparator1;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
}
