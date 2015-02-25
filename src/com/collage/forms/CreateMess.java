package com.collage.forms;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Client;
import com.collage.imageOper.Encoder;

public class CreateMess extends javax.swing.JFrame {

    private List userList = new ArrayList();
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private String username = Login.getUsername();

    /**
     * Creates new form CreateMess
     */
    public CreateMess() {
        initComponents();
        Point center = getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        userList = databaseProcess.listUsers(1);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).toString().equals(username)) {
                continue;
            }
            userListComboBox.addItem(userList.get(i));
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        msgTextArea = new JTextArea();
        jLabel2 = new JLabel();
        userListComboBox = new JComboBox();
        jLabel3 = new JLabel();
        btnSend = new JButton();
        btnClear = new JButton();
        btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Verdana", 1, 14));
        jLabel1.setText("Create Message");

        msgTextArea.setColumns(20);
        msgTextArea.setRows(5);
        jScrollPane1.setViewportView(msgTextArea);

        jLabel2.setFont(new Font("Verdana", 0, 12));
        jLabel2.setText("To");

        jLabel3.setFont(new Font("Verdana", 0, 12));
        jLabel3.setText("Message:");

        btnSend.setFont(new Font("Verdana", 0, 11));
        btnSend.setForeground(new Color(51, 51, 51));
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed();
            }
        });

        btnClear.setFont(new Font("Verdana", 0, 11));
        btnClear.setForeground(new Color(51, 51, 51));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed();
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
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
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(userListComboBox,
                                                                        PREFERRED_SIZE, 189,
                                                                        PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1,
                                                                PREFERRED_SIZE, 368,
                                                                PREFERRED_SIZE)
                                                        .addComponent(jLabel3)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(btnSend)
                                                .addGap(27, 27, 27)
                                                .addComponent(btnClear)
                                                .addGap(27, 27, 27)
                                                .addComponent(btnBack)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, PREFERRED_SIZE, 26, PREFERRED_SIZE)
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(userListComboBox, PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(UNRELATED)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, javax.swing
                                        .GroupLayout.DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(btnSend)
                                        .addComponent(btnClear)
                                        .addComponent(btnBack))
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }

    private void ClearActionPerformed() {
        msgTextArea.setText("");
    }

    private void SendActionPerformed() {
        String msg;
        String ip;
        try {
            msg = msgTextArea.getText();
            Encoder en = new Encoder();
            String op = en.convert(msg);
            ip = new DatabaseProcess().getIpAddress(userListComboBox.getSelectedItem().toString());
            new Client(ip).send(op, userListComboBox.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Message Sent");
            msgTextArea.setText("");
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void BackActionPerformed() {
        this.setVisible(false);
        new UserHome().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateMess().setVisible(true);
            }
        });
    }

    private JButton btnBack;
    private JButton btnClear;
    private JButton btnSend;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextArea msgTextArea;
    private JComboBox userListComboBox;


}
