package com.collage.forms;

import com.collage.database.DatabaseProcess;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class ManageClient extends javax.swing.JFrame {

    /**
     * Creates new form ManageClient
     */
    DatabaseProcess dp = new DatabaseProcess();
    Vector v = new Vector();
    String add = "";
    String a[] = new String[4];
    int x = 0;

    public ManageClient() {
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
        v = dp.listUsers("1");
        for (int i = 0; i < v.size(); i++)
            c_list.addItem(v.get(i));
        try {
            String u = c_list.getSelectedItem().toString();
            add = dp.showip(u);
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
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c_list = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ip1 = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ip2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ip3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ip4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 640));

        c_list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_listItemStateChanged(evt);
            }
        });

        jLabel1.setText("Select User ");

        jLabel2.setText("IP");

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText(".");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText(".");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(c_list, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short
                                                        .MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ip1, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 42, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE))
                                                        .addComponent(OK))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout
                                                        .Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 4, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(ip2, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 42, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(ip3, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 44, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 6, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED)
                                                                .addComponent(ip4, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE, 39, javax.swing.GroupLayout
                                                                        .PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addComponent(Clear)
                                                                .addPreferredGap(javax.swing.LayoutStyle
                                                                        .ComponentPlacement.RELATED, javax.swing
                                                                        .GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Back)))))
                                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(c_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ip1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing
                                                .GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(ip2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing
                                                .GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(ip4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(ip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing
                                                .GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Clear)
                                        .addComponent(Back)
                                        .addComponent(OK))
                                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
// TODO add your handling code here:
        String i1 = "", i2 = "", i3 = "", i4 = "";
        String s = "", p = "";
        try {
            s = c_list.getSelectedItem().toString();
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
                int a = dp.addIpAddress(s, p);
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

    }//GEN-LAST:event_OKActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
// TODO add your handling code here:
        ip1.setText("");
        ip2.setText("");
        ip3.setText("");
        ip4.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
// TODO add your handling code here:
        this.setVisible(false);
        new A_home().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void c_listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_listItemStateChanged
// TODO add your handling code here:
        try {
            String u = c_list.getSelectedItem().toString();
            add = dp.showip(u);
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
    }//GEN-LAST:event_c_listItemStateChanged

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JButton OK;
    private javax.swing.JComboBox c_list;
    private javax.swing.JTextField ip1;
    private javax.swing.JTextField ip2;
    private javax.swing.JTextField ip3;
    private javax.swing.JTextField ip4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}