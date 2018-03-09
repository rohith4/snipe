package com.snipe.community.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contactid")
	private int id;
	
	
	@Column(name="ADMIN")
	private String admin;
	
	
	@Column(name="PASSWORD")
	private String password;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setPwd(String passwordEncoded) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
