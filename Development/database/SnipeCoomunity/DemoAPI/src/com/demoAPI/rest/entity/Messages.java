package com.demoAPI.rest.entity;




import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Messages")
public class Messages {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Message_Id")
	private int mid;
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name="Message")
	private String message;
	
}
