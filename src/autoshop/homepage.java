/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop;


import java.time.LocalDateTime;
import java.text.SimpleDateFormat;  
import java.util.Date;


/**
 *
 * @author Sohail
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    public homepage() {
        initComponents();
        datetime();
    }
public void datetime(){
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();  
    System.out.println(formatter.format(date));     
    dnt.setText(formatter.format(date));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dnt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(0, 0, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AUTOMOBILE SHOP");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 830, 140));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autoshop/h3.jpg"))); // NOI18N
        panel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        dnt.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        dnt.setForeground(new java.awt.Color(255, 255, 255));
        panel2.add(dnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 80, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATE & TIME :");
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 40, 180, -1));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 180));

        panel3.setBackground(new java.awt.Color(0, 0, 0));
        panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/autoshop/img79.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        panel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1760, 810));

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 180, 1180, 870));

        jPanel3.setBackground(new java.awt.Color(102, 152, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel13.setText("Products");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 230, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 380, 70));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setText("Customer");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 230, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 380, 70));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setText("Category");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 230, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 380, 70));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setText("Company");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 230, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 380, 70));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel17.setText("Reports");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 230, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 380, 70));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setText("Manage Bill");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 230, -1));

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Company");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 230, -1));

        jPanel11.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 380, 70));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 380, 70));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setText("Back");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 60));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setText("LogOut");
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, -1));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 650, 380, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 850, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
            product1 p1=new product1();
        p1.show();
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
 customer c1=new customer();   
 c1.show();
 this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        
category c2=new category();
        c2.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        compnay l1=new compnay();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        report t1 =new report();
        t1.show();
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
          homepage h1=new homepage();
        h1.show();
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
             Login r1=new Login();
             r1.show();
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
      saledetails s1=new saledetails();
      s1.show();
this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

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
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dnt;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    // End of variables declaration//GEN-END:variables
}
