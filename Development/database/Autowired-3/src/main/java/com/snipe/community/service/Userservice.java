package com.snipe.community.service;

import java.util.List;

import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.LoginResponse;
import com.snipe.community.entity.Question;
import com.snipe.community.entity.ResetPassword;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;

public interface Userservice {

	List getUserDetails();

	Responsedto getUserRegist(Requestdto userReg);

	Responsedto ContactUs(Requestdto userReg);

	Responsedto getrecentQeustion(Requestdto userReg);

	LoginResponse getLogin(Requestdto userReg);

	LoginResponse getLoginE(Requestdto userReg);
	
	
	
	
	
	
	

	List<Question> answered(Requestdto userReg);

	//List<UserEntity> getUsersList(Requestdto userReg);
	Responsedto modifyUser(Requestdto userReg);
	Responsedto deleteUser(Requestdto userReg);
	Responsedto logoutUser(Requestdto userReg);
	
	//List<Recent> getrecentList(Requestdto userReg);
	
	
	Responsedto askquestion(Requestdto userReg);
	Responsedto getTags(Requestdto userReg);
	Responsedto getEmployeeRegist(Requestdto userReg);
	
	Responsedto getupdatepwd(Requestdto userReg);
	Responsedto resetPwd(Requestdto userReg);
//	ResponseDTO getRecentList(RequestDTO userReg);
	//ResponseDTO getRecentList(RequestDTO userReg);
	Responsedto deleteEmployee(Requestdto userReg);
	//ResponseDTO getrecentQuestions(RequestDTO userReg);
	//Responsedto getrecentQeustion(Requestdto userReg);
//	Recent getRecentList(RequestDTO userReg);
	Responsedto answered1(Requestdto userReg);
	List<Question> getPopularq(Requestdto userReg);
	List<Employee> getEmployeeList(Requestdto userReg);
	List<Question> getrecentQeustionQs(Requestdto userReg);
//	Responsedto ContactUs(Requestdto userReg);
	Responsedto upDateEmployee(Requestdto userReg);

	List<Employee> getUsersList(Requestdto userReg);


	Responsedto deleteEmployee(int userReg);

	List<Answeres> getAnswer(int q_id);

	String resetPassword(Employee resetPassword);

	String resetPassword(ResetPassword resetPassword);

	

	
	
	
	
	
	
	
	

}
