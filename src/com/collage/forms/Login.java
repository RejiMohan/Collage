/*
 * Login.java
 *
 * Created on December 6, 2010, 8:31 AM
 */

package com.collage.forms;

import com.collage.connector.AdminConnector;
import com.collage.connector.UserConnector;
import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Server;
import com.collage.fileTransfer.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.EventQueue.invokeLater;
import static javax.swing.GroupLayout.*;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import static javax.swing.SwingConstants.HORIZONTAL;
import static javax.swing.SwingConstants.VERTICAL;

public class Login extends JFrame {

    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private static String username = "";

    public static String getUsername() {
        return username;
    }

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new JPanel();
        uname = new JTextField();
        pword = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        NewUser = new JButton();
        Login = new JButton();
        Clear = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 153, 153));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 640));
        setName("");

        jPanel1.setBackground(new Color(255, 255, 255));

        pword.setFont(new Font("Tahoma", 1, 16));
        pword.setHorizontalAlignment(JTextField.LEFT);

        jLabel1.setFont(new Font("Verdana", 1, 10));
        jLabel1.setForeground(new Color(102, 102, 102));
        jLabel1.setText("Username");
        jLabel1.setName("");

        jLabel2.setFont(new Font("Verdana", 1, 10));
        jLabel2.setForeground(new Color(102, 102, 102));
        jLabel2.setText("Password");
        jLabel2.setName("");

        NewUser.setBackground(new Color(51, 204, 255));
        NewUser.setForeground(new Color(255, 51, 0));
        NewUser.setText("New User?");
        NewUser.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NewUser.setBorderPainted(false);
        NewUser.setContentAreaFilled(false);
        NewUser.setDefaultCapable(false);
        NewUser.setFocusPainted(false);
        NewUser.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                NewUserMouseEntered(evt);
            }
        });
        NewUser.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUserActionPerformed(evt);
            }
        });
        NewUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewUserFocusLost(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addPreferredGap(UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                        Alignment.LEADING)
                                                        .addComponent(uname, DEFAULT_SIZE,
                                                                110, Short.MAX_VALUE)
                                                        .addComponent(pword, DEFAULT_SIZE,
                                                                110, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(NewUser, PREFERRED_SIZE, 77,
                                                        PREFERRED_SIZE)
                                                .addGap(15, 15, 15))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Login)
                                                .addPreferredGap(RELATED)
                                                .addComponent(Clear)))
                                .addContainerGap())
        );

        jPanel1Layout.linkSize(HORIZONTAL, Clear, Login, jLabel1, jLabel2);

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(uname, PREFERRED_SIZE, 18, PREFERRED_SIZE))
                                .addPreferredGap(RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(pword, PREFERRED_SIZE, 17, PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Login)
                                        .addComponent(Clear)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(NewUser))
        );

        jPanel1Layout.linkSize(VERTICAL, Clear, Login, jLabel1, jLabel2);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(1476, Short.MAX_VALUE)
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(849, Short.MAX_VALUE))
        );

        pack();
    }

    private void LoginActionPerformed(ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        username = uname.getText();
        String password = pword.getPassword().toString();
        try {
            if (username.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "Enter values in both fields");
            } else {
                String a[] = databaseProcess.validate(username);

                boolean isExistingUser = databaseProcess.isAlreadyExistingUsername(username);
                if (isExistingUser || !(a[3].equals(username))) {
                    JOptionPane.showMessageDialog(this, "Invalid Username");
                } else if (a[0].equals(password)) {
                    if (a[2].equals("1")) {
                        if (a[1].equals("admin")) {
                            this.setVisible(false);
                            new A_home().setVisible(true);
                            AdminConnector ob = new AdminConnector();
                        } else {
                            String s_ip = "";
                            this.setVisible(false);
                            new U_home().setVisible(true);
                            Server s = new Server();
                            User user = new User();
                            new UserConnector(s_ip).connectToAdmin();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Pending Approval");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Password");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ClearActionPerformed(ActionEvent evt) {
        uname.setText("");
        pword.setText("");
    }

    private void NewUserActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new Registration().setVisible(true);
    }

    private void NewUserFocusLost(FocusEvent evt) {
    }

    private void NewUserMouseEntered(MouseEvent evt) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton Clear;
    private JButton Login;
    private JButton NewUser;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPasswordField pword;
    private JTextField uname;

}
