package com.collage.forms;

import com.collage.User;
import com.collage.database.DatabaseProcess;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JFrame {

    private DatabaseProcess databaseProcess = new DatabaseProcess();

    /**
     * Creates new form Registration
     */
    public Registration() {
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
    @SuppressWarnings("unchecked")
    private void initComponents() {
        nameLabel = new JLabel();
        designationLabel = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        confirmPasswordLabel = new JLabel();
        nameField = new JTextField();
        designationField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        btnRegister = new JButton();
        btnClear = new JButton();
        jLabel2 = new JLabel();
        jLabel8 = new JLabel();
        jScrollPane1 = new JScrollPane();
        addressField = new JTextArea();
        jLabel7 = new JLabel();
        emailField = new JTextField();
        btnBack = new JButton();
        jLabel9 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        nameLabel.setFont(new Font("Verdana", 0, 11));
        nameLabel.setText("Name");

        designationLabel.setFont(new Font("Verdana", 0, 11));
        designationLabel.setText("Designation");

        usernameLabel.setFont(new Font("Verdana", 0, 11));
        usernameLabel.setText("Username");

        passwordLabel.setFont(new Font("Verdana", 0, 11));
        passwordLabel.setText("Password");

        confirmPasswordLabel.setFont(new Font("Verdana", 0, 11));
        confirmPasswordLabel.setText("Retype Password");

        btnRegister.setFont(new Font("Verdana", 0, 11));
        btnRegister.setForeground(new Color(51, 51, 51));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerButtonActionPerformed();
            }
        });

        btnClear.setFont(new Font("Verdana", 0, 11));
        btnClear.setForeground(new Color(51, 51, 51));
        btnClear.setText("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Verdana", 1, 24));
        jLabel2.setText("Account Details");

        jLabel8.setFont(new Font("Verdana", 0, 11));
        jLabel8.setText("Address");

        addressField.setColumns(20);
        addressField.setRows(3);
        jScrollPane1.setViewportView(addressField);

        jLabel7.setFont(new Font("Verdana", 0, 11));
        jLabel7.setText("E-mail");

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton3ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new ImageIcon("C:\\Documents and Settings\\Sreedutt\\My " +
                "Documents\\NetBeansProjects\\Collage Steganography\\src\\Forms\\Img\\images.jpg"));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(nameLabel)
                                                        .addComponent(designationLabel)
                                                        .addComponent(usernameLabel)
                                                        .addComponent(jLabel7)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(confirmPasswordLabel))
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addComponent(confirmPasswordField)
                                                        .addComponent(passwordField)
                                                        .addComponent(usernameField)
                                                        .addComponent(designationField)
                                                        .addComponent(emailField)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE,
                                                                176, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnRegister)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement
                                                                .RELATED)
                                                        .addComponent(btnClear)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement
                                                                .RELATED)
                                                        .addComponent(btnBack))
                                                .addComponent(jLabel2)))
                                .addContainerGap(206, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(598, Short.MAX_VALUE)
                                .addComponent(jLabel9))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, btnRegister, btnClear, btnBack);

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(nameLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(designationLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(confirmPasswordLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                        62, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(designationField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, javax
                                                        .swing.GroupLayout.DEFAULT_SIZE, GroupLayout
                                                        .PREFERRED_SIZE)))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRegister)
                                        .addComponent(btnClear)
                                        .addComponent(btnBack))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }

    private void registerButtonActionPerformed() {
        try {
            String name = nameField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String designation = designationField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            boolean usernameAlreadyExists = databaseProcess.isAlreadyExistingUsername(username);

            if (usernameAlreadyExists) {
                JOptionPane.showMessageDialog(this, "Username not available");
            } else if (name.equals("") || address.equals("") || email.equals("") || designation.equals("") ||
                    username.equals("") || password
                    .equals("")) {
                JOptionPane.showMessageDialog(this, "No field can be left blank");
            } else if (password.equals(confirmPassword)) {
                User user = new User();
                user.setName(name);
                user.setAddress(address);
                user.setEmail(email);
                user.setDesignation(designation);
                user.setUsername(username);
                boolean isSuccess = databaseProcess.insertUser(user);
                int j = databaseProcess.insertUserInLogin(username, password);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(this, "Request sent successfully");
                    this.setVisible(false);
                    new Login().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match");
            }
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
        }
    }

    private void clearButtonActionPerformed(ActionEvent event) {
        nameField.setText("");
        addressField.setText("");
        emailField.setText("");
        designationField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    private void backButton3ActionPerformed(ActionEvent event) {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration

    private JButton btnRegister;
    private JButton btnClear;
    private JButton btnBack;
    private JLabel nameLabel;
    private JLabel jLabel2;
    private JLabel designationLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JTextField nameField;
    private JTextArea addressField;
    private JTextField designationField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField usernameField;
}
