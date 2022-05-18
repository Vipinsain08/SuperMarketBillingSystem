import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;

public class ClientForm  extends MouseAdapter implements ActionListener {
    
	JFrame fr = new JFrame("VIP SuperMarket PVT.LTD");
	JButton submit;     
   
    JTextField tname;
    JTextField tmail;
    JTextField tfeedback;
    JCheckBox check;
    JComboBox<String> agegrp;
   
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    ButtonGroup rating;
    String[] ages= {"Below 18","18-44","45-60","Above 60"};
        
    JLabel l2,l,l3,l4,l5,l6,l7,h1;
    public ClientForm(){
       
    	ImageIcon image = new ImageIcon("D:\\Supermarket Billing\\bin\\supermarket.jpg");
	      l = new JLabel(image);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      l.setSize(screenSize.width, screenSize.height);
	     fr.setContentPane(l);
    	
    	
    	ImageIcon ima= new ImageIcon("D:\\Supermarket Billing\\bin\\love.png");
    	l2=new JLabel(ima);
    	
    	  fr.add(l2);
    	  
     ImageIcon ima5= new ImageIcon("D:\\Supermarket Billing\\bin\\feedback.png");
      	  l7=new JLabel(ima5);
      	l7.setBounds(150,100,350,350);
      	  fr.add(l7);
    	  
    	  ImageIcon ima1= new ImageIcon("D:\\Supermarket Billing\\bin\\smile.png");
      	l3=new JLabel(ima1);
      	  fr.add(l3);
      	  
      	ImageIcon ima2= new ImageIcon("D:\\Supermarket Billing\\bin\\confused.png");
      	l4=new JLabel(ima2);
      	
      	  fr.add(l4);
      	  
      	ImageIcon ima3= new ImageIcon("D:\\Supermarket Billing\\bin\\sad.png");
      	l5=new JLabel(ima3);
      	  fr.add(l5);
    	  
      	ImageIcon ima4= new ImageIcon("D:\\Supermarket Billing\\bin\\angry.png");
      	l6=new JLabel(ima4);
      	  fr.add(l6);
      	  
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
         screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      fr.setSize(screenSize.width, screenSize.height);
       
	      fr.setLayout(null);
       // fr.setBackground(new java.awt.Color(0xA6E3E9));

        ImageIcon icon= new ImageIcon("icon.png");
       fr.setIconImage(icon.getImage());

        JLabel heading= new JLabel();
        heading.setText(" VIP SuperMarket FEEDBACK");
        heading.setFont(new Font("Algerian", Font.BOLD, 70));
        heading.setBounds(450, 0, 1200, 100);
        heading.setForeground(Color.RED);
        fr.add(heading);
       
        h1= new JLabel("YOUR NEEDS IN JUST ONE PLACE");
	     h1.setFont(new Font("Algerian",Font.BOLD,20));
	     h1.setForeground(new Color(0,0,255));

        JLabel lname= new JLabel();
        lname.setText("Name: ");
        lname.setFont(new Font("Calibri", Font.BOLD, 22));
        lname.setBounds(600,150,150,40);
        fr.add(lname);

        tname = new JTextField();
        tname.setFont(new Font("Calibri", Font.BOLD, 18));
        tname.setBounds(800, 150, 150, 30);
       fr.add(tname);

        JLabel lmail= new JLabel();
        lmail.setText("Email Address: ");
        lmail.setFont(new Font("Calibri", Font.BOLD, 22));
        lmail.setBounds(600,200, 150, 40);
        fr.add(lmail);

        tmail = new JTextField();
        tmail.setFont(new Font("Calibri", Font.PLAIN, 18));
        tmail.setBounds(800, 200, 150, 30);
        fr.add(tmail);

        check = new JCheckBox("Receive promotional emails");
        check.setFont(new Font("Calibri", Font.PLAIN, 15));
        check.setBounds(800, 240, 200, 40);
        check.setSelected(true);
        fr.add(check);

        JLabel lage= new JLabel();
        lage.setText("Age Group: ");
        lage.setFont(new Font("Calibri", Font.BOLD, 22));
        lage.setBounds(600,300,150,30);
        fr.add(lage);

        agegrp= new JComboBox<>(ages);
        agegrp.setBounds(800,300,150,30);
        fr.add(agegrp);
        

        JLabel lrating= new JLabel();
        lrating.setText("Rating: ");
        lrating.setFont(new Font("Calibri", Font.BOLD, 22));
        lrating.setBounds(600,460,150,40);
        fr.add(lrating);

        
        one=new JRadioButton("1");
        two=new JRadioButton("2");
        three=new JRadioButton("3");
        four=new JRadioButton("4");
        five=new JRadioButton("5");
        
        
        l3.setBounds(1050, 350, 150, 150);
        l5.setBounds(850, 350, 150, 150);
        l6.setBounds(750, 350, 150, 150);
        l2.setBounds(1150, 350, 150, 150);
        l4.setBounds(950, 350, 150, 150);
        h1.setBounds(650, 50, 700, 100);
        
        one.setBounds(800, 500, 50, 30);
        two.setBounds(900, 500, 50, 30);
        three.setBounds(1000, 500, 50, 30);
        four.setBounds(1100, 500, 50, 30);
        five.setBounds(1200, 500, 50, 30);
        five.setSelected(true);

        tname.addMouseListener(this);
        tmail.addMouseListener(this);
        fr.add(one);
        fr.add(two);
        fr.add(three);
        fr.add(four);
        fr.add(five);
         fr.add(h1);
        rating= new ButtonGroup();  //A buttongroup ensures only one of the 5 radio buttons are selected at a time
        rating.add(one);
        rating.add(two);
        rating.add(three);
        rating.add(four);
        rating.add(five);
        

        JLabel lfeedback= new JLabel();
        lfeedback.setText("Feedback: ");
        lfeedback.setFont(new Font("Calibri", Font.BOLD, 22));
        lfeedback.setBounds(600,600,250,40);
        fr.add(lfeedback);

        tfeedback = new JTextField();
        tfeedback.setFont(new Font("Calibri", Font.BOLD, 18));
        tfeedback.setBounds(850, 600, 250, 60);
        fr.add(tfeedback);

        submit= new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.BOLD, 20));
        submit.setBounds(700, 700, 150, 30);
        submit.addActionListener(this);
        fr.add(submit);

     

        fr.setVisible(true);
    }

    //@Override
    public void actionPerformed(ActionEvent e){
        boolean flag=false;
        String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";  
        Pattern p= Pattern.compile(emailvalidation);
        Matcher mat= p.matcher(tmail.getText());
      

        if(e.getSource()==submit)
        {
            if((tname.getText().isEmpty()) || (tname.getText() == null) && (tmail.getText().isEmpty()) || (tmail.getText() == null ))
            {
                JOptionPane.showMessageDialog(fr, "Please enter a valid field","warning",JOptionPane.WARNING_MESSAGE);
                if(tname.getText().isEmpty() || (tname.getText() == null))
                {
                	tname.setBackground(Color.red);
                }
                 if(tmail.getText().equals(""))
                {
                	tmail.setBackground(Color.red);
                }
            }
            else if(!mat.matches())
            {
                JOptionPane.showMessageDialog(fr, "Please Enter a valid Email","warning",JOptionPane.WARNING_MESSAGE);
            }
            else
                flag=true; 
                
            if(flag)
            {
                String r;
                if(one.isSelected())
                    r="One star";
                else if(two.isSelected())
                    r="Two stars";
                else if(three.isSelected())
                    r="Three stars";    
                else if(four.isSelected())
                    r="Four stars";
                else
                    r="Five stars";
                String s1= "Thank you for your valuable Feeedback!\n\nYour Responses:-\n";
                String s2= "Name: "+tname.getText()+"\nEmail: "+tmail.getText()+"\nAge group: "+(String)agegrp.getSelectedItem()+"\nRating: "+r+"\nFeedback: "+tfeedback.getText();
                String disp=s1+s2;
                JOptionPane.showMessageDialog(fr, disp);
            }
            
        }

         
        if(e.getSource().equals(submit))
        {
   		 String s= tname.getText();
   		 String s2= tmail.getText();
   		 new email(s,s2);
   		 
   		 
        }
        
         if(e.getSource().equals(submit))
         {
        	 try {
 			    // connection string
 				Class.forName("com.mysql.cj.jdbc.Driver"); 
 			        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root@123");
 			        Statement st =  con.createStatement();

 			        String sql = "insert into customerfeedback VALUES('"
 			                + tname.getText() + "','" + tmail.getText() + "','"
 			                + tfeedback.getText()+"')";
 			        st.executeUpdate(sql);
 			        JOptionPane.showConfirmDialog(null, "Customer Review Saved",
 			                "Result", JOptionPane.DEFAULT_OPTION,
 			                JOptionPane.PLAIN_MESSAGE);	       
 	
 	
 			         st.close();
 			        con.close(); 
 			        
 			}catch(Exception er){
 				er.printStackTrace();
 			} 
        	 finally{
        		 
        	            tname.setText(null);
        	            tmail.setText(null);
        	            tfeedback.setText(null);
        	            agegrp.setSelectedIndex(0);
        	            one.setSelected(false); 
        	            two.setSelected(false);   
        	            three.setSelected(false); 
        	            four.setSelected(false); 
        	            five.setSelected(true);       
        	        
        	 }
        	 
        	 
        	 
         }
         
         
    }

    public  void mouseClicked(MouseEvent e)
	{
            JTextField t =	(JTextField)	e.getSource();
            t.setBackground(Color.white);
	}
   
    public static void main(String args[]) throws Exception{
         new ClientForm();
    }

}
