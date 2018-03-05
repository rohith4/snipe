package com.snipe.community.entity;

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

@Entity
public class Answeres {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="A_id") 
	private int A_id;
	


	   @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="Question_FK")
	private Question Question;
	
	@JoinColumn(name="question_pk")
	   private int Questionid;
	   

 
	public int getQuestionid() {
		return Questionid;
	}


	public void setQuestionid(int questionid) {
		Questionid = questionid;
	}


	public Question getQuestion() {
		return Question;
	}


	public void setQuestion(Question question) {
		Question = question;
	}


	@Column(name="ans")
	private String ans;
	
	@Column(name="EMP_ID")
	private String emp_id;
	
	public int getA_id() {
		return A_id;
	}


	public void setA_id(int a_id) {
		A_id = a_id;
	}

	public String getAns() {
		return ans;
	}


	public void setAns(String ans) {
		this.ans = ans;
	}


	public String getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	@Column(name="CreatedDate")
	private Date createdDate;
	
	
	@Column(name="Modified_Date")
	private Date modifiedDate;
	
	
}
