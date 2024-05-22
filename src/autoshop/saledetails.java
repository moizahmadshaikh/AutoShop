/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class saledetails extends javax.swing.JFrame {
DefaultTableModel model;
    static int count=0;
    public saledetails() {
        initComponents();
         autoincrement();
        getcustomer();
        getCategory();
        getCompany();
        SetProductTable();
        SetTable();


    }
    
   public void autoincrement() 
    {
       
        try{
           
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
        PreparedStatement pst=con.prepareStatement("SELECT SaleID from saledetails");
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){
                count=rs.getInt(1);
              
             }
        count=count+1;
          sid.setText(String.valueOf(count));
          con.close();
        }
         catch(Exception e){ 
             
        
    }
    }
    public void clearfield(){
//      sid.setText(null);
//     cname.setSelectedItem(null);
      pid.setText(null);
      pname.setText(null);
      price.setText(null);
       category.setSelectedItem(null);
      company.setSelectedItem(null);
      pnq.setText(null);
       
        stock.setText(null);
         tam.setText(null);
      
}
    public void getcustomer(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             PreparedStatement pst=con.prepareStatement("select *from customer");
             ResultSet rs=pst.executeQuery();
             while (rs.next()){
                 cname.addItem(rs.getString("Name"));
             }
         }
         catch(Exception e){
             System.out.println();
         }
     }
    
    public void getCategory(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             PreparedStatement pst=con.prepareStatement("select *from product");
             ResultSet rs=pst.executeQuery();
             while (rs.next()){
              category.addItem(rs.getString("Category"));
             }
         }
         catch(Exception e){
             System.out.println();
         }
     }
      
      public void getCompany(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             PreparedStatement pst=con.prepareStatement("select *from product");
             ResultSet rs=pst.executeQuery();
             while (rs.next()){
                 company.addItem(rs.getString("Company"));
             }
         }
         catch(Exception e){
             System.out.println();
         }
     }
     public void ClearTable(){
        DefaultTableModel model=( DefaultTableModel)productTable.getModel();
        model.setRowCount(0);
        
        
    } 
 public void ClearTable1(){
        DefaultTableModel model=( DefaultTableModel)saleTable.getModel();
        model.setRowCount(0);
        
        
    }
 
 public void updatestock(){
               
        int pid1=Integer.parseInt(pid.getText());
         int enterqty=Integer.valueOf(qnt.getText());
         int aqty=Integer.valueOf(stock.getText());
         int newqty= aqty-enterqty;  
         try{
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
            PreparedStatement pst=con.prepareStatement("update product set Quantity=? where ID=?");
               pst.setInt(1,newqty);
               pst.setInt(2, pid1);
               pst.executeUpdate();
             JOptionPane.showMessageDialog(this,"Stock is updated");
             ClearTable();
              SetProductTable();
      
        }
        catch(Exception e){
            e.printStackTrace();
        }
   }
 public void  SetProductTable(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("select *from product") ;
             PreparedStatement pst=con.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
                  int id=rs.getInt("ID");//Id is same for table column name or database table column
                  String name=rs.getString("Name");
                   int price=rs.getInt("Price");
                    String category=rs.getString("Category");
                    String company=rs.getString("Company");
                    int dis=rs.getInt("Quantity");
                    
                    Object [] obj = {id,name,price,category,company,dis};
                    model=(DefaultTableModel)productTable.getModel();
                    model.addRow(obj);
                  
              }
           
           
       }catch(Exception e){
           e.printStackTrace();
           
       } 
    }  


    
public void  SetTable(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("select *from saledetails");
             PreparedStatement pst=con.prepareStatement(sql);
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
                  int id=rs.getInt("SaleID");//Id is same for table column name or database table column
                  String cname=rs.getString("CustomerName");
                   int pid=rs.getInt("ProductID");
                   String pname=rs.getString("ProductName");
                    String category=rs.getString("Category");
                        String company=rs.getString("Company");
                    int price=rs.getInt("Price");
                    int stock=rs.getInt("Stock");
                    int qnt=rs.getInt("Quantity");
                     int samt=rs.getInt("SubAmount");
                    int amt=rs.getInt("TotalAmount");
                    
                    Object [] obj = {id,cname,pid,pname,category, company,price,stock,qnt,samt,amt};
                    model=(DefaultTableModel)saleTable.getModel();
                    model.addRow(obj);
                  
              }
           
           
       }catch(Exception e){
           e.printStackTrace();
           
       } 
    }  



    public void Addsales(int sid,String cname, int pid,String pname,String category,String company,int pprice, int stock,int qty1, int tamt,int tam){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql="insert into saledetails values(?,?,?,?,?,?,?,?,?,?,?)" ;
             PreparedStatement pst=con.prepareStatement(sql);
              pst.setInt(1, sid);
              pst.setString(2, cname);
              pst.setInt(3,pid);
              pst.setString(4, pname);
              pst.setString(5,category);
              pst.setString(6,company);
              pst.setInt(7,pprice  );
              pst.setInt(8, stock);
              pst.setInt(9, qty1);
              pst.setInt(10,tamt);
                pst.setInt(11,tam);
              int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Inserted successfully");
                      
                      ClearTable();
                      ClearTable1();
                       SetTable();
                      SetProductTable();
                        
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Inserted successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
       
    }
    
    
     public void Updatesale(int sid,String cname, int pid,String pname,String category,String company,int pprice, int stock,int qty1, int tamt,int tam){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("update saledetails set CustomerName=? ,ProductID=?,ProductName=?,Category=?,Company=?, Price=?, Stock=?, Quantity=?  , SubAmount=?,Amount=? where SaleID=?");
             PreparedStatement pst=con.prepareStatement(sql);
               
              pst.setString(1, cname);
              pst.setInt(2,pid);
              pst.setString(3, pname);
              pst.setString(4,category);
               pst.setString(5,company);
              pst.setInt(6,pprice  );
              pst.setInt(7, stock);
              pst.setInt(8, qty1);
              pst.setInt(9,tamt);
               pst.setInt(10,tam);
              pst.setInt(11, sid);
            
              
              int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Updated successfully");
                        
                      ClearTable();
                      ClearTable1();
                     SetTable();
                      SetProductTable();
                     
                     
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Updated successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
    
    
     public void SaleDelete(int pid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("delete from saledetails where SaleID=?");
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,pid);
             int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Deleted successfully");
                      ClearTable();
                      ClearTable1();
                        SetTable();
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
        jLabel3 = new javax.swing.JLabel();
        dnt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        company = new javax.swing.JComboBox<>();
        cname = new javax.swing.JComboBox<>();
        category = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnq = new javax.swing.JTextField();
        qnt = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel2.setBackground(new java.awt.Color(0, 0, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AUTOMOBILE SHOP");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 830, 110));

        dnt.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        dnt.setForeground(new java.awt.Color(255, 255, 255));
        panel2.add(dnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 80, 270, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sale-details :");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setText("Home");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 140, 50));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 120));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Stock");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));

        sid.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        sid.setForeground(new java.awt.Color(0, 0, 204));
        jPanel2.add(sid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 70));

        company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyActionPerformed(evt);
            }
        });
        jPanel2.add(company, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 180, 40));

        jPanel2.add(cname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 180, 40));

        jPanel2.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 180, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("SaleID");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Customer Name ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Category");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Company");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel13.setText("Product ID");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Product Name");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        pname.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        jPanel2.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 180, 40));

        stock.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        stock.setForeground(new java.awt.Color(255, 153, 0));
        jPanel2.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 170, 60));

        pid.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPanel2.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 830, 230));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setText("TotalAmount");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("Price");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        pnq.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pnq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pnqFocusLost(evt);
            }
        });
        pnq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnqMouseClicked(evt);
            }
        });
        pnq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnqActionPerformed(evt);
            }
        });
        jPanel3.add(pnq, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, 80));

        qnt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        qnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qntActionPerformed(evt);
            }
        });
        jPanel3.add(qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 40));

        price.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel3.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 40));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setText("Quantity");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("Sub-Total");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        tam.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tamMouseClicked(evt);
            }
        });
        tam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamActionPerformed(evt);
            }
        });
        jPanel3.add(tam, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 160, 80));

        jButton1.setText("GoToPrint");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 90, -1));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 90, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 90, -1));

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 90, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 1040, 230));

        productTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        productTable.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Category", "Company", "Quantity"
            }
        ));
        productTable.setRowHeight(30);
        productTable.setRowMargin(4);
        productTable.setUpdateSelectionOnSort(false);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productTableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(productTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 820, 550));

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SaleID", "CustomerName", "ProductID", "ProductName", "Category", "Company", "Price", "Stock", "Quantity", "SubAmount", "TotalAmount"
            }
        ));
        saleTable.setRowHeight(25);
        saleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saleTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 980, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 2030, 930));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyActionPerformed

    private void pnqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnqActionPerformed

    private void qntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qntActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void tamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        int row=productTable.getSelectedRow();
        TableModel model=productTable.getModel();
        pid.setText(model.getValueAt(row,0).toString());
        pname.setText(model.getValueAt(row,1).toString());
        price.setText(model.getValueAt(row,2).toString());
        category.setSelectedItem(model.getValueAt(row,3).toString());
        company.setSelectedItem(model.getValueAt(row,4).toString());
        stock.setText(model.getValueAt(row,5).toString());
    }//GEN-LAST:event_productTableMouseClicked

    private void productTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_productTableMouseEntered

    private void saleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleTableMouseClicked
        int row=saleTable.getSelectedRow();
        TableModel model=saleTable.getModel();
        sid.setText(model.getValueAt(row,0).toString());
        cname.setSelectedItem(model.getValueAt(row,1).toString());
        pid.setText(model.getValueAt(row,2).toString());
        pname.setText(model.getValueAt(row,3).toString());
        category.setSelectedItem(model.getValueAt(row,4).toString());
        company.setSelectedItem(model.getValueAt(row,5).toString());
        price.setText(model.getValueAt(row,6).toString());
        stock.setText(model.getValueAt(row,7).toString());
        qnt.setText(model.getValueAt(row, 8).toString());
        pnq.setText(model.getValueAt(row,9).toString());
        tam.setText(model.getValueAt(row,10).toString()); // TODO add your handling code here:
    }//GEN-LAST:event_saleTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int id=Integer.parseInt(sid.getText());            
        SaleDelete(id);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


            int id=Integer.parseInt(sid.getText());
        String name=(String) cname.getSelectedItem();
        int ProductId=Integer.parseInt(pid.getText());
        String ProductName=pname.getText();
        String category1=(String)category.getSelectedItem();
        String company1=(String)company.getSelectedItem();
        int price1=Integer.parseInt(price.getText());
        int stock1=Integer.parseInt(stock.getText());
        int quantity=Integer.parseInt(qnt.getText());
         int subamount=Integer.parseInt(pnq.getText());
        int amount=Integer.parseInt(tam.getText());
        
       Addsales( id,name, ProductId,ProductName, category1,company1 ,price1,stock1, quantity,subamount,amount);  
      updatestock();
       clearfield();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            
            int id=Integer.parseInt(sid.getText());
        String name=(String) cname.getSelectedItem();
        int ProductId=Integer.parseInt(pid.getText());
        String ProductName=pname.getText();
        String category1=(String)category.getSelectedItem();
        String company1=(String)company.getSelectedItem();
        int price1=Integer.parseInt(price.getText());
        int stock1=Integer.parseInt(stock.getText());
        int quantity=Integer.parseInt(qnt.getText());
         int subamount=Integer.parseInt(pnq.getText());
        int amount=Integer.parseInt(tam.getText());
        
       Updatesale( id,name, ProductId,ProductName, category1,company1 ,price1,stock1, quantity,subamount,amount);  
       



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


         Billpage b1=new Billpage();
         b1.show();
         this.dispose();
        
           
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pnqFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnqFocusLost

           int price1=Integer.parseInt(price.getText());
           int quantity=Integer.parseInt(qnt.getText());
           int total=price1*quantity;
           pnq.setText(String.valueOf(total));
           

        // TODO add your handling code here:
    }//GEN-LAST:event_pnqFocusLost

    private void tamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tamMouseClicked

            int stotal=Integer.parseInt(pnq.getText());
        int discount = (stotal*5)/100;
        int sdiscount=stotal-discount;
        tam.setText(String.valueOf(sdiscount));


        // TODO add your handling code here:
    }//GEN-LAST:event_tamMouseClicked

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        homepage h1=new homepage();
        h1.show();
        this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void pnqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnqMouseClicked

            int price1=Integer.parseInt(price.getText());
           int quantity=Integer.parseInt(qnt.getText());
           int total=price1*quantity;
           pnq.setText(String.valueOf(total));

        // TODO add your handling code here:
    }//GEN-LAST:event_pnqMouseClicked

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
            java.util.logging.Logger.getLogger(saledetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(saledetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(saledetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(saledetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new saledetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> category;
    public static javax.swing.JComboBox<String> cname;
    private javax.swing.JComboBox<String> company;
    private javax.swing.JLabel dnt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel2;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pnq;
    private javax.swing.JTextField price;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qnt;
    private javax.swing.JTable saleTable;
    public static javax.swing.JTextField sid;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField tam;
    // End of variables declaration//GEN-END:variables
}
