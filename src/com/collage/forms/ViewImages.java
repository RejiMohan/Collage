package com.collage.forms;

import com.collage.imageOper.FileFinder;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Vector;

public class ViewImages extends javax.swing.JFrame {

    /**
     * Creates new form ViewImages
     */
    public static String file = "";
    Vector f = new Vector();

    public ViewImages() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            String s = new ViewImagePool().c;
            ch.setText(s);
            f = new FileFinder().findFile(s);
            ImageIcon icon = null;

            icon = new ImageIcon(f.elementAt(0).toString());
            img1.setIcon(icon);
            icon = new ImageIcon(f.elementAt(1).toString());
            img2.setIcon(icon);
            icon = new ImageIcon(f.elementAt(2).toString());
            img3.setIcon(icon);
            icon = new ImageIcon(f.elementAt(3).toString());
            img4.setIcon(icon);
            icon = new ImageIcon(f.elementAt(4).toString());
            img5.setIcon(icon);
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
        ch = new javax.swing.JTextField();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        img4 = new javax.swing.JLabel();
        img5 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Images for ");

        img1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });

        img2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });

        img3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });

        img4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img4MouseClicked(evt);
            }
        });

        img5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        img5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img5MouseClicked(evt);
            }
        });

        Back.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Back.setForeground(new java.awt.Color(51, 51, 51));
        Back.setText("Back");
        Back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax
                                                        .swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98)
                                                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(88, 88, 88)
                                                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short
                                        .MAX_VALUE)
                                .addComponent(img5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing
                                                .GroupLayout.PREFERRED_SIZE)
                                        .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing
                                                .GroupLayout.PREFERRED_SIZE)
                                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing
                                                .GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short
                                        .MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addComponent(img5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(img4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Back)
                                                .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {
        file = f.elementAt(0).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new ViewImagePool().setVisible(true);
    }

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {
        file = f.elementAt(1).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {
        file = f.elementAt(2).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img4MouseClicked(java.awt.event.MouseEvent evt) {
        file = f.elementAt(3).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img5MouseClicked(java.awt.event.MouseEvent evt) {
        file = f.elementAt(4).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }//GEN-LAST:event_img5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewImages().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Back;
    private javax.swing.JTextField ch;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel img4;
    private javax.swing.JLabel img5;
    private javax.swing.JLabel jLabel1;

}
