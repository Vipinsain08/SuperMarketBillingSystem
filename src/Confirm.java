import java.awt.Font;
import java.sql.*;
import java.awt.*;

import javax.swing.*;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class Confirm  {
	
	JFrame j= new JFrame();
public Confirm()
 {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	   LocalDateTime now = LocalDateTime.now();  
	JLabel lab, lab1,lab2;
 JTextArea ja =  new JTextArea(); JLabel jlab; JLabel stotal = null;  JLabel s=  new JLabel("Total : ");
 
 JTextArea ja1 = new JTextArea(2,10); JLabel dis = new JLabel("discount :     5%");
 JLabel na=null;
 JLabel nwamount = new JLabel("new Amount : ");
 ja.setText("VIP SuperMarket"
 		+ "\nSuperMarket plc BD3 7DL"+"\nManager : VIPIN"+"\nTelephone:01483 755552"+"\nVat Number : 343475355"+"\n\nDate: "+dtf.format(now)+" Time: "+dtf2.format(now)+"\nyou were served by : Ankit");
	
 ja1.setText("Thank you for shopping at VIP SuperMarket PVT.LTD "+"\n                         Please come again");
 
 double sum=0;
 ImageIcon image = new ImageIcon("D:\\Supermarket Billing\\bin\\cart.png");
   JLabel l = new JLabel(image);
   
   Font f= new Font("Arial",Font.PLAIN,18);
	
	JLabel obj1,obj2,obj3,obj4;
	
	JLabel obj5 ;
	JLabel obj6;
	JLabel obj7 ;
	JLabel obj8 ;


	j.setLayout(null);
	j.setBounds(200, 0, 500, 1020);
	j.setResizable(false);
	JLabel h= new JLabel("VIP Supermarket");
	JLabel h1= new JLabel("YOUR NEEDS IN JUST ONE PLACE");
	 h.setFont(new Font("Arial",Font.ITALIC,50));
	 h1.setFont(new Font("Arial",Font.BOLD,14));
	 lab=  new JLabel("----------------------------------------------------------------------------------------------------------------------");
	 jlab= new JLabel("----------------------------------------------------------------------------------------------------------------------"); 
	 lab2= new JLabel("Description : ");
	 JLabel lab3= new JLabel("----------------------------------------------------------------------------------------------------------------------");
	 JTextArea p = new JTextArea();
	
	 
	 try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root@123");

            PreparedStatement ps = con.prepareStatement("select * from user");

            ResultSet rs = ps.executeQuery();

            int y=300; double z=0;
           int x=0;
        Color c =j.getBackground();
       	ja.setBackground(c);
       	ja1.setBackground(c);
     	ja.setFont(new Font("Arial",Font.PLAIN,14));
       	ja1.setFont(new Font("monospaced sans serif",Font.PLAIN,14));
           
       	
        h.setForeground(Color.RED);
    	h1.setForeground(Color.BLUE);
    	h1.setBounds(120,70,250,30);
 	h.setBounds(20,0,500,80);
   
 	lab2.setBounds(20,220,150,100);
    	
    	lab.setBounds(0,160,800,200);
    lab.setFont(f);
    jlab.setBounds(0,200,800,200);
    jlab.setFont(f);
    ja.setEditable(false);
    ja1.setEditable(false);	
       	
       	
       	
       	if(rs.next()==false)
       	{
       		j.setVisible(false);
       		JOptionPane.showMessageDialog(j,"Nothing to display ","warning",JOptionPane.WARNING_MESSAGE);
       	}else{
       		j.setVisible(true);
       		
       	 String productid  = rs.getString(1);
         String productName =rs.getString(2);
         String quantity  =rs.getString(3);
         String price = rs.getString(4);
         
         sum = Double.parseDouble(price);
         obj5= new JLabel(productid);
         obj6= new JLabel(productName);
         obj7= new JLabel(quantity);
         obj8= new JLabel(price);
       	lab3.setBounds(0,280,800,100);
         obj5.setBounds(50,y,100,50);
         obj6.setBounds(180,y,100,50);
         obj7.setBounds(280,y,100,50);
         obj8.setBounds(380,y,100,50);
         j.add(lab3);
         j.add(obj5); 
         j.add(obj6);
         j.add(obj7);
         j.add(obj8);
         while(rs.next()) {
       			
                 
        	 y=y+16;
                 productid = rs.getString(1);
                 productName = rs.getString(2);
                 quantity = rs.getString(3);
                 price = rs.getString(4);
                sum = sum+Double.parseDouble(price);
              
                obj1= new JLabel(productid);
                obj2= new JLabel(productName);
                obj3= new JLabel(quantity);
                obj4= new JLabel(price);
                stotal=new JLabel(String.valueOf(sum));
          z= (sum *5)/100;
          double save=sum-z;
lab1= new JLabel("----------------------------------------------------------------------------------------------------------------------");
na= new JLabel(String.valueOf(save));
        
        j.add(obj1);
       	j.add(obj2);
       	j.add(obj3);
       	j.add(obj4);
       	j.add(l);
       	j.add(h);
    	j.add(h1);
    	j.add(lab);
       j.add(lab1);
       j.add(ja);
       j.add(ja1);
       j.add(lab2);
       j.add(jlab);
      
       j.add(s);
       j.add(stotal);
       j.add(dis);
       j.add(nwamount);
       j.add(na);
       j.add(p);
       x=y;
       	l.setBounds(400,0,80,80);
       	obj1.setBounds(50,y,100,50);
    	obj2.setBounds(180,y,100,50);
    	obj3.setBounds(280,y,100,50);
    	obj4.setBounds(380,y,100,50);
    	lab1.setBounds(0,x-17,1200,100);
    	ja.setBounds(120,100,1250,150);
    	ja1.setBounds(50,920,400,150);
    	
    	
            }
         
         p.setText("    You Save "+"\n    "+z+" Rs\n at VIP SuperMarket");
         p.setEditable(false);
       s.setBounds(320,y=y+30,100,30);
      stotal.setBounds(380,y,100,30);
      dis.setBounds(320,y=y+20,100,30);
      nwamount.setBounds(300,y=y+20,100,30);
      na.setBounds(380,y,100,30);
      p.setBounds(150,y+50,250,100);
      p.setBackground(c);
      p.setFont(f);
            
       	}
           
           	

        } catch (Exception ex) {

            System.out.println(ex);

        }
	 }

}