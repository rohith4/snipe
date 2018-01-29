package com.demoAPI.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERED")
public class Answered {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_REF")
	private int id;
	
	

	@Column(name="ANSWERED")
	private String answered;
	

	@Column(name="fname")
	private String fname;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAnswered() {
		return answered;
	}


	public void setAnswered(String answered) {
		this.answered = answered;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getAns_status() {
		return ans_status;
	}


	public void setAns_status(String ans_status) {
		this.ans_status = ans_status;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	@Column(name="ANSWER_STATUS")
	private String ans_status;
	

	@Column(name="RATING")
	private String rating;
	
}
