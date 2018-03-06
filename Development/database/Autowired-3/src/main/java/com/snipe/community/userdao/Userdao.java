package com.snipe.community.userdao;

import java.util.List;

import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.Question;
import com.snipe.community.entity.Recent;
import com.snipe.community.entity.ResetPassword;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;




public interface Userdao {

	List getUserDetails();

	boolean checkemailId(Requestdto userReg);

	boolean checkemailIdE(Requestdto userReg);

	Responsedto saveUserreg(Requestdto userReg);

	Responsedto contactUs(Requestdto userReg);

	List<Question> getRecentQ(Requestdto userReg);

	String getpwd(Requestdto userReg);

	void updateLoginStatusY(Requestdto userReg);

	Responsedto getLoginuser(Requestdto userReg);

	String getpwdE(Requestdto userReg);

	int updateLoginStatusYE(Requestdto userReg);

	List<Question> getrecentQuestionQs(Requestdto userReg);

	List<Employee> getEmployeeList(Requestdto userReg);

	List<Question> getPopularQ(Requestdto userReg);
	
	
	
	
	boolean checkAns(Requestdto userReg);
	List<Recent> getrecentList(Requestdto userReg);
	List<Question> getqueList(Requestdto userReg);
	boolean checkanswered(Requestdto userReg);
	void updateLoginStatusNE(Requestdto userReg);
	Responsedto saveEmprreg(Requestdto userReg);
	boolean checkEmpId(String userReg);
	void deleteEmployee(int userReg);

	void deleteUser(Requestdto userReg);

	int modifyUser(Requestdto userReg);

	List<Employee> getUserList(Requestdto userReg);

	void updateLoginStatusN(Requestdto userReg);

	boolean checkEmpId(Requestdto userReg);

	boolean checkemailId(String userReg);

	boolean checkempId(int userReg);

	boolean checkanswered(Question userReg);

	List<Answeres> getAnsweres(int q_id);

	Employee isUserExist(ResetPassword resetPassword);

	String resetPassword(String emailId, String encriptString);

	
	
	
	
	
	
	
	
	

}
