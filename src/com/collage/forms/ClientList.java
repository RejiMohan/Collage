package com.collage.forms;

import static javax.swing.GroupLayout.Alignment;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.collage.database.DatabaseProcess;

public class ClientList extends JFrame {

    /**
     * Creates new form ClientList
     */
    private List userList = new ArrayList();
    private DatabaseProcess databaseProcess = new DatabaseProcess();
    private static String selectedUser;

    public static String getSelectedUser() {
        return selectedUser;
    }

    public ClientList() {
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
        clientJList.setListData(userList.toArray());
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     */
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        clientJList = new JList();
        btnView = new JButton();
        btnBack = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 640));

        clientJList.setBorder(new LineBorder(new Color(102, 102, 102), 1, true));
        clientJList.setFont(new Font("Verdana", 0, 12));
        jScrollPane1.setViewportView(clientJList);

        btnView.setFont(new Font("Verdana", 0, 11));
        btnView.setForeground(new Color(51, 51, 51));
        btnView.setText("View Details");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addComponent(jScrollPane1, PREFERRED_SIZE,
                                                        356, PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(btnView)
                                                .addGap(87, 87, 87)
                                                .addComponent(btnBack, PREFERRED_SIZE, 64, PREFERRED_SIZE)))
                                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, PREFERRED_SIZE, 297, PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnBack)
                                        .addComponent(btnView))
                                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }

    private void ViewActionPerformed(ActionEvent evt) {
        try {
            selectedUser = clientJList.getSelectedValue().toString();
            this.setVisible(false);
            new Details().setVisible(true);
        } catch (Exception e) {
            showMessageDialog(this, "No User Selected");
        }
    }

    private void BackActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        new AdminHome().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientList().setVisible(true);
            }
        });
    }

    // Variables declaration
    private JButton btnBack;
    private JButton btnView;
    private JList clientJList;
    private JScrollPane jScrollPane1;

}
