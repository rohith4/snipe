package com.demoAPI.rest.dao;

import java.util.List;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Lists;
import com.demoAPI.rest.entity.Question1;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.UserEntity;

public interface UserRegisterDAO {

	ResponseDTO saveUserreg(RequestDTO userReg);
	String getpwd(RequestDTO userReg);
	boolean checkemailId(RequestDTO userReg);
	void updateLoginStatusY(RequestDTO userReg);
	List<UserEntity> getUserList(RequestDTO userReg);
	
	
	void updateAnsStatusY(RequestDTO userReg);
	boolean modifyUser(RequestDTO userReg);
	void deleteUser(RequestDTO userReg);
	void updateLoginStatusN(RequestDTO userReg);
	
	
//	List<Recent> getrecentList(ResponseDTO response);
	
	//String getTag(RequestDTO userReg);
	//boolean checkTag(RequestDTO userReg);
	boolean checkAns(RequestDTO userReg);
	List<Recent> getrecentList(RequestDTO userReg);
	List<Question1> getqueList(RequestDTO userReg);
	boolean checkanswered(RequestDTO userReg);
	List<Question1> getRecentQ(RequestDTO userReg);
	List<Question1> getPopularQ(RequestDTO userReg);
	boolean checkemailIdE(RequestDTO userReg);
	List<EmployeeEntity> getEmployeeList(RequestDTO userReg);
	
	//String getTagId(RequestDTO userReg);
}
