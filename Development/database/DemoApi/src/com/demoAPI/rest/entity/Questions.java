package com.demoAPI.rest.entity;

import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Questions")
public class Questions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Question_No")
	private int Q_id;
	
	@Column(name="Questions")
	private String que;
	
	
	@Column(name="Asked_DATE")
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQ_id() {
		return Q_id;
	}

	public void setQ_id(int q_id) {
		Q_id = q_id;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

}
