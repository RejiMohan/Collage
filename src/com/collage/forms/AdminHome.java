package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame {
    private DatabaseProcess dp = new DatabaseProcess();

    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
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
        pendingTextField.setText(Integer.toString(dp.getPendingApprovalCount()));
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        btnView = new JButton();
        pendingLabel = new JLabel();
        pendingTextField = new JTextField();
        jLabel4 = new JLabel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        clientListMenuItem = new JMenuItem();
        jSeparator1 = new JPopupMenu.Separator();
        ManageClients = new JMenuItem();
        jSeparator2 = new JPopupMenu.Separator();
        Updates = new JMenuItem();
        jMenu2 = new JMenu();
        ViewImagePool = new JMenuItem();
        jSeparator3 = new JPopupMenu.Separator();
        UpdateImagePool = new JMenuItem();
        jSeparator4 = new JPopupMenu.Separator();
        UploadImage = new JMenuItem();
        jMenu3 = new JMenu();
        ChangePass = new JMenuItem();
        jSeparator5 = new JPopupMenu.Separator();
        logoutMenuItem = new JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Verdana", 1, 16)); // NOI18N
        jLabel2.setForeground(new Color(255, 51, 0));
        jLabel2.setText("Welcome admin");

        btnView.setFont(new Font("Verdana", 0, 11)); // NOI18N
        btnView.setForeground(new Color(51, 51, 51));
        btnView.setText("viewButton");
        btnView.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new java.awt
                .Color(0, 153, 255), null));
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewActionPerformed();
            }
        });

        pendingLabel.setFont(new Font("Verdana", 1, 14)); // NOI18N
        pendingLabel.setText("Pending Requests : ");

        pendingTextField.setEditable(false);
        pendingTextField.setFont(new Font("Cambria", 3, 14));
        pendingTextField.setHorizontalAlignment(JTextField.LEFT);
        pendingTextField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pendingTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pndngActionPerformed();
            }
        });

        jLabel4.setIcon(new ImageIcon("C:\\Documents and Settings\\Sreedutt\\My " +
                "Documents\\NetBeansProjects\\Collage Steganography\\src\\Forms\\Img\\images.jpg")); // NOI18N

        jMenuBar1.setBackground(new Color(255, 255, 255));
        jMenuBar1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new java
                .awt.Color(51, 204, 255), null));

        jMenu1.setBackground(new Color(255, 255, 255));
        jMenu1.setBorder(BorderFactory.createEtchedBorder());
        jMenu1.setForeground(new Color(102, 102, 102));
        jMenu1.setText("Clients");

        clientListMenuItem.setText("Client List");
        clientListMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clientListActionPerformed();
            }
        });
        jMenu1.add(clientListMenuItem);
        jMenu1.add(jSeparator1);

        ManageClients.setText("Manage Clients");
        ManageClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                manageClientsActionPerformed();
            }
        });
        jMenu1.add(ManageClients);
        jMenu1.add(jSeparator2);

        Updates.setText("Updates");
        Updates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updatesActionPerformed();
            }
        });
        jMenu1.add(Updates);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new Color(255, 255, 255));
        jMenu2.setBorder(BorderFactory.createEtchedBorder());
        jMenu2.setForeground(new Color(102, 102, 102));
        jMenu2.setText("Image Pool");

        ViewImagePool.setText("ImagePool");
        ViewImagePool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewImagePoolActionPerformed();
            }
        });
        jMenu2.add(ViewImagePool);
        jMenu2.add(jSeparator3);

        UpdateImagePool.setText("Update ImagePool");
        UpdateImagePool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateImagePoolActionPerformed();
            }
        });
        jMenu2.add(UpdateImagePool);
        jMenu2.add(jSeparator4);

        UploadImage.setText("Upload Image");
        UploadImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                uploadImageActionPerformed();
            }
        });
        jMenu2.add(UploadImage);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new Color(255, 255, 255));
        jMenu3.setBorder(BorderFactory.createEtchedBorder());
        jMenu3.setForeground(new Color(102, 102, 102));
        jMenu3.setText("Settings");

        ChangePass.setText("Change Password");
        ChangePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changePasswordActionPerformed();
            }
        });
        jMenu3.add(ChangePass);
        jMenu3.add(jSeparator5);

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutActionPerformed();
            }
        });
        jMenu3.add(logoutMenuItem);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(197, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(pendingLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pendingTextField, GroupLayout.PREFERRED_SIZE, 51, GroupLayout
                                        .PREFERRED_SIZE)
                                .addContainerGap(186, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnView, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(281, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 36,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72)
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.BASELINE)
                                                        .addComponent(pendingLabel)
                                                        .addComponent(pendingTextField, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 77, javax
                                                .swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(btnView)
                                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }

    private void updateImagePoolActionPerformed() {
        this.setVisible(false);
        new UpdateImagePool().setVisible(true);
    }

    private void uploadImageActionPerformed() {
        this.setVisible(false);
        new UploadImg().setVisible(true);
    }

    private void changePasswordActionPerformed() {
        this.setVisible(false);
        new ChangePassword().setVisible(true);
    }

    private void logoutActionPerformed() {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    private void clientListActionPerformed() {
        this.setVisible(false);
        new ClientList().setVisible(true);
    }

    private void manageClientsActionPerformed() {
        this.setVisible(false);
        new ManageClient().setVisible(true);
    }

    private void viewActionPerformed() {
        this.setVisible(false);
        new Requests().setVisible(true);
    }

    private void pndngActionPerformed() {
    }

    private void viewImagePoolActionPerformed() {
        this.setVisible(false);
        new ViewImagePool().setVisible(true);
    }

    private void updatesActionPerformed() {
        this.setVisible(false);
        new Updates().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JMenuItem ChangePass;
    private JMenuItem clientListMenuItem;
    private JMenuItem logoutMenuItem;
    private JMenuItem ManageClients;
    private JMenuItem UpdateImagePool;
    private JMenuItem Updates;
    private JMenuItem UploadImage;
    private JButton btnView;
    private JMenuItem ViewImagePool;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel pendingLabel;
    private JLabel jLabel4;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    private JPopupMenu.Separator jSeparator3;
    private JPopupMenu.Separator jSeparator4;
    private JPopupMenu.Separator jSeparator5;
    private JTextField pendingTextField;
}
