package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
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
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Inbox extends JFrame {

    /**
     * Creates new form Inbox
     */
    public static String selectedUser = "";

    public Inbox() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
            Vector v = new Vector();
            File dir = new File("./inbox/" + Login.getUsername());

            File[] f = dir.listFiles();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i].getName());
                v.add(f[i].getName().substring(0, f[i].getName().indexOf(".")));
            }
            userJList.setListData(v);
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
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        userJList = new JList();
        btnViewMessage = new JButton();
        btnBack = new JButton();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Estrangelo Edessa", 3, 14));
        jLabel1.setText("Inbox");

        jLabel2.setFont(new Font("Verdana", 0, 11)); 
        jLabel2.setText("You have messages from");

        jScrollPane1.setViewportView(userJList);

        btnViewMessage.setFont(new Font("Verdana", 0, 11));
        btnViewMessage.setForeground(new Color(51, 51, 51));
        btnViewMessage.setText("View Message");
        btnViewMessage.setBorder(new javax.swing.border.SoftBevelBorder(RAISED, null, new
                Color(255, 255, 255), null, new Color(51, 153, 255)));
        btnViewMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewMessageActionPerformed();
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new ImageIcon(""/*TODO icon image*/));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        119, PREFERRED_SIZE)))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addComponent(btnViewMessage)
                                        .addComponent(btnBack))
                                .addPreferredGap(RELATED, 75, Short
                                        .MAX_VALUE)
                                .addComponent(jLabel3, PREFERRED_SIZE, 84, PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, PREFERRED_SIZE, 72,
                                                        PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(btnViewMessage)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnBack))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(RELATED)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        215, PREFERRED_SIZE)))
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }

    private void viewMessageActionPerformed() {
        selectedUser = userJList.getSelectedValue().toString();
        this.setVisible(false);
        new MessageIn().setVisible(true);
    }

    private void BackActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        new UserHome().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inbox().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnBack;
    private JButton btnViewMessage;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JList userJList;
}
