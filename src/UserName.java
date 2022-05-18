import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class UserName implements ActionListener {

	JFrame bn;	JTextField t;
	JLabel l;
	JButton btn,btn2 ;
	String str ;
	public UserName()
	{
	 bn= new JFrame("VIP SuperMarket PVT.LTD");
	 t= new JTextField(30);
	 l= new JLabel("Customer Name ");
	 btn = new  JButton("Submit");
	 btn2 = new  JButton("Feedback");
	str = "Unknown user";
	l.setFont(new Font("Arial",Font.PLAIN,18));
	btn.setFont(new Font("Arial",Font.PLAIN,18));
	btn2.setFont(new Font("Arial",Font.PLAIN,18));
	
	btn.addActionListener(this);
	btn2.addActionListener(this);
	bn.setLayout(null);
	bn.setBounds(900,300,550,300);
	l.setBounds(100,50,200,50);
	t.setBounds(250,60,150,30);
	btn.setBounds(150,100,100,30);
	btn2.setBounds(300,100,180,30);
	bn.add(l);
	bn.add(t);
	bn.add(btn);
	bn.add(btn2);
	bn.setVisible(true);
	bn.setResizable(false);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent er) {
		
		if(er.getSource().equals(btn))
		{
			Confirm c = new Confirm();
			str =t.getText();
			c.j.setTitle(str);
			String s = str.concat(".png");
			
			try{
				Savepaint.getSaveSnapShot(c.j,s);
				}catch(Exception ee)
				{
					System.out.println(ee);
				}
			JOptionPane.showMessageDialog(bn,"Customer Name saved","Message",JOptionPane.PLAIN_MESSAGE);
		
		}
		
		
		
		if(er.getSource().equals(btn2))
		{
		
			new ClientForm();
			bn.setVisible(false);
			
			
		}
		
	}
	
	
	 public static void main(String args[])
	{
		new UserName();
	}
}
