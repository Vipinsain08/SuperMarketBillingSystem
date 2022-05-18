import java.awt.*;

import javax.swing.*;

import java.awt.event.*;



public class LoginPage implements ActionListener{
	
JFrame jf = new JFrame("VIP SuperMarket");

 JLabel lab1;
 JTextField tf1; TextField tf2;
JLabel lab2; JButton btn; JLabel h;
ImageIcon image1;
 JLabel l,l2,tag,h1;

public LoginPage()
 {
     jf.setLayout(new BorderLayout());
     ImageIcon image = new ImageIcon("D:\\Supermarket Billing\\bin\\supermarket.jpg");
      l = new JLabel(image);
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      l.setSize(screenSize.width, screenSize.height);
     jf.setContentPane(l);
	
     
	ImageIcon im= new ImageIcon("D:\\Supermarket Billing\\bin\\grocery-cart.png");
	l2=new JLabel(im);
	
	 h= new JLabel("VIP Supermarket");
	 h.setFont(new Font("Algerian",Font.BOLD,70));
	  h1= new JLabel("YOUR NEEDS IN JUST ONE PLACE");
	     h1.setFont(new Font("Algerian",Font.BOLD,20));
	     h.setForeground(new Color(255,0,0));
		 h1.setForeground(new Color(0,0,255));
		 
	    lab1= new JLabel("Admin Name");
	   lab1. setFont(new Font("Playfair Display",Font.BOLD,23));
		lab2= new JLabel("Password");
		lab2. setFont(new Font("Playfair Display",Font.BOLD,23));
		tf1= new JTextField(40);
		tf2 = new TextField(20);
		btn= new JButton("Login");
		tag= new JLabel("© 2022 VIP SuperMarket PVT.LTD. All rights reserved |Contact No. 9468330732,9306276086");
		
		btn.setFont(new Font("Playfair Display",Font.BOLD,18));
		jf.setVisible(true);
		jf.setLayout(null);
		
		tf1.setFont(new Font("Arial",Font.BOLD,18));
		tf2.setFont(new Font("Arial",Font.BOLD,18));
		
		tag.setFont(new Font("Arial",Font.BOLD,20));
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    jf.setSize(screenSize.width, screenSize.height);
	   
	    btn.addActionListener(this);
	    tf2.setEchoChar('*');
	    h.setBounds(600, 0, 700, 100);
	    h1.setBounds(850, 50, 700, 100);
	    lab1.setBounds(650, 350, 150, 40);
        lab2.setBounds(650, 420, 200, 30);
        tf1.setBounds(950, 350, 150, 30);
        tf2.setBounds(950, 420, 150, 30);
        btn.setBounds(850, 500, 100, 30);
        l2.setBounds(450, 50, 800, 550);
	    tag.setBounds(500,800,900,300);
	   
	    jf.add(lab1);
	    jf.add(tf1);
	    jf.add(lab2);
	    jf.add(tf2);
	    jf.add(btn);
	    jf.add(h);
	    jf.add(l2);
	    jf.add(tag);
	    jf.add(h1);
	    
	    
 }

	public static void main(String args[])
	{
		
		new LoginPage();
	}
	public void actionPerformed(ActionEvent e)
	{		       
		if(tf1.getText()== null && tf2.getText()== null)
		{
			JOptionPane.showMessageDialog(jf,"Wrong id and Password","Warning!",JOptionPane.WARNING_MESSAGE);
		}
	else if(tf1.getText().equals("Vipin") && tf2.getText().equals("1395"))
		{
			jf.setVisible(false);
			new FirstPage();
		}
		else{
			JOptionPane.showMessageDialog(jf,"Wrong id and Password","Warning!",JOptionPane.WARNING_MESSAGE);
		}
	}
}
