package com.snipe.community.email;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;


import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.snipe.community.entity.Employee;
import com.snipe.community.helper.Helper;

import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;




/**
 * Servlet implementation class send
 */
public class send extends HttpServlet {
	
	
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private SessionFactory sessionFactory;
	
		public void otp(final String username) throws ServletException, IOException,Exception {

			
			/*System.out.println("Generating OTP using random() : ");
			System.out.print("Your OTP is : ");
			String numbers = "0123456789";
			Random rndm_method = new Random();
			int len = 8;
			char[] otp1 = new char[len];
			for (int i = 0; i < len; i++)
			{
				otp1[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
			System.out.println(otp1);
			String str=new 	String(otp1);	
			//String password="";
			
			*/
			
			
			
			
			
			
			String to="d.chennur@gmail.com";//change accordingly  
			  final String user="d.chennur@gmail.com";//change accordingly  
			  final String password="XXXXXXXXX";//change accordingly  
			   
			  //1) get the session object     
			  Properties properties = System.getProperties();  
			  properties.setProperty("mail.smtp.host", "smtp.gmail.com");  
			  properties.put("mail.smtp.auth", "true");  
			  properties.put("mail.smtp.port", "587");
			  properties.put("mail.smtp.starttls.enable","true");
			  Session session = Session.getInstance(properties,  
			   new javax.mail.Authenticator() 
			  {  
			   protected PasswordAuthentication getPasswordAuthentication() {  
			   return new PasswordAuthentication(user,password);  
			   }  
			  });  
			     
			  //2) compose message     
			  try{  
			    MimeMessage message = new MimeMessage(session);  
			    message.setFrom(new InternetAddress(user));  
			    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			    message.setSubject("Message Aleart");  
		
			     message.setText(user);
			    //7) send message  
			    Transport.send(message);  
			   
			    
			 /*org.hibernate.Session session1=sessionFactory.getCurrentSession();
			  //  Session session=sessionFactoy.getCurrentSession();
			//	System.out.println(st);
				
			//	logger.info("******UserRegisterDAOImpl.updateLoginStatus**************");
				Criteria crit = session1.createCriteria(Employee.class);
				crit.add(Restrictions.eq("emailId",user));	
				Employee entity = (Employee)crit.uniqueResult();
				entity.setPwd(helper.getPasswordEncoded(str,user));
				session1.saveOrUpdate(entity);
*/
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			   System.out.println("message sent....");  
			   }catch (MessagingException ex) 
			  {ex.printStackTrace();}
			
			
			 }  
			

			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			
			
			
		/*	System.out.println("Generating OTP using random() : ");
				System.out.print("Your OTP is : ");
				String numbers = "0123456789";
				Random rndm_method = new Random();
				int len = 8;
				char[] otp1 = new char[len];
				for (int i = 0; i < len; i++)
				{
					otp1[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
				}
				System.out.println(otp1);
				String str=new 	String(otp1);	
				String password="";
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "5870");
		System.out.print("Your OTP is :djkshfewjk ");
		System.out.println(username);
		Session session=Session.getInstance(props,new javax.mail.Authenticator()		
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username,"973_devaraj");
			}
		});
			Message message =new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject("Your OTP is");
			System.out.print("Your OTP is :djkshfewjk feiojerorjelkrjewlkrjelkrjelkj");		
			message.setText(str);
			System.out.print("I am running");
			Transport.send(message);
			
					
			
			System.out.println("Send email :"+username );
			System.out.println("done");
			System.out.println(str);
			return str;	
		}

*/
}
