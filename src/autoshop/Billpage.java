/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sohail
 */
public class Billpage extends javax.swing.JFrame {
    DefaultTableModel model;
    int sid, price, qunt,amt;
    String cname, pname;
    
    public Billpage() {
        initComponents();
        sale_id.setText(saledetails.sid.getText());
        String b1=String.valueOf(saledetails.cname.getSelectedItem());
        customer_name.setText(b1);
         subTotal();
        getRecords();
        customer();
        datetime();
        SetProductTable();
    }

    public void getRecords(){
      
        
       try{
             int sid=Integer.parseInt(sale_id.getText());
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             PreparedStatement pst=con.prepareStatement("select ProductName, Price, Quantity,TotalAmount, CustomerName from saledetails where SaleID=?");
             
            
           
               pst.setInt(1, sid);
             
                ResultSet rs=pst.executeQuery();
            while( rs.next())
            {
             
                              
            // sale_id.setText(rs.getString("SaleID"));
             pname=rs.getString("ProductName");   
             price=rs.getInt("Price");
             qunt=rs.getInt("Quantity");
             amt=rs.getInt("TotalAmount");
//             discount.setText(rs.getString("Amount"));
//             total.setText(rs.getString("Amount"));
//             customer_name.setText(rs.getString("CustomerName"));
                   Object [] obj = {pname,price,qunt,amt};
                    model=(DefaultTableModel)details.getModel();
                    model.addRow(obj);
                   
            }
            con.close();
             
       }
       catch(Exception e){
           System.out.println(e);
           
       }
             
    }
    
   public void subTotal(){
       try{
           int sum=0;
                  int sid=Integer.parseInt(sale_id.getText());
                  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
            
                    
                   PreparedStatement pst1=con.prepareStatement("select SUM(TotalAmount) from saledetails where SaleID=?");
                   pst1.setInt(1, sid);
                   ResultSet rs1=pst1.executeQuery();
                   while( rs1.next())
                   {
                     sum=rs1.getInt(1);
                    }
                  
                   
                   total.setText(String.valueOf(sum));
                   
            
        
           
       }
       catch(Exception e){
         System.out.println(e);
           
       }
   }
   
   public void customer(){
       try{
           
                  int sid=Integer.parseInt(sale_id.getText());
                  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
                  PreparedStatement pst1=con.prepareStatement("select CustomerName from saledetails where SaleID=?");
                  ResultSet rs1=pst1.executeQuery();
                  rs1.next();
                  customer_name.setText(rs1.getString("CustomerName"));
       }
       catch(Exception e){
         System.out.println(e);
           
       }
   }
   
   public void datetime(){
          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    Date date1 = new Date();  
    System.out.println(formatter.format(date1));     
    date.setText(formatter.format(date1));
        
    }
   
     public void ClearTable(){
        DefaultTableModel model=( DefaultTableModel)printTable.getModel();
        model.setRowCount(0);
     }
   public void  SetProductTable(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("select *from ordertotalbill") ;
             PreparedStatement pst=con.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
                  int id=rs.getInt("ID");//Id is same for table column name or database table column
                  String name=rs.getString("Customer Name");
                 String dd=rs.getString("Date");
                    double al=rs.getDouble("Total");
                   
                    
                    Object [] obj = {id,name,dd,al};
                    model=(DefaultTableModel)printTable.getModel();
                    model.addRow(obj);
                  
              }
           
           
       }catch(Exception e){
           e.printStackTrace();
           
       } 
    }    
    
    
    public void Addbill(int pid,String cname, String date , double total){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql="insert into ordertotalbill values(?,?,?,?)" ;
             PreparedStatement pst=con.prepareStatement(sql);
              pst.setInt(1, pid);
              pst.setString(2, cname);
              pst.setString(3,date);
              pst.setDouble(4, total);
            
              
              int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Inserted successfully");
                      ClearTable();
                      SetProductTable();
                      
                    
                      
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Inserted successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
    
    public void Deletebill(int pid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("delete from ordertotalbill where Id=?");
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,pid);
             int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Deleted successfully");
                      ClearTable();
                      SetProductTable();
                      
                     
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Deleted successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new java.awt.Panel();
        dnt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dnt1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        Panel_print = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sale_id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        customer_name = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        details = new javax.swing.JTable();
        total = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        printTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(0, 0, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dnt.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        dnt.setForeground(new java.awt.Color(255, 255, 255));
        panel2.add(dnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 80, 270, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sale-Receipt :");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AUTOMOBILE SHOP");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 830, 70));

        dnt1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        dnt1.setForeground(new java.awt.Color(255, 255, 255));
        panel2.add(dnt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 80, 270, 30));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 140, 50));

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton6.setText("Home");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 140, 50));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 120));

        panel1.setBackground(new java.awt.Color(153, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_print.setBackground(new java.awt.Color(255, 255, 255));
        Panel_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        Panel_print.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 800, 3));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Nath Plaza,  Near the Krishna IceCream Sath Rasta Solapur.");
        Panel_print.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 640, 60));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 38)); // NOI18N
        jLabel6.setText("AUTOMOBILE SHOP");
        Panel_print.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 410, 70));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel8.setText("Stocks of all Two Wheeler Spare Parts");
        Panel_print.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 510, 60));

        sale_id.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sale_id.setText("123");
        Panel_print.add(sale_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("SaleID");
        Panel_print.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Customer Name ");
        Panel_print.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        customer_name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        customer_name.setText("Huzaifa");
        Panel_print.add(customer_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        details.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Price", "Quantity", "TotalAmount"
            }
        ));
        details.setRowHeight(30);
        jScrollPane2.setViewportView(details);

        Panel_print.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 760, 190));

        total.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        total.setText("2345");
        Panel_print.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 610, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel19.setText("Thank You Visit Again!");
        Panel_print.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Date :");
        Panel_print.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 70, -1));

        date.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        date.setText("jLabel1");
        Panel_print.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 190, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setText("TotalAmount");
        Panel_print.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, -1, -1));

        panel1.add(Panel_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, 800, 810));

        printTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Date", "Total"
            }
        ));
        jScrollPane1.setViewportView(printTable);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 730, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 100, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 90, 40));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1960, 970));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

    PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);
                
                Panel_print.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
homepage s1=new homepage();
        s1.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           int id=Integer.parseInt(sale_id.getText());
           String cName=customer_name.getText();
           String date1=date.getText();
           double total1=Double.parseDouble(total.getText());
           Addbill(id,cName,date1,total1);
           // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     int id=Integer.parseInt(sale_id.getText());
     Deletebill(id);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Billpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_print;
    private javax.swing.JLabel customer_name;
    private javax.swing.JLabel date;
    private javax.swing.JTable details;
    private javax.swing.JLabel dnt;
    private javax.swing.JLabel dnt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTable printTable;
    private javax.swing.JLabel sale_id;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
