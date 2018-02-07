package com.demoAPI.rest.service;

import java.util.List;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Lists;
import com.demoAPI.rest.entity.LoginResponse;
import com.demoAPI.rest.entity.Question;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.RecentQuestions;
import com.demoAPI.rest.entity.UserEntity;
import com.demoAPI.rest.entity.UserList;

public interface UserRegisterService  {

	ResponseDTO getUserRegist(RequestDTO userReg);
	ResponseDTO answered(RequestDTO userReg);
	LoginResponse getLogin(RequestDTO userReg);
	List<UserEntity> getUsersList(RequestDTO userReg);
	ResponseDTO modifyUser(RequestDTO userReg);
	ResponseDTO deleteUser(RequestDTO userReg);
	ResponseDTO logoutUser(RequestDTO userReg);
	
	List<Recent> getrecentList(RequestDTO userReg);
	
	
	ResponseDTO askquestion(RequestDTO userReg);
	ResponseDTO getTags(RequestDTO userReg);
	ResponseDTO getEmployeeRegist(RequestDTO userReg);
	
	ResponseDTO getupdatepwd(RequestDTO userReg);
	ResponseDTO resetPwd(RequestDTO userReg);
//	ResponseDTO getRecentList(RequestDTO userReg);
	//ResponseDTO getRecentList(RequestDTO userReg);
	ResponseDTO deleteEmployee(RequestDTO userReg);
	//ResponseDTO getrecentQuestions(RequestDTO userReg);
	ResponseDTO getrecentQeustion(RequestDTO userReg);
//	Recent getRecentList(RequestDTO userReg);
	ResponseDTO answered1(RequestDTO userReg);
	ResponseDTO getPopularq(RequestDTO userReg);
	List<EmployeeEntity> getEmployeeList(RequestDTO userReg);
	List<Question> getrecentQeustionQs(RequestDTO userReg);
	ResponseDTO ContactUs(RequestDTO userReg);
	ResponseDTO upDateEmployee(RequestDTO userReg);
	LoginResponse getLoginE(RequestDTO userReg);
	
}
