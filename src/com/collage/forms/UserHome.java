package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import static javax.swing.border.BevelBorder.RAISED;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class UserHome extends javax.swing.JFrame {

    /**
     * Creates new form UserHome
     */
    public UserHome() {
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
        uname.setText(Login.getUsername());
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new JLabel();
        uname = new JTextField();
        jButton1 = new JButton();
        CreateMessage = new JButton();
        Inbox = new JButton();
        Sent = new JButton();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        jMenuBar1 = new JMenuBar();
        Settings = new JMenu();
        ChangePass = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        Logout = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked();
            }
        });

        jLabel1.setFont(new Font("Verdana", 1, 18));
        jLabel1.setForeground(new Color(255, 0, 0));
        jLabel1.setText("Welcome");

        uname.setEditable(false);
        uname.setFont(new Font("Verdana", 1, 16));
        uname.setForeground(new Color(255, 0, 51));
        uname.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        uname.setOpaque(false);

        jButton1.setText("jButton1");

        CreateMessage.setFont(new Font("Verdana", 0, 11));
        CreateMessage.setForeground(new Color(51, 51, 51));
        CreateMessage.setText("Compose");
        CreateMessage.setBorder(BorderFactory.createBevelBorder(RAISED));
        CreateMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createMessage();
            }
        });

        Inbox.setFont(new Font("Verdana", 0, 11));
        Inbox.setForeground(new Color(51, 51, 51));
        Inbox.setText("Inbox");
        Inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showInbox();
            }
        });

        Sent.setFont(new Font("Verdana", 0, 11));
        Sent.setForeground(new Color(51, 51, 51));
        Sent.setText("Sent");
        Sent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sentAction();
            }
        });

        jLabel2.setIcon(new ImageIcon(""/*TODO icon path*/));

        jMenuBar1.setBackground(new Color(255, 255, 255));
        jMenuBar1.setBorder(BorderFactory.createBevelBorder(RAISED));
        jMenuBar1.setForeground(new Color(255, 255, 255));

        Settings.setBackground(new Color(255, 255, 255));
        Settings.setBorder(BorderFactory.createEtchedBorder());
        Settings.setText("Settings");
        Settings.setAlignmentX(100
        );

        ChangePass.setText("Change Password");
        ChangePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changePassword();
            }
        });
        Settings.add(ChangePass);
        Settings.add(jSeparator2);

        Logout.setText("Logout");
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logout();
            }
        });
        Settings.add(Logout);

        jMenuBar1.add(Settings);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addGroup(layout.createParallelGroup(TRAILING, false)
                                                                .addComponent(Sent,
                                                                        LEADING,
                                                                        DEFAULT_SIZE,
                                                                        DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Inbox, LEADING,
                                                                        DEFAULT_SIZE,
                                                                        DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(CreateMessage,
                                                                PREFERRED_SIZE, 72,
                                                                PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1, PREFERRED_SIZE,
                                                        111, PREFERRED_SIZE)))
                                .addContainerGap(288, Short.MAX_VALUE))
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addContainerGap(86, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(RELATED)
                                .addComponent(uname, PREFERRED_SIZE, 79, PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(uname, PREFERRED_SIZE,
                                                                DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addComponent(CreateMessage, PREFERRED_SIZE,
                                                        28, PREFERRED_SIZE)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(jSeparator1, PREFERRED_SIZE, 6,
                                                        PREFERRED_SIZE)
                                                .addPreferredGap(UNRELATED)
                                                .addComponent(Inbox)
                                                .addPreferredGap(RELATED)
                                                .addComponent(Sent))
                                        .addComponent(jLabel2))
                                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }

    private void formMouseClicked() {

    }

    private void changePassword() {
        this.setVisible(false);
        new ChangePassword().setVisible(true);
    }

    private void createMessage() {
        this.setVisible(false);
        new CreateMess().setVisible(true);
    }

    private void showInbox() {
        this.setVisible(false);
        new Inbox().setVisible(true);
    }

    private void sentAction() {
        this.setVisible(false);
        new Sent().setVisible(true);
    }

    private void logout() {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JMenuItem ChangePass;
    private JButton CreateMessage;
    private JButton Inbox;
    private JMenuItem Logout;
    private JButton Sent;
    private JMenu Settings;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenuBar jMenuBar1;
    private JSeparator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JTextField uname;

}
