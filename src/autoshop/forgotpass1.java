/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sohail
 */
public class forgotpass1 extends javax.swing.JFrame {

    /**
     * Creates new form forgotpass1
     */
    public forgotpass1() {
        initComponents();
    }

    
    public void forgotpass(String ui,String np){
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("update signup1 set Password=? where UserId=?");
             PreparedStatement pst=con.prepareStatement(sql);
              
            
              pst.setString(1, np);
              pst.setString(2, ui);
            
              
              int rowcount = pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Updated successfully");
                      Login l1=new Login();
                      l1.show();
                      this.dispose();
                              
                     
                     
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Password not Updated successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cpas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        npas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        msg1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 260));

        cpas.setBackground(new java.awt.Color(0, 153, 153));
        cpas.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        cpas.setForeground(new java.awt.Color(255, 255, 255));
        cpas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confiram Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 25), new java.awt.Color(255, 255, 255))); // NOI18N
        cpas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpasActionPerformed(evt);
            }
        });
        jPanel2.add(cpas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 410, 70));

        jButton1.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("Submit");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 740, 60));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Forgot Your Password ?");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 430, -1));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        uid.setBackground(new java.awt.Color(0, 153, 153));
        uid.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        uid.setForeground(new java.awt.Color(255, 255, 255));
        uid.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UserId", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 25), new java.awt.Color(255, 255, 255))); // NOI18N
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 410, 70));

        npas.setBackground(new java.awt.Color(0, 153, 153));
        npas.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        npas.setForeground(new java.awt.Color(255, 255, 255));
        npas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 25), new java.awt.Color(255, 255, 255))); // NOI18N
        npas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npasActionPerformed(evt);
            }
        });
        jPanel2.add(npas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 410, 70));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        msg1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(msg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 670, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 850, 580));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String ui1=uid.getText();
        String pas=npas.getText();
        forgotpass(ui1,pas);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void npasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npasActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(forgotpass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpass1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpass1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel msg1;
    private javax.swing.JTextField npas;
    private javax.swing.JTextField uid;
    // End of variables declaration//GEN-END:variables
}
