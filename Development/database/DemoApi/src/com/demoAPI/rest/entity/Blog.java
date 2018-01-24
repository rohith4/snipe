package com.demoAPI.rest.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;






import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Blog")
public class Blog {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Message_Id")
	private int mid;

}
