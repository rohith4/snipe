package com.demoAPI.rest.dao;

import java.util.List;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.UserEntity;

public interface UserRegisterDAO {

	ResponseDTO saveUserreg(RequestDTO userReg);
	String getpwd(RequestDTO userReg);
	boolean checkemailId(RequestDTO userReg);
	void updateLoginStatusY(RequestDTO userReg);
	List<UserEntity> getUserList(RequestDTO userReg);
	boolean modifyUser(RequestDTO userReg);
	void deleteUser(RequestDTO userReg);
	void updateLoginStatusN(RequestDTO userReg);
	
	
	boolean checkTag(RequestDTO userReg);
}
