package com.demoAPI.rest.entity;

import javax.persistence.Entity;


import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Table;



@Entity
@Table(name="Tags")
public class Tags {
	
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Tag_ID")
	private int id;

	@Column(name="Html")
	private String html;
	
	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getHadoop() {
		return hadoop;
	}

	public void setHadoop(String hadoop) {
		this.hadoop = hadoop;
	}

	public String getPython() {
		return python;
	}

	public void setPython(String python) {
		this.python = python;
	}

	public String getAngular() {
		return angular;
	}

	public void setAngular(String angular) {
		this.angular = angular;
	}

	public String getJavascript() {
		return javascript;
	}

	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}

	public String getBigdata() {
		return bigdata;
	}

	public void setBigdata(String bigdata) {
		this.bigdata = bigdata;
	}

	public String getJquery() {
		return jquery;
	}

	public void setJquery(String jquery) {
		this.jquery = jquery;
	}

	public String getHibernate() {
		return hibernate;
	}

	public void setHibernate(String hibernate) {
		this.hibernate = hibernate;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@Column(name="Css")
	private String css;
	
	@Column(name="Java")
	private String java;
	
	@Column(name="Hadoop")
	private String hadoop;
	
	@Column(name="Phyton")
	private String python;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="Angular")
	private String angular;
	
	@Column(name="Javascript")
	private String javascript;
	
	@Column(name="Bigdata")
	private String bigdata;
	
	@Column(name="Jquery")
	private String jquery;
	
	@Column(name="Hibernate")
	private String hibernate;
	
	@Column(name="Others")
	private String others;
}
