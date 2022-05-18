import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult implements ActionListener{
JFrame frame, frame1;
JTextField textbox;
JLabel label,l;
JButton button;
JPanel panel;
static JTable table;

String driverName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/studentdatabase";
String userName = "root";
String password = "root@123";
String[] columnNames = {"Product id", "Product Name", "Quantity", "Price"};
public SearchResult(){
	/*
	ImageIcon image = new ImageIcon("D:\\Supermarket Billing\\bin\\supermarket.jpg");
    l = new JLabel(image);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    l.setSize(screenSize.width, screenSize.height);
   frame.setContentPane(l);
	frame.add(l);
	*/
	
	
frame = new JFrame("VIP SuperMarket Pvt Ltd");
frame.setLayout(null);
textbox = new JTextField();
textbox.setBounds(220,30,150,25); 
textbox.setFont(new Font("Arial",Font.PLAIN,14));
label = new JLabel("Enter your Product ID ");
label.setFont(new Font("Arial",Font.PLAIN,18));
label.setBounds(10, 30, 250, 30);
button = new JButton("Search");
button.setBounds(120,130,150,30);
button.addActionListener(this);
button.setFont(new Font("Arial",Font.PLAIN,18));

frame.add(textbox);
frame.add(label);
frame.add(button);
frame.setVisible(true);
frame.setBounds(450,500,500,300); 
} 

public void actionPerformed(ActionEvent ae)
{
button = (JButton)ae.getSource();
System.out.println("Showing Table Data.......");


frame1 = new JFrame("VIP SuperMarket Pvt Ltd");
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String textvalue = textbox.getText();
String roll= "";
String name= "";
String cl = "";
String sec = "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select * from user where Productid= "+textvalue;
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
if(rs.next())
{
roll = rs.getString("Productid");
name = rs.getString("Product Name");
cl = rs.getString("Quantity");
sec = rs.getString("Price"); 
model.addRow(new Object[]{roll, name, cl, sec});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(frame, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(frame, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setBounds(1000,500,600,500);
} 
public static void main(String args[])
{
	new SearchResult();
}
}