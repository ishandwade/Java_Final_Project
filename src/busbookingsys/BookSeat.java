/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package busbookingsys;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.print.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Anirudh
 */
public class BookSeat extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLogin
     */
    public BookSeat(){
        
        initComponents();
      Connect();
    }
   
      
     PreparedStatement psd;
       PreparedStatement psd1;
       java.sql.Connection con;
       ResultSet rs;
       private void Connect()  {
        try {
            // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
             
               con =  DriverManager.getConnection("jdbc:mysql://localhost/super","root","");
               
            } catch (SQLException ex) {
                Logger.getLogger(BookSeat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookSeat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void Loader()
        {
        SimpleDateFormat DF = new SimpleDateFormat("YYYY-MM-dd");
        String data = DF.format(date.getDate());
        try {

            psd = con.prepareStatement("SELECT seat.BusNO,seat.seats,seat.status,seat.Date,seat.source,seat.destination,busbook.customer,busbook.mobile,busbook.aadhar,busbook.source,"
                    + "busbook.destination from seat LEFT JOIN  busbook ON  seat.BusNo = "
                    + "busbook.busno AND seat.seats = busbook.seat AND  seat.source=busbook.source AND  seat.destination = busbook.destination AND seat.Date = busbook.date where seat.Date = ?");
            psd.setString(1,data);
          rs =psd.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c =rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel)jojo.getModel();
            d.setRowCount(0);
            while(rs.next())
            {
                Vector v2 = new Vector();
                     
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("busno"));
                    v2.add(rs.getString("customer"));
                    v2.add(rs.getString("aadhar"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("source"));
                    v2.add(rs.getString("destination"));
                    v2.add(rs.getString("Date"));
                   
                      v2.add(rs.getString("status"));
                      v2.add(rs.getString("seats"));
                    
                }
                d.addRow(v2);
            }
                
            }
            
        catch (SQLException ex) {
            Logger.getLogger(BookSeat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"no buses available");
        }
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BookSeat = new javax.swing.JButton();
        date1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        monile = new javax.swing.JTextField();
        source = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        seatxt1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        aadhar = new javax.swing.JTextField();
        dest = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cat = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jojo = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        shower = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        panel_print = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1460, 680));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Name:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 50, 112, 40);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contact Number:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 109, 112, 40);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Seat No");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 170, 112, 38);

        BookSeat.setBackground(new java.awt.Color(153, 255, 153));
        BookSeat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BookSeat.setText("Book Seat");
        BookSeat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BookSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookSeatActionPerformed(evt);
            }
        });
        jPanel1.add(BookSeat);
        BookSeat.setBounds(14, 547, 182, 57);

        date1.setBackground(new java.awt.Color(255, 255, 204));
        date1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        date1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date1ActionPerformed(evt);
            }
        });
        jPanel1.add(date1);
        date1.setBounds(200, 480, 187, 38);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book Seat:");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 39);

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(228, 547, 182, 57);

        name.setBackground(new java.awt.Color(255, 255, 204));
        name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(name);
        name.setBounds(200, 50, 187, 40);

        monile.setBackground(new java.awt.Color(255, 255, 204));
        monile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        monile.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monileActionPerformed(evt);
            }
        });
        jPanel1.add(monile);
        monile.setBounds(200, 110, 187, 38);

        source.setBackground(new java.awt.Color(255, 255, 204));
        source.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        source.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        source.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceActionPerformed(evt);
            }
        });
        jPanel1.add(source);
        source.setBounds(200, 290, 187, 38);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Aadhar");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 230, 112, 38);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Date:");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 480, 112, 40);

        seatxt1.setBackground(new java.awt.Color(255, 255, 204));
        seatxt1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seatxt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        seatxt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seatxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatxt1ActionPerformed(evt);
            }
        });
        jPanel1.add(seatxt1);
        seatxt1.setBounds(200, 170, 187, 38);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Destination");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 350, 112, 38);

        aadhar.setBackground(new java.awt.Color(255, 255, 204));
        aadhar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        aadhar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aadhar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        aadhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aadharActionPerformed(evt);
            }
        });
        jPanel1.add(aadhar);
        aadhar.setBounds(200, 230, 187, 38);

        dest.setBackground(new java.awt.Color(255, 255, 204));
        dest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destActionPerformed(evt);
            }
        });
        jPanel1.add(dest);
        dest.setBounds(200, 350, 187, 38);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Source");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 290, 112, 38);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Category");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 410, 112, 39);

        cat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senior", "Child", "Student", "Adult" }));
        cat.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(cat);
        cat.setBounds(200, 410, 187, 39);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\anihk\\Downloads\\java_project\\bus9.jpg")); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 450, 630);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(12, 27, 449, 620);

        jojo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jojo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jojo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bus Number", "Customer", "mobile", "Aaadhar", "Source", "Destination", "Date", "Status", "Seat"
            }
        ));
        jojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jojoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jojo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(501, 64, 550, 451);

        date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(date);
        date.setBounds(572, 27, 277, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Date:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(501, 27, 145, 30);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(671, 234, 156, 151);

        shower.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        shower.setText("Show");
        shower.setToolTipText("");
        shower.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        shower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showerActionPerformed(evt);
            }
        });
        getContentPane().add(shower);
        shower.setBounds(900, 27, 69, 30);

        bill.setColumns(20);
        bill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bill.setRows(5);
        bill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(bill);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1063, 64, 371, 451);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(30, 40, 100, 100);

        panel_print.setBackground(new java.awt.Color(153, 255, 153));
        panel_print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panel_print.setText("PRINT");
        panel_print.setBorder(new javax.swing.border.MatteBorder(null));
        panel_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panel_printActionPerformed(evt);
            }
        });
        getContentPane().add(panel_print);
        panel_print.setBounds(1270, 570, 110, 40);

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Refund");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(920, 550, 130, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\anihk\\Downloads\\java_project\\bus8.jpg")); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(3, 0, 1450, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void bill()
    {
       
          String cusname = name.getText();
String mobile = monile.getText();
String aadhar1 = aadhar.getText();
String seat = seatxt1.getText();
String source1 = source.getText();
String dest1 = dest.getText();
String date = date1.getText();
String cat1 = cat.getSelectedItem().toString();
           bill.setText(bill.getText()+ "********************************************************\n");
  
       bill.setText(bill.getText()+ "                                  Bus Details                  \n");
           bill.setText(bill.getText()+ "********************************************************\n");
       bill.setText(bill.getText()+ "   Customer:"+"\t\t"+cusname+"\n");
       bill.setText(bill.getText()+ "   Mobile:"+"\t\t"+mobile+"\n");
       bill.setText(bill.getText()+ "   Source:"+"\t\t"+source1+"\n");
       bill.setText(bill.getText()+ "   Destination:"+"\t\t"+dest1+"\n");
       bill.setText(bill.getText()+ "   Date:"+"\t\t"+date+"\n");
       bill.setText(bill.getText()+ "   Category:"+"\t\t"+cat1+"\n");
//Senior
//Child(below 12)
//Student
       if(cat1.equals("Senior"))
       {
              bill.setText(bill.getText()+ "   Price:"+"\t\t"+"800"+"\n");
       }
       else if(cat1.equals("Child"))
       {
              bill.setText(bill.getText()+ "   Price:"+"\t\t"+"Free"+"\n");
       }
       else if(cat1.equals("Student"))
       {
              bill.setText(bill.getText()+ "   Price:"+"\t\t"+"60"+"\n");
       }
       else if(cat1.equals("Adult"))
       {
              bill.setText(bill.getText()+ "   Price:"+"\t\t"+"80"+"\n");
       }
      bill.setText(bill.getText()+ "********************************************************\n");
       
        bill.setText(bill.getText()+ "                                   Thank You                           \n"); 
      bill.setText(bill.getText()+ "********************************************************\n");
    }
   
    private void BookSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookSeatActionPerformed

        
          DefaultTableModel d1 = (DefaultTableModel)jojo.getModel();
        int selected=jojo.getSelectedRow();
        String busno = d1.getValueAt(selected,0).toString();
        
String cusname = name.getText();
String aadhar1 = aadhar.getText();
String mobile = monile.getText();
String seat = seatxt1.getText();
String source1 = source.getText();
String dest1 = dest.getText();
String date = date1.getText();
   
     String insertb ="insert into busbook(busno,customer,mobile,aadhar,source,destination,seat,date)values(?,?,?,?,?,?,?,?)";
        try {
            psd =con.prepareStatement(insertb);
       
      
        
            psd.setString(1,busno);
             psd.setString(2,cusname);
       psd.setString(3, mobile);
       psd.setString(4,aadhar1);
        
          psd.setString(5,source1);
    psd.setString(6,dest1);
           psd.setString(7,seat);
           psd.setString(8,date);
           psd.executeUpdate();
             psd1 =con.prepareStatement("update seat set status = ? where seats = ? ");
             psd1.setString(1,"Booked");
             psd1.setString(2,seat);
             psd1.executeUpdate();
           
             JOptionPane.showMessageDialog(this,"Seat Booked");
             bill();
             Loader();
             name.setText("");
             monile.setText("");
              source.setText("");
                seatxt1.setText("");
                 date1.setText("");
                    aadhar.setText("");
                    dest.setText("");
             
        } catch (SQLException ex) {
            Logger.getLogger(BookSeat.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(this," Book seat error 404 ");
             
        }
      
 
    



       
    // DO add your handling code here:
      
 
    



       
    // DO add your handling code here:
       
    }//GEN-LAST:event_BookSeatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date1ActionPerformed

    private void monileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monileActionPerformed

    private void sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceActionPerformed

    private void jojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jojoMouseClicked
        // TODO add your handling code here:
       DefaultTableModel d1 = (DefaultTableModel)jojo.getModel();
        int selected=jojo.getSelectedRow();
        String status = d1.getValueAt(selected,7).toString();
        
        if(!status.equals("Booked"))
        {
             String source1 = d1.getValueAt(selected, 4).toString();
              String dest1 = d1.getValueAt(selected, 5).toString();
           String seat = d1.getValueAt(selected, 8).toString();
            String date =d1.getValueAt(selected, 6).toString();
           seatxt1.setText(seat);
           date1.setText(date);
           source.setText(source1);
           dest.setText(dest1);
       }
        else
        {
            JOptionPane.showMessageDialog(this,"Ticket booked");
            String source1 = d1.getValueAt(selected, 4).toString();
              String dest1 = d1.getValueAt(selected, 5).toString();
           String seat = d1.getValueAt(selected, 8).toString();
            String date =d1.getValueAt(selected, 6).toString();
            String aadhar1 =d1.getValueAt(selected,3 ).toString();
                    String mobile =d1.getValueAt(selected,2 ).toString();
                            String Name= d1.getValueAt(selected,1 ).toString();
             seatxt1.setText(seat);
             date1.setText(date);
             source.setText(source1);
             dest.setText(dest1);
             name.setText(Name);
             monile.setText(mobile);
             aadhar.setText(aadhar1);
        }
    }//GEN-LAST:event_jojoMouseClicked

    private void seatxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatxt1ActionPerformed

    private void aadharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aadharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aadharActionPerformed

    private void destActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destActionPerformed

    private void showerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showerActionPerformed
        // TODO add your handling code here:
        Loader();
    }//GEN-LAST:event_showerActionPerformed

    private void panel_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panel_printActionPerformed
        // TODO add your handling code here:
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
                g2.scale(1.8,2.6);
                
                bill.print(g2);
         
               
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
                          
        
    }//GEN-LAST:event_panel_printActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jojo.getModel();
        int selected=jojo.getSelectedRow();
        String busno = d1.getValueAt(selected,0).toString();

        String cusname = name.getText();
        String mobile = monile.getText();
        String aadhar1 = aadhar.getText();
        String seat = seatxt1.getText();
        String source1 = source.getText();
        String dest1 = dest.getText();
        String date = date1.getText();

        String insertb ="delete from busbook where seat=? ";
        try {
            psd =con.prepareStatement(insertb);

            psd.setString(1,seat);

            psd.executeUpdate();
            psd1 =con.prepareStatement("update seat set status = ? where seats = ? ");
            psd1.setString(1,"unbooked");
            psd1.setString(2,seat);
            psd1.executeUpdate();

            JOptionPane.showMessageDialog(this,"Refunded");
            bill();
            Loader();
            name.setText("");
            monile.setText("");
            source.setText("");
            seatxt1.setText("");
            date1.setText("");
            aadhar.setText("");
            dest.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(BookSeat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this," Book seat error 404 ");

        }
                     

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(BookSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookSeat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookSeat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookSeat;
    private javax.swing.JTextField aadhar;
    private javax.swing.JTextArea bill;
    private javax.swing.JComboBox<String> cat;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField date1;
    private javax.swing.JTextField dest;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jojo;
    private javax.swing.JTextField monile;
    private javax.swing.JTextField name;
    private javax.swing.JButton panel_print;
    private javax.swing.JTextField seatxt1;
    private javax.swing.JButton shower;
    private javax.swing.JTextField source;
    // End of variables declaration//GEN-END:variables

  
}
