package com.collage.forms;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import static javax.swing.border.BevelBorder.RAISED;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.steganography.Steganography;

public class ChangeImage extends JFrame {

    /**
     * Creates new form ChangeImage
     */
    public ChangeImage() {
        initComponents();
        Point center = getLocalGraphicsEnvironment().getCenterPoint();
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

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Source");

        btnBrowse.setFont(new Font("Verdana", 0, 11));
        btnBrowse.setForeground(new Color(51, 51, 51));
        btnBrowse.setText("Browse");
        btnBrowse.setBorder(BorderFactory.createBevelBorder(RAISED));
        btnBrowse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseAction();
            }
        });

        lblCurrentImage.setBorder(createLineBorder(new Color(0, 0, 0)));

        lblNewImage.setBorder(createLineBorder(new Color(0, 0, 0)));

        btnChange.setFont(new Font("Verdana", 0, 11));
        btnChange.setForeground(new Color(51, 51, 51));
        btnChange.setText("Change");
        btnChange.setBorderPainted(false);
        btnChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changeAction();
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed();
            }
        });

        lblChageImage.setFont(new Font("Verdana", 1, 14));
        lblChageImage.setText("Change Image");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(sourceTextField,
                                                        PREFERRED_SIZE, 220, PREFERRED_SIZE)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(btnBrowse, PREFERRED_SIZE, 53,
                                                        PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(lblChageImage))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addComponent(lblCurrentImage, PREFERRED_SIZE, 100,
                                                        PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(lblNewImage, PREFERRED_SIZE, 100,
                                                        PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(btnChange)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnBack)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblChageImage)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(sourceTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(btnBrowse, PREFERRED_SIZE, 20, PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(lblCurrentImage, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                        .addComponent(lblNewImage, PREFERRED_SIZE, 100, PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(btnChange)
                                        .addComponent(btnBack))
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }

    private void browseAction() {
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

    private void changeAction() {
        File file = new File(ViewImages.file);
        String fileName = file.getName().substring(0, file.getName().indexOf("."));
        String filePath = file.getParent();
        String sourcePath = sourceTextField.getText();
        if (new Steganography().encode(sourceTextField.getText(), ViewImagePool.getSelectedChar(), filePath)) {
            showMessageDialog(null, "Character Encoded");
        } else {
            showMessageDialog(null, "Error");
        }
        File sourceFile = new File(sourcePath);
        String fileName1 = sourceFile.getName().substring(0, sourceFile.getName().indexOf("."));
        File newFile = new File(filePath + "/" + fileName1 + "_new.jpg");
        file.delete();
        newFile.renameTo(new File(filePath + "/" + fileName + ".jpg"));

    }

    private void jButton2ActionPerformed() {
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
