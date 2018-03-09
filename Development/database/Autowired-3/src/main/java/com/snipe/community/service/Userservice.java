package com.snipe.community.service;

import java.util.List;

import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.LoginResponse;
import com.snipe.community.entity.Question;
import com.snipe.community.entity.ResetPassword;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Response;
import com.snipe.community.response.Responsedto;

public interface Userservice {

	List getUserDetails();

	Response getUserRegist(Requestdto userReg);

	Responsedto ContactUs(Requestdto userReg);

	Responsedto getrecentQeustion(Requestdto userReg);

	Response getLogin(Requestdto userReg);

	Response getLoginE(Requestdto userReg);
	
	
	
	
	
	
	

	List<Question> answered(Requestdto userReg);

	//List<UserEntity> getUsersList(Requestdto userReg);
	Response modifyUser(Requestdto userReg);
	Responsedto deleteUser(Requestdto userReg);
	Response logoutUser(Requestdto userReg);
	
	//List<Recent> getrecentList(Requestdto userReg);
	
	
	Response askquestion(Requestdto userReg);
	Responsedto getTags(Requestdto userReg);
	Response getEmployeeRegist(Requestdto userReg);
	
	Responsedto getupdatepwd(Requestdto userReg);
	Response resetPwd(Requestdto userReg) ;
//	ResponseDTO getRecentList(RequestDTO userReg);
	//ResponseDTO getRecentList(RequestDTO userReg);
	
	//ResponseDTO getrecentQuestions(RequestDTO userReg);
	//Responsedto getrecentQeustion(Requestdto userReg);
//	Recent getRecentList(RequestDTO userReg);
	Response answered1(Requestdto userReg);
	List<Question> getPopularq(Requestdto userReg);
	List<Employee> getEmployeeList(Requestdto userReg);
	List<Question> getrecentQeustionQs(Requestdto userReg);
//	Responsedto ContactUs(Requestdto userReg);
	Responsedto upDateEmployee(Requestdto userReg);

	List<Employee> getUsersList(Requestdto userReg);


	Response deleteEmployee(int userReg);

	List<Answeres> getAnswer(int q_id);

	String resetPassword(Employee resetPassword);

	String resetPassword(ResetPassword resetPassword);

	Response admin(Requestdto userReg);

	Response getAdmin(Requestdto userReg);

	

	
	
	
	
	
	
	
	

}
