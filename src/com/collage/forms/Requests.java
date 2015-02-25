package com.collage.forms;

import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import static javax.swing.SwingConstants.HORIZONTAL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;

public class Requests extends javax.swing.JFrame {
    private List userList = new ArrayList();
    private DatabaseProcess dp = new DatabaseProcess();

    public Requests() {
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
        userList = dp.listUsers(0);
        userJlist.setListData(userList.toArray());
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        btnApprove = new JButton();
        btnBack = new JButton();
        btnReject = new JButton();
        jScrollPane1 = new JScrollPane();
        userJlist = new JList();
        jLabel8 = new JLabel();
        jLabel2 = new JLabel();
        jLabel7 = new JLabel();
        designationField = new JTextField();
        emailField = new JTextField();
        jScrollPane2 = new JScrollPane();
        addressTextArea = new JTextArea();
        nameField = new JTextField();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        jLabel1.setFont(new Font("Verdana", 1, 24));
        jLabel1.setText("Pending Requests");

        btnApprove.setFont(new Font("Verdana", 0, 11));
        btnApprove.setForeground(new Color(51, 51, 51));
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        btnReject.setFont(new Font("Verdana", 0, 11));
        btnReject.setForeground(new Color(51, 51, 51));
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectActionPerformed(evt);
            }
        });

        userJlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userJlist);

        jLabel8.setFont(new Font("Verdana", 0, 11));
        jLabel8.setText("Address");

        jLabel2.setFont(new Font("Verdana", 0, 11));
        jLabel2.setText("Name");

        jLabel7.setFont(new Font("Verdana", 0, 11));
        jLabel7.setText("E-mail");

        designationField.setEditable(false);
        designationField.setFont(new Font("Verdana", 0, 11));
        designationField.setBorder(createEmptyBorder(1, 1, 1, 1));

        emailField.setEditable(false);
        emailField.setFont(new Font("Verdana", 0, 11));
        emailField.setBorder(createEmptyBorder(1, 1, 1, 1));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        addressTextArea.setBackground(new Color(240, 240, 240));
        addressTextArea.setColumns(20);
        addressTextArea.setEditable(false);
        addressTextArea.setFont(new Font("Verdana", 0, 13));
        addressTextArea.setLineWrap(true);
        addressTextArea.setRows(3);
        addressTextArea.setBorder(null);
        addressTextArea.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane2.setViewportView(addressTextArea);

        nameField.setEditable(false);
        nameField.setFont(new Font("Verdana", 0, 11));
        nameField.setBorder(createEmptyBorder(1, 1, 1, 1));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("Verdana", 0, 11));
        jLabel3.setText("Designation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        186, PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(135, 135, 135)
                                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel7))
                                                                .addGap(34, 34, 34)
                                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                                        .addComponent(designationField)
                                                                        .addComponent(emailField)
                                                                        .addComponent(jScrollPane2)
                                                                        .addComponent(nameField,
                                                                                PREFERRED_SIZE, 176, PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(btnApprove,
                                                                        DEFAULT_SIZE,
                                                                        DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(btnReject)
                                                                .addPreferredGap(UNRELATED)
                                                                .addComponent(btnBack)))
                                                .addContainerGap())
                                        .addGroup(TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(133, 133, 133))))
        );

        layout.linkSize(HORIZONTAL, btnApprove, btnBack, btnReject);

        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addGroup(layout.createParallelGroup(BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(nameField, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addPreferredGap(RELATED)
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jScrollPane2,
                                                                PREFERRED_SIZE, 62,
                                                                PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel7))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(emailField,
                                                                        PREFERRED_SIZE,
                                                                        DEFAULT_SIZE,
                                                                        PREFERRED_SIZE)))
                                                .addPreferredGap(RELATED)
                                                .addGroup(layout.createParallelGroup(BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(designationField, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addPreferredGap(RELATED,
                                                        94, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(LEADING, false)
                                                        .addComponent(btnApprove)
                                                        .addGroup(TRAILING, layout
                                                                .createParallelGroup(BASELINE)
                                                                .addComponent(btnReject)
                                                                .addComponent(btnBack)))
                                                .addGap(67, 67, 67))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jScrollPane1, DEFAULT_SIZE,
                                                        338, Short.MAX_VALUE)
                                                .addGap(22, 22, 22))))
        );
        pack();
    }

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        try {
            i = dp.addUser(userJlist.getSelectedValue().toString());
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "User Approved");
                userList = dp.listUsers(0);
                userJlist.setListData(userList.toArray());
                nameField.setText("");
                addressTextArea.setText("");
                designationField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No user selected");
        }
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void RejectActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        try {
            i = dp.rejectUser(userJlist.getSelectedValue().toString());
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "User Rejected");
                userList = dp.listUsers(0);
                userJlist.setListData(userList.toArray());
                nameField.setText("");
                addressTextArea.setText("");
                designationField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No user selected");
        }
    }

    private void u_listMouseClicked(java.awt.event.MouseEvent evt) {
        String a[] = new String[4];
        try {
            String s = userJlist.getSelectedValue().toString();
            a = dp.getUserDetails(s);
            nameField.setText(a[0]);
            addressTextArea.setText(a[1]);
            emailField.setText(a[2]);
            designationField.setText(a[3]);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
                                            public void run() {
                                                new Requests().setVisible(true);
                                            }
                                        }
        );
    }

    private JButton btnApprove;
    private JButton btnBack;
    private JButton btnReject;
    private JTextArea addressTextArea;
    private JTextField designationField;
    private JTextField emailField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField nameField;
    private JList userJlist;
}
