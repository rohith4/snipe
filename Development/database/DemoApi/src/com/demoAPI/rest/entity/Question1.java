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
	
	@Column(name="Question")
private String question;
	
	@Column(name="Ratings")
private String ratings;
	
	
	
	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}




	@Column(name="tag_name")
private String tag_name;

	public String getTag_name() {
	return tag_name;
}

public void setTag_name(String tag_name) {
	this.tag_name = tag_name;
}




	//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	
	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
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

	

	

	public java.util.Date getCreatedate() {
		return Createdate;
	}

	


	@Column(name="Answer")
	private String ans;
	
	
	@Column(name="Emp_Id")
	private String emp_id;
	
	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}




	@Column(name="CreatedDate")
	private java.util.Date Createdate;
	
	@Column(name="Modified_date")
	private Date modifiedDate;
	
	@Column(name="Status")
	private String status;
	

}
