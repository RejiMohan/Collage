package com.collage.forms;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.collage.image.ImageFinder;

public class MessageIn extends JFrame {

    /**
     * Creates new form MessageIn
     */
    public MessageIn() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            String s = new Inbox().selectedUser;
            String r = Login.getUsername();
            senderTextField.setText(s.substring(s.indexOf(" ")).trim());
            String[] t = s.substring(0, s.indexOf(" ")).trim().split("-");
            for (int i = 0; i < 3; i++) {
                if (t[i].length() == 1)
                    t[i] = "0" + t[i];
            }
            timeTextField.setText(t[0] + ":" + t[1] + ":" + t[2]);
            //String m=new ImageFinder().getMessage("./inbox/"+s+".jpg");
            //System.out.println("Message:"+m);
            messageTextArea.setText(new ImageFinder().getMessage("./inbox/" + Login.getUsername() + "/" + new Inbox()
                    .selectedUser + ".jpg"));
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
    @SuppressWarnings("unchecked")
    private void initComponents() {

        senderTextField = new JTextField();
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        messageTextArea = new JTextArea();
        btnBack = new JButton();
        btnDelete = new JButton();
        jLabel2 = new JLabel();
        timeTextField = new JTextField();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        senderTextField.setBorder(null);

        jLabel1.setFont(new Font("Verdana", 0, 11));
        jLabel1.setText("Sender");

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        btnBack.setFont(new Font("Verdana", 0, 11));
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                BackMouseClicked();
            }
        });
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackActionPerformed();
            }
        });

        btnDelete.setFont(new Font("Verdana", 0, 11));
        btnDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeleteActionPerformed();
            }
        });

        jLabel2.setFont(new Font("Verdana", 0, 11));
        jLabel2.setText("@");

        timeTextField.setFont(new Font("Verdana", 0, 11));
        timeTextField.setBorder(null);

        jLabel3.setFont(new Font("Verdana", 0, 11));
        jLabel3.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                .addPreferredGap(UNRELATED)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBack)
                                                .addGap(34, 34, 34)
                                                .addComponent(btnDelete))
                                        .addComponent(senderTextField, PREFERRED_SIZE, 127, PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                UNRELATED)
                                                        .addComponent(timeTextField, PREFERRED_SIZE,
                                                                72, PREFERRED_SIZE))
                                                .addComponent(jScrollPane1,
                                                        LEADING, PREFERRED_SIZE, 259, PREFERRED_SIZE)))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(senderTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1, PREFERRED_SIZE, DEFAULT_SIZE,
                                                PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(timeTextField, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short
                                        .MAX_VALUE)
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(btnBack)
                                        .addComponent(btnDelete))
                                .addGap(27, 27, 27))
        );

        pack();
    }

    private void BackActionPerformed() {
        this.setVisible(false);
        new Inbox().setVisible(true);
    }

    private void DeleteActionPerformed() {
        //System.out.println("./inbox/"+new Login().username+"/"+new Inbox().selectedUser+".jpg");
        File file = new File("./inbox/" + Login.getUsername() + "/" + new Inbox().selectedUser + ".jpg");
        file.delete();
        JOptionPane.showMessageDialog(null, "Message Deleted");
        this.setVisible(false);
        new Inbox().setVisible(true);
    }

    private void BackMouseClicked() {
        //this.setForeground(Color.BLACK);
        //this.setBackground(Color.GREEN);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageIn().setVisible(true);
            }
        });
    }

    private JButton btnBack;
    private JButton btnDelete;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextArea messageTextArea;
    private JTextField senderTextField;
    private JTextField timeTextField;
}
