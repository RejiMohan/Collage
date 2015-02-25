package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;

public class ManageClient extends javax.swing.JFrame {

    /**
     * Creates new form ManageClient
     */
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private List userList = new ArrayList();
    private String add = "";
    private String[] a = new String[4];
    private int x = 0;

    public ManageClient() {
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
        userList = databaseProcess.listUsers(1);
        for (int i = 0; i < userList.size(); i++)
            comboBox.addItem(userList.get(i));
        try {
            String u = comboBox.getSelectedItem().toString();
            add = databaseProcess.getIpAddress(u);
            StringTokenizer s = new StringTokenizer(add, ".");
            while (s.hasMoreTokens()) {
                a[x] = s.nextToken(".");
                x++;
            }
            ip1.setText(a[0]);
            ip2.setText(a[1]);
            ip3.setText(a[2]);
            ip4.setText(a[3]);
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

        comboBox = new JComboBox();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        ip1 = new JTextField();
        btnOk = new JButton();
        btnClear = new JButton();
        btnBack = new JButton();
        jLabel3 = new JLabel();
        ip2 = new JTextField();
        jLabel4 = new JLabel();
        ip3 = new JTextField();
        jLabel5 = new JLabel();
        ip4 = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                c_listItemStateChanged(evt);
            }
        });

        jLabel1.setText("Select User ");

        jLabel2.setText("IP");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("Tahoma", 3, 14));
        jLabel3.setText(".");

        jLabel4.setFont(new Font("Tahoma", 3, 14));
        jLabel4.setText(".");

        jLabel5.setFont(new Font("Tahoma", 3, 14));
        jLabel5.setText(".");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(RELATED)
                                                .addComponent(comboBox, 0, DEFAULT_SIZE, Short
                                                        .MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addGroup(LEADING, layout
                                                                .createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ip1,
                                                                        PREFERRED_SIZE, 42,
                                                                        PREFERRED_SIZE))
                                                        .addComponent(btnOk))
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(jLabel3,
                                                                        PREFERRED_SIZE, 4,
                                                                        PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(ip2,
                                                                        PREFERRED_SIZE, 42,
                                                                        PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(ip3,
                                                                        PREFERRED_SIZE, 44,
                                                                        PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(jLabel5,
                                                                        PREFERRED_SIZE, 6,
                                                                        PREFERRED_SIZE)
                                                                .addPreferredGap(RELATED)
                                                                .addComponent(ip4,
                                                                        PREFERRED_SIZE, 39,
                                                                        PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(btnClear)
                                                                .addPreferredGap(RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnBack)))))
                                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(comboBox, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ip1, PREFERRED_SIZE, 20, PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(ip2, PREFERRED_SIZE, 20, PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(ip4, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(ip3, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnClear)
                                        .addComponent(btnBack)
                                        .addComponent(btnOk))
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {
        String i1 = "", i2 = "", i3 = "", i4 = "";
        String s = "", p = "";
        try {
            s = comboBox.getSelectedItem().toString();
            i1 = ip1.getText();
            i2 = ip2.getText();
            i3 = ip3.getText();
            i4 = ip4.getText();
            p = i1 + "." + i2 + "." + i3 + "." + i4;
            if (i1.equals("") || i2.equals("") || i3.equals("") || i4.equals("")) {
                JOptionPane.showMessageDialog(this, "Invalid IP address");
                ip1.setText("");
                ip2.setText("");
                ip3.setText("");
                ip4.setText("");
            } else {
                System.out.println(s);
                int a = databaseProcess.addIpAddress(s, p);
                if (a == -1) {
                    JOptionPane.showMessageDialog(this, "IP Already Used");
                } else if (a > 0) {
                    JOptionPane.showMessageDialog(this, "IP Added");
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {
        ip1.setText("");
        ip2.setText("");
        ip3.setText("");
        ip4.setText("");
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    private void c_listItemStateChanged(ItemEvent evt) {
        try {
            String u = comboBox.getSelectedItem().toString();
            add = databaseProcess.getIpAddress(u);
            StringTokenizer s = new StringTokenizer(add, ".");
            x = 0;
            while (s.hasMoreTokens()) {
                a[x] = s.nextToken(".");
                x++;
            }
            ip1.setText(a[0]);
            ip2.setText(a[1]);
            ip3.setText(a[2]);
            ip4.setText(a[3]);
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
                new ManageClient().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnBack;
    private JButton btnClear;
    private JButton btnOk;
    private JComboBox comboBox;
    private JTextField ip1;
    private JTextField ip2;
    private JTextField ip3;
    private JTextField ip4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
}
