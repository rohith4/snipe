package com.snipe.community.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import com.snipe.community.entity.Employee;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public void sendResetPassword(Employee user,String password) {
		sendMail("devarajchennur@gmail.com", user.getEmailId(), "DHC Portal: Reset Password",
				"Hi " + user.getFname()
						+ ",\n\nTo continue DHC portal, login using your temporary password below.\n\nUsername: "
						+ user.getFname() + "\n\nTemporary password: " + password);
	}

	public void sendMail(String from, String to, String subject, String msg) {
		final SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		Thread t = new Thread() {
			public void run() {
				emailSender.send(message);
			};
		};
		t.start();
	}

	
}