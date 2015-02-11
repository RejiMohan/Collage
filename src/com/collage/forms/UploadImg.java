package com.collage.forms;

import com.collage.encryption.Encrypt;
import com.collage.imageOper.FileFinder;
import com.collage.steganography.Steganography;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.util.Vector;

public class UploadImg extends javax.swing.JFrame {

    /**
     * Creates new form UploadImg
     */
    public UploadImg() {
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
        dstn.setText("C:/Users/adima/Desktop/Project/ImagePool");
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        BrowseSource = new javax.swing.JButton();
        ch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dstn = new javax.swing.JTextField();
        BrowseDestn = new javax.swing.JButton();
        Upload = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText("Source Image");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18));
        jLabel2.setText("Upload Image");

        BrowseSource.setFont(new java.awt.Font("Verdana", 0, 11));
        BrowseSource.setForeground(new java.awt.Color(51, 51, 51));
        BrowseSource.setText("Browse");
        BrowseSource.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BrowseSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseSourceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel3.setText("Character");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel4.setText("Destination Path");

        BrowseDestn.setFont(new java.awt.Font("Verdana", 0, 11));
        BrowseDestn.setForeground(new java.awt.Color(51, 51, 51));
        BrowseDestn.setText("Browse");
        BrowseDestn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BrowseDestn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseDestnActionPerformed(evt);
            }
        });

        Upload.setFont(new java.awt.Font("Verdana", 0, 11));
        Upload.setForeground(new java.awt.Color(51, 51, 51));
        Upload.setText("Upload");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Verdana", 0, 11));
        Clear.setForeground(new java.awt.Color(51, 51, 51));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel3))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing
                                                                        .GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(dstn, javax.swing.GroupLayout
                                                                                .Alignment.LEADING)
                                                                        .addComponent(src, javax.swing.GroupLayout
                                                                                .Alignment.LEADING, javax.swing
                                                                                .GroupLayout.DEFAULT_SIZE, 200, Short
                                                                                .MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(Upload)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(Clear)
                                                                                .addGap(23, 23, 23)
                                                                                .addComponent(Back)))
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing
                                                                        .GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(BrowseDestn, javax.swing
                                                                                        .GroupLayout.DEFAULT_SIZE, javax
                                                                                        .swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(BrowseSource, javax.swing
                                                                                        .GroupLayout.Alignment
                                                                                        .LEADING, javax
                                                                                        .swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BrowseSource, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax
                                                .swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short
                                        .MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dstn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BrowseDestn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax
                                                .swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Back)
                                        .addComponent(Clear)
                                        .addComponent(Upload))
                                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {

        src.setText("");
        ch.setText("");
        dstn.setText("");
    }

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            File dir = new File("D:/ImagePool");

            String s_file = src.getText();
            String c = ch.getText();
            String dfilename = "";
            int i = 1;
            //File[] f=dir.listFiles();
            Vector v = new Vector();
            String enc_ch = new Encrypt().encryption(c.getBytes());
            String d_file = dstn.getText();
            if (new Steganography().encode(s_file, enc_ch, d_file)) {
                JOptionPane.showMessageDialog(this, "Character Encoded");
                File sfile = new File(s_file);
                String sfname = sfile.getName().substring(0, sfile.getName().indexOf("."));
                System.out.println("Source File : " + sfname);
                v = new FileFinder().findFile(c);
                for (int k = 0; k < v.size(); k++) {
                    System.out.println(v.elementAt(k));
                }
                System.out.println("Size : " + v.size());
                if (v.size() == 0) {
                    i = 0;
                }

                File dfile = new File(v.elementAt(v.size() - i).toString());
                String dfname = dfile.getName().substring(0, dfile.getName().indexOf("."));
                if (dfname.length() >= 5) {
                    dfilename = c;
                    File f = new File(d_file + "/" + sfname + "_new.jpg");
                    File del = new File(d_file + "/" + c + ".jpg");
                    del.delete();
                    f.renameTo(del);
                } else {
                    dfilename = dfname + c;
                    System.out.println("First destn : " + dfilename);
                    File f = new File(d_file + "/" + sfname + "_new.jpg");
                    System.out.println(f.toString());
                    System.out.println("New dstn : " + d_file + "/" + dfilename + ".jpg");
                    f.renameTo(new File(d_file + "\\" + dfilename + ".jpg"));
                }
                src.setText("");
                ch.setText("");
                dstn.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void BrowseSourceActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser jf = new JFileChooser();
        //String file_name="",file_ext="";
        try {
            jf.showOpenDialog(this);
            String file = jf.getSelectedFile().toString();
            src.setText(file);
            //file_name=file.substring(0, file.indexOf("."));
            //file_ext=file.substring(file.indexOf(".")+1, file.length());

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void BrowseDestnActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser jf = new JFileChooser();
        try {
            jf.showOpenDialog(this);
            String file = jf.getSelectedFile().toString();
            dstn.setText(file);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UploadImg().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton Back;
    private javax.swing.JButton BrowseDestn;
    private javax.swing.JButton BrowseSource;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Upload;
    private javax.swing.JTextField ch;
    private javax.swing.JTextField dstn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField src;

}
