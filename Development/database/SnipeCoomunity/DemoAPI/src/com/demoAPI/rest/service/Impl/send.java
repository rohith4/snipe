package com.demoAPI.rest.service.Impl;

import java.io.IOException;

import java.util.Properties;
import java.util.Random;


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
		protected void otp(final String username) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*final String username1=request.getParameter("id");
		final String username=request.getParameter("uname");
		final String password=request.getParameter("pass");
		final String recipient=request.getParameter("recipient");*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
				System.out.println("Generating OTP using random() : ");
				System.out.print("Your OTP is : ");

				// Using numeric values
				String numbers = "0123456789";

				// Using random method
				Random rndm_method = new Random();
				int len = 8;
				char[] otp1 = new char[len];

				for (int i = 0; i < len; i++)
				{
					// Use of charAt() method : to get character value
					// Use of nextInt() as it is scanning the value as int
					otp1[i] =
					numbers.charAt(rndm_method.nextInt(numbers.length()));
				}
				System.out.println(otp1);
		
                 String str=new 	String(otp1);	
		
		
		
		
		
		//final String message1=request.getParameter("message1");
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		//Session session1=Session.getInstance(props);
		Session session=Session.getInstance(props,new javax.mail.Authenticator()		
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("d.chennur@gmail.com","973_devaraj");
			}
		}
		
		);
		
		
		try
		{
			Message message =new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
		
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
			message.setSubject("Your OTP is");
	
			message.setText(str);
			
			Transport.send(message);
			System.out.println("Send email :"+username );
			System.out.println("done");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		/*
//		String name=request.getParameter("message1");
		
		System.out.println(name);
		*/
	}
		



}
