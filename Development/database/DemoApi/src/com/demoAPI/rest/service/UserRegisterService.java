package com.demoAPI.rest.service;

import java.util.List;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.UserEntity;

public interface UserRegisterService  {

	ResponseDTO getUserRegist(RequestDTO userReg);
	ResponseDTO answered(RequestDTO userReg);
	ResponseDTO getLogin(RequestDTO userReg);
	ResponseDTO getUsersList(RequestDTO userReg);
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
	
}
