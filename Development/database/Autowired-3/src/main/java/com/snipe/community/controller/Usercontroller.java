package com.snipe.community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snipe.community.response.CommonUtils;
import com.snipe.community.response.ErrorObject;
import com.snipe.community.response.Response;
import com.snipe.community.constant.StatusCode;
import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.LoginResponse;
import com.snipe.community.entity.Question;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;
import com.snipe.community.service.RestURLS;
import com.snipe.community.service.Userservice;

@Controller
@RequestMapping(value="/user")
public class Usercontroller {

	
	private static final Logger logger = Logger.getLogger(Usercontroller.class);	
	
	
	@Autowired
	private Userservice userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity Userdetails() {
        
		List userDetails = userService.getUserDetails();
		return new ResponseEntity(userDetails, HttpStatus.CONTINUE);
	}
	
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public @ResponseBody Response getUserReg(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return userService.getUserRegist(userReg);
	}
	
	
	
	@RequestMapping(value ="/admin", method = RequestMethod.POST)
	public @ResponseBody Response Admin(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.ontact**************");
		return userService.admin(userReg);
	}
	
	
	
	
	
	@RequestMapping(value ="/contact", method = RequestMethod.POST)
	public @ResponseBody Responsedto ContactUs(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.ontact**************");
		return userService.ContactUs(userReg);
	}
	
	@RequestMapping(value = "/recentq", method = RequestMethod.GET, produces = "application/json")

//	@RequestMapping(value = RestURLS.RECENTQ, method = RequestMethod.POST)
	public @ResponseBody Responsedto getrecentQuestions( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("******UserRegistrationController.getUserReg**************");
		return userService.getrecentQeustion(userReg);
	}
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public @ResponseBody Response getLogin(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return userService.getLogin(userReg);
	}
	
	@RequestMapping(value = "/loginemp", method = RequestMethod.POST)
	public @ResponseBody Response getLoginE(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return userService.getLoginE(userReg);
	}
	
	
	
	@RequestMapping(value = "/loginadmin", method = RequestMethod.POST)
	public @ResponseBody Response getAdmin(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return userService.getAdmin(userReg);
	}
	
	
	
	


	
	
	
	
	@RequestMapping(value = RestURLS.TAGS, method = RequestMethod.POST)
	public @ResponseBody Responsedto getTags(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return userService.getTags(userReg);
	}
	
	
	

	@RequestMapping(value = "/answered", method = RequestMethod.POST)
	public @ResponseBody Response answered1(@RequestBody Requestdto userReg)  
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return userService.answered1(userReg);
	}
	
	
	
		@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Employee> getUsers( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return userService.getUsersList(userReg);
	}
		
		
		
		@RequestMapping(value = "/recentQs", method = RequestMethod.GET, produces = "application/json")
//		@RequestMapping(value = RestURLS.RECENTQ, method = RequestMethod.POST)
		public @ResponseBody List<Question> getrecentQuestionQs( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
			logger.info("******UserRegistrationController.getUserReg**************");
			return userService.getrecentQeustionQs(userReg);
		}
		
		
		
		
		
		
		
		
		@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Employee> getEmployee( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("getUsers: Received request: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	      return userService.getEmployeeList(userReg);
	}
		
		
	
	
	
	
	@RequestMapping(value = "/popularq", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Question> getPopularq( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception {
	logger.info("getUsers: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
      return userService.getPopularq(userReg);
}	
	
	
	
	@RequestMapping(value = "/Answers/{q_id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Answeres> getAnswer( @PathVariable("q_id")int q_id,HttpServletRequest request, HttpServletResponse response) throws Exception {
	logger.info("getUsers: Received request: " + request.getRequestURL().toString()
			+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
      return userService.getAnswer(q_id);
}	
	
	
	
	
	
	
	
	@RequestMapping(value = "/editemp", method = RequestMethod.PUT, produces = "application/json")
	//@RequestMapping(value = RestURLS.DEMO_REST_MODIFYUSER, method = RequestMethod.POST)
	public @ResponseBody Response modifyUser(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.modifyUser**************");
		return userService.modifyUser(userReg);	
	}
	
	
	/*public @ResponseBody Responsedto updateRegister(@RequestBody RequestDTO  userReg, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("saveemployee: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	//	logger.info("saveEmployee: Received request: " + CommonUtils.getJson(employee));
		return userService.upDateEmployee(userReg);
	}*/
	
	
	
	
	
	
	

	
	//@RequestMapping(value = RestURLS.DEMO_REST_DELETEUSER, method = RequestMethod.POST)
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE,produces="application/json")
	public @ResponseBody Responsedto deleteUser(@RequestBody Requestdto userReg,Employee user,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("******UserRegistrationController.deleteUser**************");
		System.out.println();
		return userService.deleteUser(userReg);
	}
	
	
	
	
	@RequestMapping(value = "/deleteemp/{empId}", method = RequestMethod.DELETE,produces="application/json")
	public @ResponseBody Response deleteRegister(@PathVariable("empId") int userReg,Employee employee, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("deleteemployee: Received request URL: " + request.getRequestURL().toString()
				+ ((request.getQueryString() == null) ? "" : "?" + request.getQueryString().toString()));
	//	logger.info("deleteEmployee: Received request: " + CommonUtils.getJson(employee));
		return userService.deleteEmployee(userReg);
	}
	
	

	
	
	
	
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGOUT, method = RequestMethod.POST)
	public @ResponseBody Response logoutUser(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.logoutUser**************");
	
		System.out.println("");
		return userService.logoutUser(userReg);
	}
	
	@RequestMapping(value=RestURLS.ASK_Q, method=RequestMethod.POST)
	public @ResponseBody Response askQuestion(@RequestBody Requestdto userReg)
	{
		logger.info("********UserRigistrationController.Ak Questions*******");
		System.out.println("");
		return userService.askquestion(userReg);
		
	}
	
	
	@RequestMapping(value = "/unanswered", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Question> answered( Requestdto userReg,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return userService.answered(userReg);
		
		
	}
	 
		
	@RequestMapping(value=RestURLS.UPDATEPWD, method=RequestMethod.POST)
	public @ResponseBody Responsedto updatepwd(@RequestBody Requestdto userReg)
	{
		logger.info("********UserRigistrationController.Answered*******");
		System.out.println("");
		return userService.getupdatepwd(userReg);
		
	}
	
	
	
	@RequestMapping(value="/resetpwd", method=RequestMethod.POST)
	public @ResponseBody Response resetPwd(@RequestBody Requestdto userReg)
	{
		logger.info("********UserRigistrationController.ResetPassword*******");
		System.out.println("");
		return userService.resetPwd(userReg);
		
	}
	
	
	
	
	@RequestMapping(value = "/user/resetPassword", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody String resetPassword(@RequestBody com.snipe.community.entity.ResetPassword resetPassword, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String status = userService.resetPassword(resetPassword);
	Response res = CommonUtils.getResponseObject("Reset password");
		if (status.equalsIgnoreCase(com.snipe.community.constant.StatusCode.ERROR.name())) {
			ErrorObject err = CommonUtils.getErrorResponse("Reset password failed", "Reset password failed");
			res.setErrors(err);
			res.setStatus(StatusCode.ERROR.name());
		}
		logger.info("resetPassword: Sent response");
		return CommonUtils.getJson(res);
	}
	
	
	
}
