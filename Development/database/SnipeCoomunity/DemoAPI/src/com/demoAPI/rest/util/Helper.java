package com.demoAPI.rest.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Component
public class Helper {
	
	private static final Logger logger = Logger.getLogger(Helper.class);
	
	public String getPasswordEncoded(String password,String key){
		logger.info("******Helper.getPasswordEncoded**************");
		Md5PasswordEncoder m5encoder=new Md5PasswordEncoder();
		return m5encoder.encodePassword(password,key);

	}
	
	public  void sendEmail(String email,String name){
		final String username = "p@gmail.com";
		final String password = "pwd";
		String fromMail="p@gmail.com";;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "false");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.quitwait","false");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback","false");
	    props.put("mail.debug","false");
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			String subject = "DEMO-API Alerts";
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
			try {
				message.setFrom(new InternetAddress(fromMail,"DEMO-API"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message.setReplyTo(InternetAddress.parse(fromMail, false));
			message.setSubject(subject, "UTF-8");
			message.setSentDate(new Date());
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email, false));
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String footer="<H3><BR><BR>"+"Thanks,</H3>DEMO API.";
			String htmlText ="Congratulations!! "+ name +" now you are registered for DEMO-API"+footer;
			messageBodyPart.setContent(htmlText, "text/html");        
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
