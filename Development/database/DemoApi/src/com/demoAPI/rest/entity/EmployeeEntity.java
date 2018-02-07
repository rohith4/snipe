package com.demoAPI.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_REF")
	private int Empid;
	
	
	@Column(name="DATE")
	private Date date;

   

	@Column(name="Qualification")
	private String qualification;
	
	
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
	@Column(name="DOJ")
	private Date doj;
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="EMP_FNAME")
	private String fname;
	
	@Column(name="EMP_LNAME")
	private String lname;
	
	@Column(name="EMP_EMAIL")
	private String emailId;
	
	

	@Column(name="GENDER")
	private String gender;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="EMP_MOBILENO")
	private String mobileNo;
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PASSWORD")
	private String pwd;
	
	
	
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
	@Column(name="EMP_DOB")
	private Date dob; 
	
	@Column(name="EMP_STATE")
	private String state;
	
	@Column(name="EMP_COUNTRY")
	private String country;
	
	@Column(name="EMP_STATUS")
	private String status;
	
	@Column(name="LOGIN_STATUS")
	private String loginStatus;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	public int getEmpid() {
		return Empid;
	}
	public void setEmpid(int empid) {
		Empid = empid;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setLastlogin(Date date2) {
		// TODO Auto-generated method stub
		
	}
	

}
