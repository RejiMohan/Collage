/*
 * MessageOut.java
 *
 * Created on December 31, 2010, 6:22 PM
 */

package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.collage.image.ImageFinder;

/**
 * @author adima
 */
public class MessageOut extends JFrame {

    /**
     * Creates new form MessageOut
     */
    public MessageOut() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            String r = new Sent().r_name;
            //System.out.println(r);
            receiver.setText(r.substring(r.indexOf(" ")).trim());
            String[] t = r.substring(0, r.indexOf(" ")).trim().split("-");
            for (int i = 0; i < 3; i++) {
                if (t[i].length() == 1) {
                    t[i] = "0" + t[i];
                }
            }
            time.setText(t[0] + ":" + t[1] + ":" + t[2]);
            mess_txt.setText(new ImageFinder().getMessage("./sent/" + Login.getUsername() + "/" + new Sent().r_name
                    + ".jpg"));
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        jButton1 = new JButton();
        receiver = new JTextField();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        mess_txt = new JTextArea();
        jLabel2 = new JLabel();
        time = new JTextField();
        jLabel3 = new JLabel();
        Back = new JButton();
        DeleteMess = new JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        receiver.setFont(new Font("Verdana", 0, 11)); 
        receiver.setBorder(null);
        receiver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                receiverActionPerformed();
            }
        });

        jLabel1.setFont(new Font("Verdana", 0, 11)); 
        jLabel1.setText("Sent to");

        mess_txt.setColumns(20);
        mess_txt.setRows(5);
        jScrollPane1.setViewportView(mess_txt);

        jLabel2.setText("@");

        time.setFont(new Font("Verdana", 0, 11)); 
        time.setBorder(null);

        jLabel3.setFont(new Font("Verdana", 0, 11)); 
        jLabel3.setText("Message");

        Back.setFont(new Font("Verdana", 0, 11)); 
        Back.setForeground(new Color(51, 51, 51));
        Back.setText("Back");
        Back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackActionPerformed();
            }
        });

        DeleteMess.setFont(new Font("Verdana", 0, 11)); 
        DeleteMess.setForeground(new Color(51, 51, 51));
        DeleteMess.setText("Delete Message");
        DeleteMess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeleteMessActionPerformed();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(receiver, PREFERRED_SIZE, 152, PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                UNRELATED)
                                                        .addComponent(time, PREFERRED_SIZE,
                                                                68, PREFERRED_SIZE))
                                                .addComponent(jScrollPane1,
                                                        LEADING, PREFERRED_SIZE, 254, PREFERRED_SIZE)))
                                .addContainerGap(71, Short.MAX_VALUE))
                        .addGroup(TRAILING, layout.createSequentialGroup()
                                .addContainerGap(108, Short.MAX_VALUE)
                                .addComponent(Back)
                                .addGap(31, 31, 31)
                                .addComponent(DeleteMess)
                                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(receiver, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(jScrollPane1, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(time, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(DeleteMess)
                                        .addComponent(Back))
                                .addGap(27, 27, 27))
        );

        pack();
    }

    private void receiverActionPerformed() {
    }
    private void BackActionPerformed() {
        this.setVisible(false);
        new Sent().setVisible(true);
    }

    private void DeleteMessActionPerformed() {
        File f = new File("./sent/" + Login.getUsername() + "/" + new Sent().r_name + ".jpg");
        f.delete();
        JOptionPane.showMessageDialog(null, "Message Deleted");
        this.setVisible(false);
        new Sent().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageOut().setVisible(true);
            }
        });
    }

    private JButton Back;
    private JButton DeleteMess;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextArea mess_txt;
    private JTextField receiver;
    private JTextField time;
}
