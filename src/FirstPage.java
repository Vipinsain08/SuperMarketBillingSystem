import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class FirstPage extends MouseAdapter implements ActionListener{
		
	JFrame jf = new JFrame("VIP Supermarket PVT.LTD");
	 
	 JTextField tf1, tf2,tf3,tf4;
	JLabel lab1, lab2,lab3,lab4; JButton btn1,btn2,btn3,btn4,btn5; JLabel h;
	ImageIcon image1; 
	 JLabel l,l2,cp,h1;
	       
	 JTable t = new JTable();
	 
	
	public FirstPage()
	 {
			
		jf.setLayout(new BorderLayout());
		
	     ImageIcon image = new ImageIcon("D:\\Supermarket Billing\\bin\\supermarket.jpg");
	      l = new JLabel(image);
	      
	      
	     // ImageIcon image1 = new ImageIcon("D:\\Supermarket Billing\\bin\\manwelcome.jpg");
	      //l2 = new JLabel(image1);
	      
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      l.setSize(screenSize.width, screenSize.height);
	     jf.setContentPane(l);
		
		Font f=new Font("Arial",Font.BOLD,16);
		 h= new JLabel("VIP Supermarket");
		 h.setFont(new Font("Algerian",Font.BOLD,70));
		 
		 cp= new JLabel("© 2022 VIP SuperMarket PVT.LTD. All rights reserved |Contact No. 9468330732,9306276086");	 
		    lab1= new JLabel("Product id :");
		    lab1.setFont(new Font("Arial",Font.BOLD,20));
		   
		     h1= new JLabel("YOUR NEEDS IN JUST ONE PLACE");
		     h1.setFont(new Font("Algerian",Font.BOLD,20));
		     h.setForeground(new Color(255,0,0));
			 h1.setForeground(new Color(0,0,255));
		    
			lab2= new JLabel("Product Name :");
			lab2.setFont(new Font("Arial",Font.BOLD,20));
			lab3= new JLabel("Quantity :");
			lab3.setFont(new Font("Arial",Font.BOLD,20));
			lab4= new JLabel("Price :");
			
			lab4.setFont(new Font("Arial",Font.BOLD,20));
			tf1= new JTextField(20);
			tf1.setFont(f);
			tf2 = new JTextField(20);
			tf2.setFont(f);
			tf3 = new JTextField(20);
			tf3.setFont(f);
			tf4 = new JTextField(20);
			tf4.setFont(f);
			btn1= new JButton("Add+");
			btn1.setFont(f);
			btn2= new JButton("Show");
			btn2.setFont(f);
			btn3= new JButton("Search");
			btn3.setFont(f);
			btn4= new JButton(" Save&Next -> ");
			btn4.setFont(f);
			btn5=new JButton("New");
			btn5.setFont(f);
			
			/*
			 cp.setForeground(new Color(255,0,0));
			    lab1.setForeground(new Color(255,0,0));
			    lab2.setForeground(new Color(255,0,0));
			    lab3.setForeground(new Color(255,0,0));
			    lab4.setForeground(new Color(255,0,0));
			    */
			
			
			
			jf.setVisible(true);
			jf.setLayout(null);
			 screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    jf.setSize(screenSize.width, screenSize.height);
		   
		    //l2.setBounds(100,50,500,600);
		   
		    h.setBounds(650, 0, 700, 100);
		    h1.setBounds(850, 50, 700, 100);
		    lab1.setBounds(550, 150, 150, 40);
	        lab2.setBounds(550, 250, 150, 40);
	        
	        lab3.setBounds(1100,150,150,40);
	        lab4.setBounds(1100,250,150,40);
	        
	        tf1.setBounds(700, 150, 150, 40);
	        tf2.setBounds(700, 250, 150, 40);
	        tf3.setBounds(1200, 150, 150, 40);
	        tf4.setBounds(1200, 250, 150, 40);
	       
	        btn1.setBounds(550, 350, 100, 40);
	        btn2.setBounds(750, 350, 100, 40);
	        btn3.setBounds(950, 350, 100, 40);
	        btn4.setBounds(1150, 350, 150, 40);
	        btn5.setBounds(1350,350,150,40);
	        cp.setBounds(500,800,900,300);
	        cp.setFont(new Font("Arial",Font.BOLD,20));
	        
	        tf1.addMouseListener(this);
	        tf2.addMouseListener(this);
	        tf3.addMouseListener(this);
	        tf4.addMouseListener(this);
		    btn1.addActionListener(this);
		    btn2.addActionListener(this);
		    btn3.addActionListener(this);
		    btn4.addActionListener(this);
		    btn5.addActionListener(this);
		    jf.add(lab1);
		    jf.add(tf1);
		    jf.add(lab2);
		    jf.add(tf2);
		    jf.add(lab3);
		    jf.add(tf3);
		    jf.add(lab4);
		    jf.add(tf4);
		    jf.add(btn1);
		    jf.add(btn1);
		    jf.add(btn2);
		    jf.add(btn3);
		    jf.add(btn4);
		    jf.add(btn5);
		    jf.add(h);
		    jf.add(t);
		    jf.add(cp);
		    jf.add(h1);
		  //  jf.add(l2);
		   
	 }

	public void actionPerformed(ActionEvent e){ 	
		
		if(e.getSource().equals(btn1))	{  
			
			if(tf1.getText().equals("") && tf2.getText().equals("")&& tf3.getText().equals("") && tf4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(jf,"please enter the field","warning",JOptionPane.WARNING_MESSAGE);
			   
				
				if(tf1.getText().equals(""))
				{
				tf1.setBackground(Color.RED);
				}
				if(tf2.getText().equals(""))
				{
				tf2.setBackground(Color.RED);
				}
				if(tf3.getText().equals(""))
				{
				tf3.setBackground(Color.RED);
				}
				if(tf4.getText().equals(""))
				{
				tf4.setBackground(Color.RED);
				}
				
			}		 
			else{
			try {
			    // connection string
				Class.forName("com.mysql.cj.jdbc.Driver"); 
			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root@123");
			        Statement st =  con.createStatement();

			        String sql = "insert into user VALUES('"
			                + tf1.getText() + "','" + tf2.getText() + "','"
			                + tf3.getText() + "','" + tf4.getText()+"')";
			        st.executeUpdate(sql);
			        JOptionPane.showConfirmDialog(null, "Item Added!",
			                "Result", JOptionPane.DEFAULT_OPTION,
			                JOptionPane.PLAIN_MESSAGE);	       
	
	
			         st.close();
			        con.close(); 
			        
			}catch(Exception er){
				er.printStackTrace();
			} 
			finally{
		    	
			    tf1.setText(null);
			    tf2.setText(null);
			    tf3.setText(null);
			    tf4.setText(null);
			    }
			}
		}
		
		if(e.getSource().equals(btn2))
		{
			/*
		}
			try{ 
				t.setVisible(true);
				t.setBounds(650, 550, 100, 30);
			t.setSize(600, 400);
			
			//t.setLayout(new FlowLayout());
				
				Class.forName("com.mysql.cj.jdbc.Driver"); 
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root@123");
		        Statement st= con.createStatement();
		        String query  = "select * from user";
		        ResultSet rs= st.executeQuery(query);
		        ResultSetMetaData rsmd= rs.getMetaData();
		        DefaultTableModel model= (DefaultTableModel)t.getModel();
		        
		        int cols = rsmd.getColumnCount();
		        String[] colName = new String [cols];
		        for (int i=0;i<cols;i++)
		        {
		        	colName[i]=rsmd.getColumnName(i+1);
		        	model.setColumnIdentifiers(colName);
		        }
		     
		        String ProductName, Productid,Quantity,Price;
		        while(rs.next())
		        {
		        	Productid=rs.getString(1);
		        	ProductName= rs.getString(2);
		        	Quantity=rs.getString(3);
		        	Price = rs.getString(4);
		        	String [] row = {Productid, ProductName, Quantity, Price};
		        	model.addRow(row);
		        }
		        
		      t.setRowHeight(30);t.setFont(new Font("Arial",Font.ITALIC,18));
		     
		    
		        st.close();
		        con.close();
		    }
		    catch(Exception ec){

		        JOptionPane.showMessageDialog(null,"Error in user Grid View..... "+ec);
		    }
		    	*/
			
			new Table();
		}
		
		if(e.getSource().equals(btn3))
		{
			new SearchResult();
		}
		
		
	if(e.getSource().equals(btn4))
	{
	 new UserName();		
		
	}
	
	if(e.getSource().equals(btn5))
	{
		try {
		    // connection string
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root@123");
		        Statement st =  con.createStatement();

		        String sql = "TRUNCATE TABLE user";
		        st.executeUpdate(sql);
		         st.close();
		        con.close(); 
		        
		}catch(Exception er){
			er.printStackTrace();
		} 

	}
	}	
	public  void mouseClicked(MouseEvent e)
	{
            JTextField t =	(JTextField)	e.getSource();
            t.setBackground(Color.white);
	}
	public static void main(String args[])
	{
		 new FirstPage();
	}
	
	
}

