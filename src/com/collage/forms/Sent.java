package com.collage.forms;

import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.util.Vector;

public class Sent extends javax.swing.JFrame {

    /**
     * Creates new form Sent
     */
    public static String r_name = "";

    public Sent() {
        initComponents();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int wid = getWidth();
        int heig = getHeight();
        setBounds(center.x - wid / 2, center.y - heig / 2, wid, heig);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Vector v = new Vector();
            File dir = new File("./sent/" + Login.getUsername());

            File[] f = dir.listFiles();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i].getName());
                v.add(f[i].getName().substring(0, f[i].getName().indexOf(".")));
            }
            u_list.setListData(v);

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        u_list = new javax.swing.JList();
        ViewMessage = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Estrangelo Edessa", 3, 14));
        jLabel1.setText("Sent");

        jScrollPane1.setViewportView(u_list);

        ViewMessage.setText("View Message");
        ViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewMessageActionPerformed(evt);
            }
        });

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
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(83, 83, 83)
                                                                .addComponent(ViewMessage))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED, javax.swing
                                                                        .GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Back)
                                                                .addGap(25, 25, 25))))
                                        .addComponent(jLabel1))
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(ViewMessage)
                                                .addGap(40, 40, 40)
                                                .addComponent(Back)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewMessageActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_ViewMessageActionPerformed
// TODO add your handling code here:
        r_name = u_list.getSelectedValue().toString();
        System.out.println("Receiver :" + r_name);
        this.setVisible(false);
        new MessageOut().setVisible(true);
    }//GEN-LAST:event_ViewMessageActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
// TODO add your handling code here:
        this.setVisible(false);
        new UserHome().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton ViewMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList u_list;
    // End of variables declaration//GEN-END:variables

}
