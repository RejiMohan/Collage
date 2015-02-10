package com.collage.forms;

import com.collage.database.DatabaseProcess;
import com.collage.fileTransfer.Client;
import com.collage.imageOper.Encoder;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class CreateMess extends javax.swing.JFrame {

    private List userList = new ArrayList();
    private DatabaseProcess dp = new DatabaseProcess();
    private String user = Login.getUsername();

    /**
     * Creates new form CreateMess
     */
    public CreateMess() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        userList = dp.listUsers(1);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).toString().equals(user)) {
                continue;
            }
            u_list.addItem(userList.get(i));
        }

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_txt = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        u_list = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        Send = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setText("Create Message");

        msg_txt.setColumns(20);
        msg_txt.setRows(5);
        jScrollPane1.setViewportView(msg_txt);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel2.setText("To");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12));
        jLabel3.setText("Message:");

        Send.setFont(new java.awt.Font("Verdana", 0, 11));
        Send.setForeground(new java.awt.Color(51, 51, 51));
        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        Clear.setFont(new java.awt.Font("Verdana", 0, 11));
        Clear.setForeground(new java.awt.Color(51, 51, 51));
        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Verdana", 0, 11));
        Back.setForeground(new java.awt.Color(51, 51, 51));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(u_list, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 189, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE, 368, javax.swing.GroupLayout
                                                                .PREFERRED_SIZE)
                                                        .addComponent(jLabel3)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(Send)
                                                .addGap(27, 27, 27)
                                                .addComponent(Clear)
                                                .addGap(27, 27, 27)
                                                .addComponent(Back)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing
                                        .GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(u_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                        .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Send)
                                        .addComponent(Clear)
                                        .addComponent(Back))
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {
        msg_txt.setText("");
    }

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {
        String msg;
        String ip;
        try {
            msg = msg_txt.getText();
            Encoder en = new Encoder();
            String op = en.convert(msg);
            ip = new DatabaseProcess().getIP(u_list.getSelectedItem().toString());
            new Client(ip).send(op, u_list.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Message Sent");
            msg_txt.setText("");
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {
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

    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msg_txt;
    private javax.swing.JComboBox u_list;


}
