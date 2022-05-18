import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
public class email {  
	public email(String str, String str2)
	{
		String host="smtp.gmail.com";  
		  final String user="vk118105112105110@gmail.com";  
		  final String password="work@come@1";  
		    
		  String to=str2; 
		  
		    
		   
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", true);
		   props.put("mail.smtp.starttls.enable",true);
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "25");
		   props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", true);  
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		    
		   try{  
			    MimeMessage message = new MimeMessage(session);  
			    message.setFrom(new InternetAddress(user));  
			    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			    message.setSubject("Thank you for your valueable feedback");  
			      
			        
			    BodyPart messageBodyPart1 = new MimeBodyPart();  
			    messageBodyPart1.setText("Thank you for shopping at VIP SuperMarket PVT.LTD");  
			      String s1="D:\\Supermarket Billing\\";
			      String s2= str.concat(".png");
			         
			    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
			  
			    String filename = s1.concat(s2);//change accordingly  
			    DataSource source = new FileDataSource(filename);  
			    messageBodyPart2.setDataHandler(new DataHandler(source));  
			    messageBodyPart2.setFileName(filename);  
			     
			     
			        
			    Multipart multipart = new MimeMultipart();  
			    multipart.addBodyPart(messageBodyPart1);  
			    multipart.addBodyPart(messageBodyPart2);  
			  
			     
			    message.setContent(multipart );  
			     
			    
			    Transport.send(message);  
			   
			    JOptionPane.showMessageDialog(null,"Email sent Successfully...","Message",JOptionPane.PLAIN_MESSAGE);
			   }catch (MessagingException ex) {ex.printStackTrace();}  
	}
	public static void main(String args[])
	{
		new email("vipin","sainvipin221@gmail.com");
	}
  
}  