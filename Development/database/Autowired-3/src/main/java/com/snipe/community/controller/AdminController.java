package com.snipe.community.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;
import com.snipe.community.service.RestURLS;
import com.snipe.community.service.Userservice;

@Controller
@RequestMapping("/rest/admin")
public class AdminController {

	
	
	
	private static final Logger logger = Logger.getLogger(AdminController.class);
	
	@Autowired
	Userservice registrationService1;
	
	@RequestMapping(value = RestURLS.EMPLOYEE_REGISTER, method = RequestMethod.POST)
	public @ResponseBody Responsedto getEmployeeReg(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService1.getEmployeeRegist(userReg);
	}
}
