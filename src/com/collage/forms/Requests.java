package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Requests extends javax.swing.JFrame {
    List v = new ArrayList();
    DatabaseProcess dp = new DatabaseProcess();

    public Requests() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        v = dp.listUsers(0);
        u_list.setListData(v.toArray());

    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        Approve = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Reject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        u_list = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dsgn = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        adrs = new javax.swing.JTextArea();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); 
        jLabel1.setText("Pending Requests");

        Approve.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Approve.setForeground(new java.awt.Color(51, 51, 51));
        Approve.setText("Approve");
        Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Back.setForeground(new java.awt.Color(51, 51, 51));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Reject.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Reject.setForeground(new java.awt.Color(51, 51, 51));
        Reject.setText("Reject");
        Reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectActionPerformed(evt);
            }
        });

        u_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(u_list);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel8.setText("Address");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel2.setText("Name");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel7.setText("E-mail");

        dsgn.setEditable(false);
        dsgn.setFont(new java.awt.Font("Verdana", 0, 11)); 
        dsgn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        email.setEditable(false);
        email.setFont(new java.awt.Font("Verdana", 0, 11)); 
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        adrs.setBackground(new java.awt.Color(240, 240, 240));
        adrs.setColumns(20);
        adrs.setEditable(false);
        adrs.setFont(new java.awt.Font("Verdana", 0, 13)); 
        adrs.setLineWrap(true);
        adrs.setRows(3);
        adrs.setBorder(null);
        adrs.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane2.setViewportView(adrs);

        name.setEditable(false);
        name.setFont(new java.awt.Font("Verdana", 0, 11)); 
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel3.setText("Designation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(135, 135, 135)
                                                                .addGroup(layout.createParallelGroup(javax.swing
                                                                        .GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel7))
                                                                .addGap(34, 34, 34)
                                                                .addGroup(layout.createParallelGroup(javax.swing
                                                                        .GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(dsgn)
                                                                        .addComponent(email)
                                                                        .addComponent(jScrollPane2)
                                                                        .addComponent(name, javax.swing.GroupLayout
                                                                                .PREFERRED_SIZE, 176, javax.swing
                                                                                .GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(Approve, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(Reject)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.UNRELATED)
                                                                .addComponent(Back)))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(133, 133, 133))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, Approve, Back, Reject);

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE, 62, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel7))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(email, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(dsgn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        94, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addComponent(Approve)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createParallelGroup(javax.swing.GroupLayout
                                                                        .Alignment.BASELINE)
                                                                .addComponent(Reject)
                                                                .addComponent(Back)))
                                                .addGap(67, 67, 67))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        338, Short.MAX_VALUE)
                                                .addGap(22, 22, 22))))
        );

        pack();
    }

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        try {
            i = dp.addUser(u_list.getSelectedValue().toString());
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "User Approved");
                v = dp.listUsers(0);
                u_list.setListData(v.toArray());
                name.setText("");
                adrs.setText("");
                dsgn.setText("");
                email.setText("");
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
            i = dp.rejectUser(u_list.getSelectedValue().toString());
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "User Rejected");
                v = dp.listUsers(0);
                u_list.setListData(v.toArray());
                name.setText("");
                adrs.setText("");
                dsgn.setText("");
                email.setText("");
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
            String s = u_list.getSelectedValue().toString();
            a = dp.showDetails(s);
            name.setText(a[0]);
            adrs.setText(a[1]);
            email.setText(a[2]);
            dsgn.setText(a[3]);
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

    private javax.swing.JButton Approve;
    private javax.swing.JButton Back;
    private javax.swing.JButton Reject;
    private javax.swing.JTextArea adrs;
    private javax.swing.JTextField dsgn;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JList u_list;


}
