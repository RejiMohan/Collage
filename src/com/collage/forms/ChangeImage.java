package com.collage.forms;

import com.collage.steganography.Steganography;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;

public class ChangeImage extends JFrame {

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
            lblCurrentImage.setIcon(new ImageIcon(ViewImages.file));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jButton1 = new JButton();
        jLabel1 = new JLabel();
        sourceTextField = new JTextField();
        btnBrowse = new JButton();
        jLabel2 = new JLabel();
        lblCurrentImage = new JLabel();
        lblNewImage = new JLabel();
        btnChange = new JButton();
        btnBack = new JButton();
        lblChageImage = new JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText("Source");

        btnBrowse.setFont(new java.awt.Font("Verdana", 0, 11));
        btnBrowse.setForeground(new java.awt.Color(51, 51, 51));
        btnBrowse.setText("Browse");
        btnBrowse.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        btnBrowse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed();
            }
        });

        lblCurrentImage.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNewImage.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChange.setFont(new java.awt.Font("Verdana", 0, 11));
        btnChange.setForeground(new java.awt.Color(51, 51, 51));
        btnChange.setText("Change");
        btnChange.setBorderPainted(false);
        btnChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Verdana", 0, 11));
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblChageImage.setFont(new java.awt.Font("Verdana", 1, 14));
        lblChageImage.setText("Change Image");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(sourceTextField, GroupLayout
                                                        .PREFERRED_SIZE, 220, javax
                                                        .swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 53,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(lblChageImage))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(lblCurrentImage, GroupLayout.PREFERRED_SIZE, 100,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(lblNewImage, GroupLayout.PREFERRED_SIZE, 100,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(btnChange)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnBack)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblChageImage)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(sourceTextField, GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 20, javax.swing
                                                .GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(lblCurrentImage, GroupLayout.PREFERRED_SIZE, 100, javax
                                                .swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewImage, GroupLayout.PREFERRED_SIZE, 100, javax
                                                .swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnChange)
                                        .addComponent(btnBack))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }

    private void browseActionPerformed() {
        JFileChooser jFileChooser = new JFileChooser();
        try {
            jFileChooser.showOpenDialog(this);
            String file = jFileChooser.getSelectedFile().toString();
            sourceTextField.setText(file);
            lblNewImage.setIcon(new ImageIcon(file));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void ChangeActionPerformed(java.awt.event.ActionEvent evt) {
        File file = new File(ViewImages.file);
        String fileName = file.getName().substring(0, file.getName().indexOf("."));
        String filePath = file.getParent();
        String sourcePath = sourceTextField.getText();
        if (new Steganography().encode(sourceTextField.getText(), ViewImagePool.getSelectedChar(), filePath)) {
            JOptionPane.showMessageDialog(null, "Character Encoded");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        File sourceFile = new File(sourcePath);
        String fileName1 = sourceFile.getName().substring(0, sourceFile.getName().indexOf("."));
        File newFile = new File(filePath + "/" + fileName1 + "_new.jpg");
        file.delete();
        newFile.renameTo(new File(filePath + "/" + fileName + ".jpg"));

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
    private JButton btnBrowse;
    private JButton btnChange;
    private JLabel lblCurrentImage;
    private JButton jButton1;
    private JButton btnBack;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lblChageImage;
    private JLabel lblNewImage;
    private JTextField sourceTextField;
}
