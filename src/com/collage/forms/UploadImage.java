package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.border.BevelBorder.RAISED;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.SoftBevelBorder;

import com.collage.encryption.Encrypt;
import com.collage.imageOper.FileFinder;
import com.collage.steganography.Steganography;

public class UploadImage extends JFrame {

    /**
     * Creates new form UploadImage
     */
    public UploadImage() {
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
        destinationField.setText(""/*TODO set a default location*/);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        sourceField = new JTextField();
        btnBrowseSource = new JButton();
        characterField = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        destinationField = new JTextField();
        btnBrowseDestination = new JButton();
        btnUpload = new JButton();
        btnClear = new JButton();
        btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Source Image");

        jLabel2.setFont(new Font("Verdana", 1, 18));
        jLabel2.setText("Upload Image");

        btnBrowseSource.setFont(new Font("Verdana", 0, 11));
        btnBrowseSource.setForeground(new Color(51, 51, 51));
        btnBrowseSource.setText("Browse");
        btnBrowseSource.setBorder(new SoftBevelBorder(RAISED));
        btnBrowseSource.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseSource();
            }
        });

        jLabel3.setFont(new Font("Verdana", 0, 11));
        jLabel3.setText("Character");

        jLabel4.setFont(new Font("Verdana", 0, 11));
        jLabel4.setText("Destination Path");

        btnBrowseDestination.setFont(new Font("Verdana", 0, 11));
        btnBrowseDestination.setForeground(new Color(51, 51, 51));
        btnBrowseDestination.setText("Browse");
        btnBrowseDestination.setBorder(new SoftBevelBorder(RAISED));
        btnBrowseDestination.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseDestinationAction();
            }
        });

        btnUpload.setFont(new Font("Verdana", 0, 11));
        btnUpload.setForeground(new Color(51, 51, 51));
        btnUpload.setText("btnUpload");
        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                uploadAction();
            }
        });

        btnClear.setFont(new Font("Verdana", 0, 11));
        btnClear.setForeground(new Color(51, 51, 51));
        btnClear.setText("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearTextFields();
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backAction();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(LEADING)
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
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(characterField, PREFERRED_SIZE, 25,
                                                                PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(TRAILING, false)
                                                                        .addComponent(destinationField, LEADING)
                                                                        .addComponent(sourceField, LEADING,
                                                                                DEFAULT_SIZE, 200, Short
                                                                                        .MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(btnUpload)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnClear)
                                                                                .addGap(23, 23, 23)
                                                                                .addComponent(btnBack)))
                                                                .addPreferredGap(RELATED)
                                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                                        .addComponent(btnBrowseDestination,
                                                                                DEFAULT_SIZE, DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(btnBrowseSource,
                                                                                LEADING, DEFAULT_SIZE,
                                                                                DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(sourceField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(btnBrowseSource, PREFERRED_SIZE, 29, PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(characterField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(RELATED, 34, Short
                                        .MAX_VALUE)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(destinationField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(btnBrowseDestination, PREFERRED_SIZE, 31, PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(btnBack)
                                        .addComponent(btnClear)
                                        .addComponent(btnUpload))
                                .addGap(19, 19, 19))
        );

        pack();
    }

    private void clearTextFields() {
        sourceField.setText("");
        characterField.setText("");
        destinationField.setText("");
    }

    private void uploadAction() {
        int i = 1;
        try {
            File directory = new File(""/*"D:/ImagePool"  TODO specify image pool location */);

            String character = characterField.getText();
            String sourceFilePath = sourceField.getText();
            String destinationPath = destinationField.getText();

            String encodedChar = new Encrypt().encryption(character.getBytes());

            String destinationFileName = "";
            if (new Steganography().encode(sourceFilePath, encodedChar, destinationPath)) {
                showMessageDialog(this, "Character Encoded");
                File sourceFile = new File(sourceFilePath);

                String sourceFileName = sourceFile.getName().substring(0, sourceFile.getName().indexOf("."));

                ArrayList imageList = new FileFinder().getImages(character);
                for (int k = 0; k < imageList.size(); k++) {
                    System.out.println(imageList.get(k));
                }
                if (imageList.size() == 0) {
                    i = 0;
                }

                File destinationFile = new File(imageList.get(imageList.size() - i).toString());
                String dfname = destinationFile.getName().substring(0, destinationFile.getName().indexOf("."));
                if (dfname.length() >= 5) {
                    destinationFileName = character;
                    File f = new File(destinationPath + "/" + sourceFileName + "_new.jpg");
                    File del = new File(destinationPath + "/" + character + ".jpg");
                    del.delete();
                    f.renameTo(del);
                } else {
                    destinationFileName = dfname + character;
                    File f = new File(destinationPath + "/" + sourceFileName + "_new.jpg");
                    f.renameTo(new File(destinationPath + "\\" + destinationFileName + ".jpg"));
                }
                clearTextFields();
            } else {
                showMessageDialog(this, "Error");
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void backAction() {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void browseSource() {
        JFileChooser jFileChooser = new JFileChooser();
        try {
            jFileChooser.showOpenDialog(this);
            String file = jFileChooser.getSelectedFile().toString();
            sourceField.setText(file);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void browseDestinationAction() {
        JFileChooser jFileChooser = new JFileChooser();
        try {
            jFileChooser.showOpenDialog(this);
            String file = jFileChooser.getSelectedFile().toString();
            destinationField.setText(file);
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
                new UploadImage().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnBack;
    private JButton btnBrowseDestination;
    private JButton btnBrowseSource;
    private JButton btnClear;
    private JButton btnUpload;
    private JTextField characterField;
    private JTextField destinationField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField sourceField;
}
