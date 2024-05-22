
package autoshop;

import static autoshop.saledetails.count;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class product1 extends javax.swing.JFrame {
    
    DefaultTableModel model;

    public product1() {
        initComponents();
        getCategory();
        getCompany();
        SetProductTable();
        autoincrement();
        
    }
    
    public void autoincrement() 
    {
       
        try{
           
        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
        PreparedStatement pst=con.prepareStatement("SELECT ID from product");
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){
                count=rs.getInt(1);
              
             }
        count=count+1;
          pid.setText(String.valueOf(count));
          con.close();
        }
         catch(Exception e){ 
             
        
    }
    }
    
    public void clearfield(){
//      pid.setText(null);
      pname1.setText(null);
      pprice.setText(null);
       pcompany.setSelectedItem(null);
      pcategory.setSelectedItem(null);
      qnt.setText(null);
      
     
   
   }
    public void getCategory(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             PreparedStatement pst=con.prepareStatement("select *from category");
             ResultSet rs=pst.executeQuery();
             while (rs.next()){
                 pcategory.addItem(rs.getString("Name"));
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
             PreparedStatement pst=con.prepareStatement("select *from company");
             ResultSet rs=pst.executeQuery();
             while (rs.next()){
                 pcompany.addItem(rs.getString("Name"));
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
                   String cate=rs.getString("Category");
                    String company=rs.getString("Company");
                    int qnt=rs.getInt("Quantity");
                    
                    
                    Object [] obj = {id,name,price,cate,company,qnt};
                    model=(DefaultTableModel)productTable.getModel();
                    model.addRow(obj);
                  
              }
           
           
       }catch(Exception e){
           e.printStackTrace();
           
       } 
    }    
    
    
    public void AddProduct(int pid,String pname, int pprice, String pcategory ,String pcompany , int qnt1 ){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql="insert into product values(?,?,?,?,?,?)" ;
             PreparedStatement pst=con.prepareStatement(sql);
              pst.setInt(1, pid);
              pst.setString(2, pname);
              pst.setInt(3, pprice);
              pst.setString(4,pcategory);
              pst.setString(5, pcompany);
               pst.setInt(6, qnt1);
            
              
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
    
    
     public void UpdateProduct(int pid,String pname, int pprice,String pcategory, String pcompany , int qnt1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("update product set Name=? , Price=?, Category=?, Company=? , Quantity=? where ID=?");
             PreparedStatement pst=con.prepareStatement(sql);
              
              pst.setString(1, pname);
              pst.setInt(2, pprice);
              pst.setString(3, pcategory );
              pst.setString(4, pcompany);
              pst.setInt(5, qnt1);
              pst.setInt(6, pid );
            
              
              int rowcount=pst.executeUpdate();
                 if(rowcount == 1){
                      JOptionPane.showMessageDialog(this, "Data Updated successfully");
                      ClearTable();
                      SetProductTable();
                     
                     
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "Data not Updated successfully");
                 }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    
    
     
     public void DeleteProduct(int pid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","123456");
             String sql=("delete from product where ID=?");
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
     
     public void SearchProduct( String n){
           model=(DefaultTableModel)productTable.getModel();
           TableRowSorter<DefaultTableModel> trs=new TableRowSorter<DefaultTableModel>(model);
           productTable.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(n));
             }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pprice = new javax.swing.JTextField();
        pcategory = new javax.swing.JComboBox<>();
        searchbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        pname1 = new javax.swing.JTextField();
        pcompany = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        qnt = new javax.swing.JTextField();
        panel2 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        dnt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update Product");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 170, 40));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Product");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Delete Product");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 160, 40));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product ID :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 40));

        pid.setBackground(new java.awt.Color(102, 102, 102));
        pid.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pid.setForeground(new java.awt.Color(255, 255, 255));
        pid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        pid.setCaretColor(new java.awt.Color(51, 51, 51));
        pid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pidActionPerformed(evt);
            }
        });
        jPanel4.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 400, 40));

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Name:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 30));

        pname.setBackground(new java.awt.Color(102, 102, 102));
        pname.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pname.setForeground(new java.awt.Color(255, 255, 255));
        pname.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Product Name To seach Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pname.setCaretColor(new java.awt.Color(51, 51, 51));
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });
        jPanel4.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 410, 70));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Quantity");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, -1, -1));

        pprice.setBackground(new java.awt.Color(102, 102, 102));
        pprice.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pprice.setForeground(new java.awt.Color(255, 255, 255));
        pprice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        pprice.setCaretColor(new java.awt.Color(51, 51, 51));
        pprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppriceActionPerformed(evt);
            }
        });
        jPanel4.add(pprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 410, 40));

        pcategory.setBackground(new java.awt.Color(51, 51, 51));
        pcategory.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pcategory.setForeground(new java.awt.Color(255, 255, 255));
        pcategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcategoryActionPerformed(evt);
            }
        });
        jPanel4.add(pcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 410, 60));

        searchbtn.setBackground(new java.awt.Color(51, 51, 51));
        searchbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchbtn.setText("Search Product");
        searchbtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });
        jPanel4.add(searchbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 180, 40));

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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 820, 550));

        pname1.setBackground(new java.awt.Color(102, 102, 102));
        pname1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pname1.setForeground(new java.awt.Color(255, 255, 255));
        pname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        pname1.setCaretColor(new java.awt.Color(51, 51, 51));
        pname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pname1ActionPerformed(evt);
            }
        });
        jPanel4.add(pname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 410, 40));

        pcompany.setBackground(new java.awt.Color(51, 51, 51));
        pcompany.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        pcompany.setForeground(new java.awt.Color(255, 255, 255));
        pcompany.setAutoscrolls(true);
        pcompany.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Company", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pcompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcompanyActionPerformed(evt);
            }
        });
        jPanel4.add(pcompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 410, 60));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product price :");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        qnt.setBackground(new java.awt.Color(102, 102, 102));
        qnt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        qnt.setForeground(new java.awt.Color(255, 255, 255));
        qnt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        qnt.setCaretColor(new java.awt.Color(51, 51, 51));
        qnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qntActionPerformed(evt);
            }
        });
        jPanel4.add(qnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 410, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 1500, 860));

        panel2.setBackground(new java.awt.Color(0, 0, 255));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AUTOMOBILE SHOP");
        panel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, -20, 830, 140));

        dnt.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        dnt.setForeground(new java.awt.Color(255, 255, 255));
        panel2.add(dnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 80, 270, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DATE & TIME :");
        panel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 40, 180, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product Information");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 180));

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

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 380, 70));

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

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 380, 70));

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

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 380, 70));

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

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 380, 70));

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

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 380, 70));

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

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 380, 70));

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

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 380, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 560, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          int id=Integer.parseInt(pid.getText());
        
        DeleteProduct( id);                    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id=Integer.parseInt(pid.getText());
        String id2=pid.getText();
        String name=pname1.getText();
        int price=Integer.parseInt(pprice.getText());
        String price1=pprice.getText();
        String category=(String) pcompany.getSelectedItem();
        String company=(String) pcategory.getSelectedItem();
            int qnt1=Integer.parseInt(qnt.getText());
            String qnt2=qnt.getText();
            if (id2.trim().equals("")||name.trim().equals("")||price1.trim().equals("")||company.trim().equals("")||category.trim().equals("")||qnt2.trim().equals("")){
                 JOptionPane.showMessageDialog(this, "please insert details");
                 
            }
            else{
        AddProduct( id,name, price, category,company, qnt1);
        autoincrement();
        clearfield();
        
            }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id=Integer.parseInt(pid.getText());
        String name=pname1.getText();
        int price=Integer.parseInt(pprice.getText());
       String category=(String) pcompany.getSelectedItem();
        String company=(String) pcategory.getSelectedItem();
        int qnt1=Integer.parseInt(qnt.getText());
        UpdateProduct( id,name, price, category,company,qnt1);          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pidActionPerformed

    private void ppriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppriceActionPerformed

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
            String sname=pname.getText(); 
            SearchProduct(sname);// TODO add your handling code here:
    }//GEN-LAST:event_searchbtnActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
               int row=productTable.getSelectedRow();
        TableModel model=productTable.getModel();
        pid.setText(model.getValueAt(row,0).toString());
        pname1.setText(model.getValueAt(row,1).toString());
       pprice.setText(model.getValueAt(row,2).toString());
       pcompany.setSelectedItem(model.getValueAt(row,3).toString());
        pcategory.setSelectedItem(model.getValueAt(row,4).toString());
         qnt.setText(model.getValueAt(row,5).toString());
       
       
    }//GEN-LAST:event_productTableMouseClicked

    private void pname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pname1ActionPerformed

    private void productTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_productTableMouseEntered

    private void pcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcategoryActionPerformed

    private void pcompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcompanyActionPerformed

    private void qntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qntActionPerformed

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

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        saledetails s1=new saledetails();
        s1.show();
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        Login r1=new Login();
        r1.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

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
            java.util.logging.Logger.getLogger(product1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dnt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel2;
    private javax.swing.JComboBox<String> pcategory;
    private javax.swing.JComboBox<String> pcompany;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pname1;
    private javax.swing.JTextField pprice;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qnt;
    private javax.swing.JButton searchbtn;
    // End of variables declaration//GEN-END:variables
}
