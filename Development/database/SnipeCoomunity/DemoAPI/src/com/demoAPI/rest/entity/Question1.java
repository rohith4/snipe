package com.demoAPI.rest.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Criteria;


@Entity
@Table(name="Question1")
public class Question1 {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Q_id") 
	private int q_id;
	
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tag_id")
    private Tags1 tag_id;
	
	

	public void setTag_id(Tags1 tag_id) {
		this.tag_id = tag_id;
	}

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

	public Tags1 getTag_id() {
		return tag_id;
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

	

	

	public java.util.Date getCreatedate() {
		return Createdate;
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
	

}
