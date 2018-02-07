package com.demoAPI.rest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_REF")
	private int userId;
	

	@Column(name="FNAME")
	private String fname;
	

	
	
	@Column(name="EMP_ID")
	private String empId;
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Column(name="PASSWORD")
	private String pwd;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name="EMAIL_ID")
	private String emailId;
	


	
	

	@Column(name="DOB")
	private Date dob;
	
	@Column(name="REG_DATE")
	private Date date;
	
	
	

	@Column(name="COUNTRY")
	private String country;
	

	@Column(name="STATE")
	private String state;
	
	
	@Column(name="GENDER")
	private String gender;
	

	@Column(name="LOGIN_STATUS")
	private String loginStatus;
	
	@Column(name="LAST_LOGIN_TIME")
	private Date lastlogin;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	

	
	
public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserRef(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return fname;
	}
	public void setName(String fname) {
		this.fname = fname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	private String sendedmail;

	public String getSendedmail() {
		return sendedmail;
	}
	public String setSendedmail(String sendedmail) {
		return this.sendedmail = sendedmail;
	}
}
