package com.snipe.community.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

public class Requestdto implements Serializable {

	

	private String name;
	
	//private String emailId;
	
	
	
	public int getUeid() {
		return ueid;
	}
	public void setUeid(int ueid) {
		this.ueid = ueid;
	}
	private int ueid;
	
	private String message;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private int tag_id;
	
   
	private String qualification;
	
	private Date doj;
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	


	
	
	private int empId;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	private String address;
	private String mobileNo;
	
	private String uname;
	
	private String question;
	
	private String ans;

	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	
	

	
	private String ans_status;
	

	
	private int rating;
	
	//private String fname;
	
	
	private int q_id;
	
	
	private String html;
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	private String css;
	
	private String java;
	
	private String hadoop;
	
	
	public String getAns_status() {
		return ans_status;
	}
	public void setAns_status(String ans_status) {
		this.ans_status = ans_status;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
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
	
	
	
	
	
	

	private String emailId;
	private String pwd;

	
	private String fname;
	
	
	
	private String tag_name;
	
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	private String tag;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	public String getFname() {
		return fname;
	}
	public String getQuestion() {
		return question;
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
	

	private String date;
	
	
	

	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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

	
	public String getMobileNo() {
		return mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
