package com.demoAPI.rest.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;


@Entity
@Table(name="Question1")
public class Question1 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Q_id") 
	private int q_id;
	
	
	
	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}



	public void setCreatedate(java.util.Date date) {
		Createdate = date;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTag_id() {
		return tag_id;
	}

	

	public java.util.Date getCreatedate() {
		return Createdate;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}



	@Column(name="Question")
	private String que;
	
	
	@Column(name="Emp_Id")
	private String emp_id;
	
	@Column(name="CreatedDate")
	private java.util.Date Createdate;
	
	@Column(name="Modified_date")
	private Date modifiedDate;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Tag_Id")
	private int tag_id;
}
