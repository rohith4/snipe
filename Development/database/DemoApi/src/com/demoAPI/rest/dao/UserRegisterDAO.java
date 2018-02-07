package com.demoAPI.rest.dao;

import java.util.List;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Lists;
import com.demoAPI.rest.entity.Question;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.RecentQuestions;
import com.demoAPI.rest.entity.UserEntity;

public interface UserRegisterDAO {

	ResponseDTO saveUserreg(RequestDTO userReg);
	String getpwd(RequestDTO userReg);
	boolean checkemailId(RequestDTO userReg);
	void updateLoginStatusY(RequestDTO userReg);
	List<UserEntity> getUserList(RequestDTO userReg);
	
	
	void updateAnsStatusY(RequestDTO userReg);
	int modifyUser(RequestDTO userReg);
	void deleteUser(RequestDTO userReg);
	void updateLoginStatusN(RequestDTO userReg);
	
	
//	List<Recent> getrecentList(ResponseDTO response);
	
	//String getTag(RequestDTO userReg);
	//boolean checkTag(RequestDTO userReg);
	boolean checkAns(RequestDTO userReg);
	List<Recent> getrecentList(RequestDTO userReg);
	List<Question> getqueList(RequestDTO userReg);
	boolean checkanswered(RequestDTO userReg);
	List<Question> getRecentQ(RequestDTO userReg);
	List<Question> getPopularQ(RequestDTO userReg);
	boolean checkemailIdE(RequestDTO userReg);
	List<EmployeeEntity> getEmployeeList(RequestDTO userReg);
	List<Question> getrecentQuestionQs(RequestDTO userReg);
	void updateLoginStatusYE(RequestDTO userReg);
	void updateLoginStatusNE(RequestDTO userReg);
	ResponseDTO saveEmprreg(RequestDTO userReg);
	
	//String getTagId(RequestDTO userReg);
}
