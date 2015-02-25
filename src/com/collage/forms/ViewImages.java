package com.collage.forms;

import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.border.BevelBorder.RAISED;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.SoftBevelBorder;

import com.collage.imageOper.FileFinder;

public class ViewImages extends JFrame {

    /**
     * Creates new form ViewImages
     */
    public static String file = "";
    private ArrayList files = new ArrayList();

    public ViewImages() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            String selectedChar = ViewImagePool.getSelectedChar();
            ch.setText(selectedChar);
            files = new FileFinder().getImages(selectedChar);
            ImageIcon icon;

            icon = new ImageIcon(files.get(0).toString());
            img1.setIcon(icon);
            icon = new ImageIcon(files.get(1).toString());
            img2.setIcon(icon);
            icon = new ImageIcon(files.get(2).toString());
            img3.setIcon(icon);
            icon = new ImageIcon(files.get(3).toString());
            img4.setIcon(icon);
            icon = new ImageIcon(files.get(4).toString());
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

        jLabel1 = new JLabel();
        ch = new JTextField();
        img1 = new JLabel();
        img2 = new JLabel();
        img3 = new JLabel();
        img4 = new JLabel();
        img5 = new JLabel();
        Back = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Images for ");

        img1.setBorder(createLineBorder(new Color(0, 0, 0)));
        img1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                img1MouseClicked();
            }
        });

        img2.setBorder(createLineBorder(new Color(0, 0, 0)));
        img2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                img2MouseClicked();
            }
        });

        img3.setBorder(createLineBorder(new Color(0, 0, 0)));
        img3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                img3MouseClicked();
            }
        });

        img4.setBorder(createLineBorder(new Color(0, 0, 0)));
        img4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                img4MouseClicked();
            }
        });

        img5.setBorder(createLineBorder(new Color(0, 0, 0)));
        img5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                img5MouseClicked();
            }
        });

        Back.setFont(new Font("Verdana", 0, 11));
        Back.setForeground(new Color(51, 51, 51));
        Back.setText("Back");
        Back.setBorder(new SoftBevelBorder(RAISED));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(ch, PREFERRED_SIZE, 27, PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(img1, PREFERRED_SIZE, 100,
                                                        PREFERRED_SIZE)
                                                .addGap(98, 98, 98)
                                                .addComponent(img2, PREFERRED_SIZE, 100,
                                                        PREFERRED_SIZE)
                                                .addGap(88, 88, 88)
                                                .addComponent(img3, PREFERRED_SIZE, 100,
                                                        PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(img4, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                .addPreferredGap(RELATED, 113, Short
                                        .MAX_VALUE)
                                .addComponent(img5, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(Back, PREFERRED_SIZE, 47, PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(ch, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(img3, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                        .addComponent(img2, PREFERRED_SIZE, 100, PREFERRED_SIZE)
                                        .addComponent(img1, PREFERRED_SIZE, 100, PREFERRED_SIZE))
                                .addPreferredGap(RELATED, 27, Short
                                        .MAX_VALUE)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(TRAILING)
                                                        .addComponent(img5, PREFERRED_SIZE,
                                                                100, PREFERRED_SIZE)
                                                        .addComponent(img4, PREFERRED_SIZE,
                                                                100, PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Back)
                                                .addGap(31, 31, 31))))
        );

        pack();
    }

    private void img1MouseClicked() {
        file = files.get(0).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void BackActionPerformed() {
        this.setVisible(false);
        new ViewImagePool().setVisible(true);
    }

    private void img2MouseClicked() {
        file = files.get(1).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img3MouseClicked() {
        file = files.get(2).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img4MouseClicked() {
        file = files.get(3).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

    private void img5MouseClicked() {
        file = files.get(4).toString();
        this.setVisible(false);
        new ChangeImage().setVisible(true);
    }

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
    private JButton Back;
    private JTextField ch;
    private JLabel img1;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;
    private JLabel jLabel1;

}
