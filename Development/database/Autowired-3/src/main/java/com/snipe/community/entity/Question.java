package com.snipe.community.entity;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Criteria;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Question1")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Q_id") 
	private int q_id;
	
	@Column(name="Question")
private String question;
	
	@Column(name="Ratings")
private int ratings;
	
	
	
	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
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
		return emp_name;
	}

	

	public void setEmp_id(String emp_id) {
		this.emp_name = emp_name;
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

	

	
	
	
	
	

	@Column(name="Answer")
	private String ans;
	
	
	@Column(name="Emp_name")
	private String emp_name;
	
	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}


	@Column(name="createdate")
	private String createdate;
	

/*
	@Column(name="CreatedDate")
	private java.util.Date Createdate;*/
	
	
	
	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}






	@Column(name="Modified_date")
	private Date modifiedDate;
	
	@Column(name="Status")
	private String status;



	
	

}
