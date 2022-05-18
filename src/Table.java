import javax.swing.*;

import java.awt.*;

import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class Table   {
	JFrame jf= new JFrame("VIP SuperMarket");
	
    
    public Table() {
    	
    	DefaultTableModel model = new DefaultTableModel();
        Container cnt = jf.getContentPane();
        JTable jtbl = new JTable(model);
        cnt.setLayout(new FlowLayout(FlowLayout.CENTER,1200,10));
    
        
        
        model.addColumn("Product Id");
        model.addColumn("Product Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentdatabase", "root", "root@123");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM user");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        JScrollPane pane = new JScrollPane(jtbl);
        jf.add(pane, BorderLayout.CENTER);
        
        jtbl.setBackground(Color.WHITE);
       jf.setBackground(Color.WHITE);
              jf.setBounds(600,450,500,500);
        jf.setVisible(true);
        jtbl.setRowHeight(30);jtbl.setFont(new Font("Arial",Font.ITALIC,18));
       
        
        
    }
    public static void main(String args [])
    {
    	new Table();
    }


}