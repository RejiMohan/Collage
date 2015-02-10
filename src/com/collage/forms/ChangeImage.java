package com.collage.forms;

import com.collage.steganography.Steganography;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;

public class ChangeImage extends javax.swing.JFrame {

    /**
     * Creates new form ChangeImage
     */
    public ChangeImage() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            cur_img.setIcon(new ImageIcon(new ViewImages().file));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        Browse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cur_img = new javax.swing.JLabel();
        new_img = new javax.swing.JLabel();
        Change = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Source");

        Browse.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Browse.setForeground(new java.awt.Color(51, 51, 51));
        Browse.setText("Browse");
        Browse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        cur_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        new_img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Change.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Change.setForeground(new java.awt.Color(51, 51, 51));
        Change.setText("Change");
        Change.setBorderPainted(false);
        Change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Back");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Change Image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax
                                                        .swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(cur_img, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(new_img, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(Change)
                                                .addGap(46, 46, 46)
                                                .addComponent(jButton2)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing
                                                .GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(cur_img, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax
                                                .swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(new_img, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax
                                                .swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Change)
                                        .addComponent(jButton2))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser jFileChooser = new JFileChooser();
        try {
            jFileChooser.showOpenDialog(this);
            String file = jFileChooser.getSelectedFile().toString();
            src.setText(file);
            new_img.setIcon(new ImageIcon(file));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void ChangeActionPerformed(java.awt.event.ActionEvent evt) {
        File f = new File(new ViewImages().file);
        String fname = f.getName().substring(0, f.getName().indexOf("."));
        String fpath = f.getParent();
        String s_path = src.getText();
        if (new Steganography().encode(src.getText(), new ViewImagePool().c, fpath)) {
            JOptionPane.showMessageDialog(null, "Character Encoded");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        File f_src = new File(s_path);
        String fn = f_src.getName().substring(0, f_src.getName().indexOf("."));
        File f_new = new File(fpath + "/" + fn + "_new.jpg");
        f.delete();
        f_new.renameTo(new File(fpath + "/" + fname + ".jpg"));

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        this.setVisible(false);
        new ViewImages().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeImage().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Browse;
    private javax.swing.JButton Change;
    private javax.swing.JLabel cur_img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel new_img;
    private javax.swing.JTextField src;


}
