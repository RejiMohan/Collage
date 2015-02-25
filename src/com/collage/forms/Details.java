package com.collage.forms;

import static javax.swing.BorderFactory.createCompoundBorder;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.GroupLayout.Alignment;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.UIManager.getDefaults;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;

public class Details extends javax.swing.JFrame {

    /**
     * Creates new form Details
     */
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private String username;
    private String a[] = new String[4];

    public Details() {
        initComponents();
        username = ClientList.getSelectedUser();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        a = databaseProcess.getUserDetails(this.username);
        hdng.setText(this.username + "'username Details");
        nameField.setText(a[0]);
        addressTextArea.setText(a[1]);
        emailField.setText(a[2]);
        designationField.setText(a[3]);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new JLabel();
        nameField = new JTextField();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        addressTextArea = new JTextArea();
        jLabel7 = new JLabel();
        emailField = new JTextField();
        jLabel3 = new JLabel();
        designationField = new JTextField();
        hdng = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(getDefaults().getColor("Button.shadow"));
        setMinimumSize(new Dimension(800, 640));

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Name");

        nameField.setEditable(false);
        nameField.setBorder(createEmptyBorder(1, 1, 1, 1));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed();
            }
        });

        jLabel8.setFont(new Font("Verdana", 0, 11));
        jLabel8.setText("Address");

        addressTextArea.setBackground(new Color(240, 240, 240));
        addressTextArea.setColumns(20);
        addressTextArea.setEditable(false);
        addressTextArea.setLineWrap(true);
        addressTextArea.setRows(3);
        addressTextArea.setBorder(createEmptyBorder(1, 1, 1, 1));
        addressTextArea.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane1.setViewportView(addressTextArea);

        jLabel7.setFont(new Font("Verdana", 0, 11));
        jLabel7.setText("E-mail");

        emailField.setEditable(false);
        emailField.setBorder(createEmptyBorder(1, 1, 1, 1));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed();
            }
        });

        jLabel3.setFont(new Font("Verdana", 0, 11));
        jLabel3.setText("Designation");

        designationField.setEditable(false);
        designationField.setBorder(createEmptyBorder(1, 1, 1, 1));

        hdng.setEditable(false);
        hdng.setFont(new Font("Cambria", 3, 18));
        hdng.setBorder(createEmptyBorder(1, 1, 1, 1));
        hdng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdngActionPerformed();
            }
        });

        jButton1.setFont(new Font("Verdana", 0, 11));
        jButton1.setForeground(new Color(51, 51, 51));
        jButton1.setText("OK");
        jButton1.setBorder(createCompoundBorder());
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new Font("Verdana", 0, 11));
        jButton2.setForeground(new Color(51, 51, 51));
        jButton2.setText("Remove User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });

        jLabel2.setIcon(new ImageIcon(""/*TODO icon location*/));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel7))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                        .addComponent(designationField)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(nameField, PREFERRED_SIZE,
                                                                176, PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(45, 45, 45)
                                                .addComponent(emailField, PREFERRED_SIZE, DEFAULT_SIZE,
                                                        PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(hdng, PREFERRED_SIZE, 215,
                                                        PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(jButton1, PREFERRED_SIZE, 42,
                                                        PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addContainerGap(489, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addGroup(layout.createParallelGroup(
                                                        Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(nameField, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jScrollPane1,
                                                                PREFERRED_SIZE, 62,
                                                                PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(
                                                        Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(designationField, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)
                                                .addGap(74, 74, 74)
                                                .addComponent(jButton1, PREFERRED_SIZE, 27,
                                                        PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createParallelGroup(TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(hdng, PREFERRED_SIZE,
                                                                41, PREFERRED_SIZE)
                                                        .addGap(19, 19, 19))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(emailField, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE)
                                                        .addGap(24, 24, 24)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jButton2)))
                                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new ClientList().setVisible(true);
    }


    private void hdngActionPerformed() {
    }

    private void nameActionPerformed() {
    }

    private void emailActionPerformed() {
    }

    private void jButton2ActionPerformed() {
        int i = 0;
        try {
            i = databaseProcess.rejectUser(username);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "User Removed");
                this.setVisible(false);
                new ClientList().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No permissions");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Details().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JTextArea addressTextArea;
    private JTextField designationField;
    private JTextField emailField;
    private JTextField hdng;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JTextField nameField;
    // End of variables declaration

}
