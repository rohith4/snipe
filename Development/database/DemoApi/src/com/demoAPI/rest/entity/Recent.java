package com.demoAPI.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recent")
public class Recent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="UNAME")
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Column(name="FNAME")
	private String fname;
	
	@Column(name="TAG")
	private String tag;
	
	@Column(name="Questions")
	private String Question;
	
	@Column(name="DATE")
	private String Date;
	
	@Column(name="ANS")
	private String ans;
	
	@Column(name="RATING")
	private String rating;
	
	@Column(name="ANS_STATUS")
	private String ans_status;
	public String getAns_status() {
		return ans_status;
	}
	public void setAns_status(String ans_status) {
		this.ans_status = ans_status;
	}

	
	
	
	
}
