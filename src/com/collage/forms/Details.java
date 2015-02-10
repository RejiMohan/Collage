package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class Details extends javax.swing.JFrame {

    /**
     * Creates new form Details
     */
    private DatabaseProcess dp = new DatabaseProcess();
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
        a = dp.showDetails(this.username);
        hdng.setText(this.username + "'username Details");
        name.setText(a[0]);
        adrs.setText(a[1]);
        email.setText(a[2]);
        dsgn.setText(a[3]);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adrs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dsgn = new javax.swing.JTextField();
        hdng = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        setMinimumSize(new java.awt.Dimension(800, 640));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel1.setText("Name");

        name.setEditable(false);
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel8.setText("Address");

        adrs.setBackground(new java.awt.Color(240, 240, 240));
        adrs.setColumns(20);
        adrs.setEditable(false);
        adrs.setLineWrap(true);
        adrs.setRows(3);
        adrs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        adrs.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane1.setViewportView(adrs);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel7.setText("E-mail");

        email.setEditable(false);
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel3.setText("Designation");

        dsgn.setEditable(false);
        dsgn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        hdng.setEditable(false);
        hdng.setFont(new java.awt.Font("Cambria", 3, 18)); 
        hdng.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        hdng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hdngActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Remove User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Sreedutt\\My " +
                "Documents\\NetBeansProjects\\Collage Steganography\\src\\Forms\\Img\\images.jpg")); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel7))
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addComponent(dsgn)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(45, 45, 45)
                                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout
                                                        .PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(hdng, javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(489, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE, 62, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(dsgn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)
                                                .addGap(74, 74, 74)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(hdng, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(19, 19, 19))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE)
                                                        .addGap(24, 24, 24)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jButton2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new ClientList().setVisible(true);
    }


    private void hdngActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = 0;
        try {
            i = dp.rejectUser(username);
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
    private javax.swing.JTextArea adrs;
    private javax.swing.JTextField dsgn;
    private javax.swing.JTextField email;
    private javax.swing.JTextField hdng;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    // End of variables declaration

}
