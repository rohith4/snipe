package com.demoAPI.rest.dto.request;

import java.io.Serializable;
import java.util.Date;



public class RequestDTO implements Serializable{

	
	private String address;
	private int mobileNo;
	
	
	
	private String answered;
	

	
	

	
	private String ans_status;
	

	
	private String rating;
	
	//private String fname;
	
	
	
	private String html;
	
	private String css;
	
	private String java;
	
	private String hadoop;
	
	public String getAnswered() {
		return answered;
	}
	public void setAnswered(String answered) {
		this.answered = answered;
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
	private String python;
	
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getHadoop() {
		return hadoop;
	}
	public void setHadoop(String hadoop) {
		this.hadoop = hadoop;
	}
	public String getPython() {
		return python;
	}
	public void setPython(String python) {
		this.python = python;
	}
	public String getAngular() {
		return angular;
	}
	public void setAngular(String angular) {
		this.angular = angular;
	}
	public String getJavascript() {
		return javascript;
	}
	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}
	public String getBigdata() {
		return bigdata;
	}
	public void setBigdata(String bigdata) {
		this.bigdata = bigdata;
	}
	public String getJquery() {
		return jquery;
	}
	public void setJquery(String jquery) {
		this.jquery = jquery;
	}
	public String getHibernate() {
		return hibernate;
	}
	public void setHibernate(String hibernate) {
		this.hibernate = hibernate;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	private String angular;
	
	private String javascript;
	
	private String bigdata;
	
	private String jquery;
	
	private String hibernate;
	
	private String others;
	
	
	
	
	
	
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	private String emailId;
	private String pwd;

	
	private String fname;
	
	private String que;
	
	private String tag;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private String lname;
	
	
	
	
	
	
	
	
	
	//private String userPwd;

	
	

	
	private Date dob;
	

	private Date date;
	
	
	

	
	private String country;

	private String state;
	private String gender;

	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobileNo() {
		return mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}