package com.collage.forms;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class ViewImagePool extends JFrame {

    private static String selectedChar = "";

    public static String getSelectedChar() {
        return selectedChar;
    }

    /**
     * Creates new form ViewImagePool
     */
    public ViewImagePool() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = getWidth();
        int height = getHeight();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        characterLabel = new JLabel();
        characterField = new JTextField();
        btnView = new JButton();
        btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        characterLabel.setFont(new java.awt.Font("Verdana", 0, 11));
        characterLabel.setText("Enter the character");

        btnView.setFont(new java.awt.Font("Verdana", 0, 11));
        btnView.setForeground(new java.awt.Color(51, 51, 51));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Verdana", 0, 11));
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(characterLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBack)
                                        .addComponent(btnView)
                                        .addComponent(characterField, GroupLayout.PREFERRED_SIZE, 33, javax.swing
                                                .GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(characterLabel)
                                        .addComponent(characterField, GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(btnView)
                                .addGap(48, 48, 48)
                                .addComponent(btnBack)
                                .addContainerGap(84, Short.MAX_VALUE))
        );
        pack();
    }

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {
        selectedChar = characterField.getText();
        if (selectedChar.length() > 1)
            JOptionPane.showMessageDialog(null, "Invalid Entry");
        else {
            this.setVisible(false);
            new ViewImages().setVisible(true);
        }
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewImagePool().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnBack;
    private JButton btnView;
    private JTextField characterField;
    private JLabel characterLabel;
}
