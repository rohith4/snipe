package com.demoAPI.rest.dto.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Question;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.UserEntity;

@SuppressWarnings("serial")
public class ResponseDTO implements Serializable{

	private String returnMsg;
	public static final int FAIL=1;
	public static final int SUCCESS=0;
	private int returnCode=SUCCESS;
	private int hostCode=SUCCESS;
	private String messageReturn;
	
	private List<EmployeeEntity> employeeentity;
	public List<EmployeeEntity> getEmployeeentity() {
		return employeeentity;
	}

	public void setEmployeeentity(List<EmployeeEntity> employeeentity) {
		this.employeeentity = employeeentity;
		
	}
	
	
	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}



public String getMessageReturn() {
		return messageReturn;
	}

	public void setMessageReturn(String messageReturn) {
		this.messageReturn = messageReturn;
	}
	
	private List<UserEntity> userEntity;
	private List<Question> question1;

	public List<Question> getQuestion1() {
		return question1;
	}

	public void setQuestion1(List<Question> question1) {
		this.question1 = question1;
	}

	public List<Recent> getRecent() {
		return recent;
	}

	public void setRecent(List<Recent> recent) {
		this.recent = recent;
	}

	private List<Recent> recent;
	
	
	
	public List<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(List<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

	
	
	
	


	
	
	
	
	
	
	
	
	
	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public int getHostCode() {
		return hostCode;
	}

	public void setHostCode(int hostCode) {
		this.hostCode = hostCode;
	}

	public List<String> getAppmsgs() {
		return appmsgs;
	}

	public void setAppmsgs(List<String> appmsgs) {
		this.appmsgs = appmsgs;
	}

	private List<String> appmsgs=new ArrayList<String>();

	
	
}
