package com.snipe.community.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMP_REF")
	private int empId;
	
	
	
/*	@Column(name="EID")
	private int eid;*/
	
	@Column(name="UEID")
	private int ueid;
	
	
	
	
	public int getUeid() {
		return ueid;
	}
	public void setUeid(int ueid) {
		this.ueid = ueid;
	}
/*	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}*/

   

	@Column(name="Qualification")
	private String qualification;
	
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String date2) {
		this.doj = date2;
	}
	@Column(name="DOJ")
	private String doj;
	
	
	
	
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
	private String dob; 
	
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
	
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String date2) {
		this.dob = date2;
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
	public String setSendedmail(String emailId2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
