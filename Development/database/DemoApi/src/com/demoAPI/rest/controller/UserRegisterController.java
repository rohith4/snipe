package com.demoAPI.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.demoAPI.rest.service.RestURLS;
import com.demoAPI.rest.service.UserRegisterService;
import com.itextpdf.text.log.SysoCounter;

@Controller
@RequestMapping(RestURLS.DEMO_REST_CONTEXT)
public class UserRegisterController {
	private static final Logger logger = Logger.getLogger(UserRegisterController.class);
	
	@Autowired
	UserRegisterService registrationService;
	
	@RequestMapping(value = RestURLS.DEMO_REST_REGISTERUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getUserReg(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getUserRegist(userReg);
	}

	

	
	
	
	
	
	
	
	
	@RequestMapping(value ="/contact", method = RequestMethod.POST)
	public @ResponseBody ResponseDTO ContactUs(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.ContactUs(userReg);
	}
	
	
	
	
	
	
	@RequestMapping(value = "/recentq", method = RequestMethod.GET, produces = "application/json")

//	@RequestMapping(value = RestURLS.RECENTQ, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getrecentQuestions( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getrecentQeustion(userReg);
	}
	
	
	
	


	
	
	
	
	@RequestMapping(value = RestURLS.TAGS, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getTags(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getTags(userReg);
	}
	
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGIN, method = RequestMethod.POST)
	public @ResponseBody LoginResponse getLogin(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return registrationService.getLogin(userReg);
	}
	
	
	
	@RequestMapping(value = "/loginemp", method = RequestMethod.POST)
	public @ResponseBody LoginResponse getLoginE(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return registrationService.getLoginE(userReg);
	}
	
	
	

	@RequestMapping(value = "/answered", method = RequestMethod.POST)
	public @ResponseBody ResponseDTO answered1(@RequestBody RequestDTO userReg)  
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return registrationService.answered1(userReg);
	}
	
	
	
		@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<UserEntity> getUsers( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return registrationService.getUsersList(userReg);
	}
		
		
		
		@RequestMapping(value = "/recentQs", method = RequestMethod.GET, produces = "application/json")
//		@RequestMapping(value = RestURLS.RECENTQ, method = RequestMethod.POST)
		public @ResponseBody List<Question> getrecentQuestionQs( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
			logger.info("******UserRegistrationController.getUserReg**************");
			return registrationService.getrecentQeustionQs(userReg);
		}
		
		
		
		
		
		
		
		
		@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<EmployeeEntity> getEmployee( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return registrationService.getEmployeeList(userReg);
	}
		
		
	
	
	
	
	@RequestMapping(value = "/popularq", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseDTO getPopularq( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
	logger.info("getUsers: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
      return registrationService.getPopularq(userReg);
}	
	@RequestMapping(value = "/editemp", method = RequestMethod.PUT, produces = "application/json")
	//@RequestMapping(value = RestURLS.DEMO_REST_MODIFYUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO modifyUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.modifyUser**************");
		return registrationService.modifyUser(userReg);	
	}
	
	
	/*public @ResponseBody ResponseDTO updateRegister(@RequestBody RequestDTO  userReg, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("saveemployee: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	//	logger.info("saveEmployee: Received request: " + CommonUtils.getJson(employee));
		return registrationService.upDateEmployee(userReg);
	}*/
	
	
	
	
	
	
	

	
	//@RequestMapping(value = RestURLS.DEMO_REST_DELETEUSER, method = RequestMethod.POST)
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE,produces="application/json")
	public @ResponseBody ResponseDTO deleteUser(@RequestBody RequestDTO userReg,UserEntity user,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("******UserRegistrationController.deleteUser**************");
		System.out.println();
		return registrationService.deleteUser(userReg);
	}
	
	
	
	
	@RequestMapping(value = RestURLS.DELETE_EMPLOYEE, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO deleteEmployee(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.deleteUser**************");
		System.out.println();
		return registrationService.deleteEmployee(userReg);
	}
	
	
	@RequestMapping(value = "/deleteemp", method = RequestMethod.DELETE,produces="application/json")
	public @ResponseBody ResponseDTO deleteRegister(@RequestBody RequestDTO userReg,EmployeeEntity employee, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteemployee: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	//	logger.info("deleteEmployee: Received request: " + CommonUtils.getJson(employee));
		return registrationService.deleteEmployee(userReg);
	}
	
	

	
	
	
	
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGOUT, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO logoutUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.logoutUser**************");
	
		System.out.println("");
		return registrationService.logoutUser(userReg);
	}
	
	@RequestMapping(value=RestURLS.ASK_Q, method=RequestMethod.POST)
	public @ResponseBody ResponseDTO askQuestion(@RequestBody RequestDTO userReg)
	{
		logger.info("********UserRigistrationController.Ak Questions*******");
		System.out.println("");
		return registrationService.askquestion(userReg);
		
	}
	
	
	@RequestMapping(value = "/unanswered", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseDTO answered( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return registrationService.answered(userReg);
		
		
	}
	 
		
	@RequestMapping(value=RestURLS.UPDATEPWD, method=RequestMethod.POST)
	public @ResponseBody ResponseDTO updatepwd(@RequestBody RequestDTO userReg)
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return registrationService.getupdatepwd(userReg);
		
	}
	
	
	
	@RequestMapping(value=RestURLS.RESETPWD, method=RequestMethod.POST)
	public @ResponseBody ResponseDTO resetPwd(@RequestBody RequestDTO userReg)
	{
		logger.info("********UserRigistrationController.ResetPassword*******");
		System.out.println("");
		return registrationService.resetPwd(userReg);
		
	}
	
	
	
}
