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
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.UserEntity;
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
	
	
	
	
	@RequestMapping(value = RestURLS.EMPLOYEE_REGISTER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getEmployeeReg(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getEmployeeRegist(userReg);
	}
	
	
	

	@RequestMapping(value = RestURLS.TAGS, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getTags(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getTags(userReg);
	}
	
	
	
	
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGIN, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getLogin(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return registrationService.getLogin(userReg);
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	//@RequestMapping(value = RestURLS.DEMO_REST_GETUSERS, method = RequestMethod.POST)
	
	//public @ResponseBody ResponseDTO getUsersList(@RequestBody RequestDTO userReg) {
		public @ResponseBody ResponseDTO getUsers( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return registrationService.getUsersList(userReg);
		
		
		//logger.info("******UserRegistrationController.getUsersList**************");
		//return registrationService.getUsersList(userReg); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = RestURLS.DEMO_REST_MODIFYUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO modifyUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.modifyUser**************");
		return registrationService.modifyUser(userReg);	
	}
	

	@RequestMapping(value = RestURLS.DEMO_REST_DELETEUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO deleteUser(@RequestBody RequestDTO userReg) {
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
		return registrationService.getTags(userReg);
		
	}
	
	
	
	@RequestMapping(value=RestURLS.ANSWERED, method=RequestMethod.POST)
	public @ResponseBody ResponseDTO answered(@RequestBody RequestDTO userReg)
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return registrationService.answered(userReg);
		
	}
	
	

	
	
	
	
	

	@RequestMapping(value = RestURLS.RECENT, method = RequestMethod.GET, produces = "application/json")
	//@RequestMapping(value = RestURLS.DEMO_REST_GETUSERS, method = RequestMethod.POST)
	
	//public @ResponseBody ResponseDTO getUsersList(@RequestBody RequestDTO userReg) {
		public @ResponseBody ResponseDTO getrecent( RequestDTO userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return registrationService.getRecentList(userReg);
		
		
		//logger.info("******UserRegistrationController.getUsersList**************");
		//return registrationService.getUsersList(userReg); 
	}
	
	 
	
	
	
	
	
	
	
	
	
/*	@RequestMapping(value=RestURLS.RECENT,method=RequestMethod.POST)
	public @ResponseBody ResponseDTO getrecent(@RequestBody @PathVariable String fname)
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println(""+fname);
		return registrationService.getRecentList(fname);
		
	}
	*/
	
	
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
