package com.collage.forms;

import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserHome extends javax.swing.JFrame {

    /**
     * Creates new form UserHome
     */
    Login ob = new Login();

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

        jLabel1 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        CreateMessage = new javax.swing.JButton();
        Inbox = new javax.swing.JButton();
        Sent = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Settings = new javax.swing.JMenu();
        ChangePass = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); 
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Welcome");

        uname.setEditable(false);
        uname.setFont(new java.awt.Font("Verdana", 1, 16)); 
        uname.setForeground(new java.awt.Color(255, 0, 51));
        uname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        uname.setOpaque(false);

        jButton1.setText("jButton1");

        CreateMessage.setFont(new java.awt.Font("Verdana", 0, 11)); 
        CreateMessage.setForeground(new java.awt.Color(51, 51, 51));
        CreateMessage.setText("Compose");
        CreateMessage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CreateMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CreateMessageActionPerformed(evt);
            }
        });

        Inbox.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Inbox.setForeground(new java.awt.Color(51, 51, 51));
        Inbox.setText("Inbox");
        Inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                InboxActionPerformed(evt);
            }
        });

        Sent.setFont(new java.awt.Font("Verdana", 0, 11)); 
        Sent.setForeground(new java.awt.Color(51, 51, 51));
        Sent.setText("Sent");
        Sent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SentActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Documents and Settings\\Sreedutt\\My " +
                "Documents\\NetBeansProjects\\Collage Steganography\\src\\Forms\\Img\\images.jpg")); 

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        Settings.setBackground(new java.awt.Color(255, 255, 255));
        Settings.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Settings.setText("Settings");
        Settings.setAlignmentX(100
        );

        ChangePass.setText("Change Password");
        ChangePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ChangePassActionPerformed(evt);
            }
        });
        Settings.add(ChangePass);
        Settings.add(jSeparator2);

        Logout.setText("Logout");
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Settings.add(Logout);

        jMenuBar1.add(Settings);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                                .Alignment.TRAILING, false)
                                                                .addComponent(Sent, javax.swing.GroupLayout.Alignment
                                                                        .LEADING, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Inbox, javax.swing.GroupLayout
                                                                        .Alignment.LEADING, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, javax.swing.GroupLayout
                                                                        .DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(CreateMessage, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE, 72, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(288, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(86, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing
                                                                        .GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addComponent(CreateMessage, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Inbox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Sent))
                                        .addComponent(jLabel2))
                                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }

    private void formMouseClicked(MouseEvent evt) {

    }

    private void ChangePassActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new ChangePassword().setVisible(true);
    }

    private void CreateMessageActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new CreateMess().setVisible(true);
    }

    private void InboxActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new Inbox().setVisible(true);
    }

    private void SentActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new Sent().setVisible(true);
    }

    private void LogoutActionPerformed(ActionEvent evt) {
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
    private javax.swing.JMenuItem ChangePass;
    private javax.swing.JButton CreateMessage;
    private javax.swing.JButton Inbox;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JButton Sent;
    private javax.swing.JMenu Settings;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField uname;

}
