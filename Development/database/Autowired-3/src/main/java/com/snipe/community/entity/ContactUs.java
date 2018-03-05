package com.snipe.community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ContactUs")
public class ContactUs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contactid")
	private int id;
	
	
	@Column(name="Uname")
	private String name;
	
	
	@Column(name="EmailId")
	private String emailId;
	
	
	@Column(name="Messages")
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
