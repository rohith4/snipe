package com.demoAPI.rest.entity;

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
public class Tags1 {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id") 
	private int id;
	
	
	private String tag_name;




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTag_name() {
		return tag_name;
	}


	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
}
