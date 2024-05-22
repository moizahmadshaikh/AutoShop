/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Sohail
 */
public class sigup extends javax.swing.JFrame {
    
    String un,ui,pas,cpas,ad,con1;
//    Date dob;
    int id=0;

   
    public sigup() {
        initComponents();
    }
 private void clearfield(){
        UN.setText(null);
        UI.setText(null);
        PAS.setText(null);
        CPAS.setText(null);
        //DOB.setDate(null);
        AD.setText(null);
//        EM.setText("");
        CON.setText(null);
 }
 
 public int getId(){
         ResultSet rs=null;
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql="select max(id) from signup" ;
             Statement st=con.createStatement();
             st.execute(sql);
             while(rs.next()){
                 id++;
                 id=rs.getInt(1);
                     
             }
           
             
        } catch (Exception e) {
            System.out.print(e);
        }
        return id;
            
        }

 
  boolean signupValidation()
  {
      String un,ui,pas,cpas,ad,con1;
   
    int id=0;
     
      
      un=UN.getText();
      ui=UI.getText();
      pas=PAS.getText();
      cpas=CPAS.getText();
     
    
               
      con1=CON.getText();
      ad=AD.getText();
      
      if(un.equals("")){
          JOptionPane.showMessageDialog(this, "Please Enter User Name");
          return false;
          
      }
      if(ui.equals("")){
          JOptionPane.showMessageDialog(this, "Please Create User ID");
          return false;
          
      }
      if(pas.equals("")){
          JOptionPane.showMessageDialog(this, "Please Create Password");
          return false;
          
      }
      if(cpas.equals("")){
          JOptionPane.showMessageDialog(this, "Please Conferm The Password");
          return false;
          
      }
     
      if(con1.equals("")){
          JOptionPane.showMessageDialog(this, "Please Enter Contact no");
          return false;
          
      }
      if(ad.equals("")){
          JOptionPane.showMessageDialog(this, "Please Enter Address");
          return false;
          
      }
     
      return true;

  }
  
     
  
   
  public void checkpass(){
     pas=PAS.getText();
      if(pas.length()<8){
         pasLable.setText("Password should be 8 Digit");
      }
      else{
           pasLable.setText("");
      }
  }
      
      public void checkphone(){
       con1=CON.getText();
      if(con1.length()==10){
         Colable1.setText("Contact Should be 10 Digit");
      }
      else{
           Colable1.setText("");
      }
      
  }
      
      
      
     public void AddAdmin(String pid,String pname, String pas, int pcategory ,String pcompany  ){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql="insert into signup1 values(?,?,?,?,?)" ;
             PreparedStatement pst=con.prepareStatement(sql);
              pst.setString(1, pid);
              pst.setString(2, pname);
              pst.setString(3, pas);
              pst.setInt(4,pcategory);
              pst.setString(5, pcompany);
             
            
            
              
              int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Inserted successfully");
                     
                      
                    
                      
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Inserted successfully");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        UN = new javax.swing.JTextField();
        UI = new javax.swing.JTextField();
        PAS = new javax.swing.JTextField();
        CPAS = new javax.swing.JTextField();
        AD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pasLable = new javax.swing.JLabel();
        CON = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Colable1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 20));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" User Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 250, -1));

        jLabel2.setBackground(new java.awt.Color(0, 153, 204));
        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User ID/Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 153, 204));
        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm pass:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, 40));

        jLabel4.setBackground(new java.awt.Color(0, 153, 204));
        jLabel4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Password :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 153, 204));
        jLabel5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        UN.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        UN.setForeground(new java.awt.Color(0, 153, 204));
        UN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNActionPerformed(evt);
            }
        });
        jPanel2.add(UN, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 380, 40));

        UI.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        UI.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(UI, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 380, 40));

        PAS.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        PAS.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(PAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 380, 40));

        CPAS.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        CPAS.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(CPAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 380, 40));

        AD.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        AD.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(AD, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 380, 40));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 790, 140, 40));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("signup");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 790, 240, 40));

        jLabel7.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registration");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        pasLable.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        pasLable.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(pasLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 390, 40));

        CON.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        CON.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(CON, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 380, 40));

        jLabel10.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Address :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 120, 40));

        Colable1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        Colable1.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(Colable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, 390, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1020, 970));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          clearfield();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       String Uname=UN.getText();
       String ui=UI.getText();
        String Pas=PAS.getText();
         int con=Integer.parseInt(CON.getText());
          String ad=AD.getText();
          AddAdmin(Uname,ui,Pas,con,ad);
         Login p1=new Login();
        p1.show();
        this.dispose(); 
                     
          
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void UNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UNActionPerformed

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
            java.util.logging.Logger.getLogger(sigup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sigup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sigup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sigup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sigup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AD;
    private javax.swing.JTextField CON;
    private javax.swing.JTextField CPAS;
    private javax.swing.JLabel Colable1;
    private javax.swing.JTextField PAS;
    private javax.swing.JTextField UI;
    private javax.swing.JTextField UN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pasLable;
    // End of variables declaration//GEN-END:variables
}
