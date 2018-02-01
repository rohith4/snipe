package com.demoAPI.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.service.RestURLS;
import com.demoAPI.rest.service.UserRegisterService;

@Controller
@RequestMapping("/rest/admin")
public class AdminController {

	
	
	
	private static final Logger logger = Logger.getLogger(UserRegisterController.class);
	
	@Autowired
	UserRegisterService registrationService;
	
	@RequestMapping(value = RestURLS.EMPLOYEE_REGISTER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getEmployeeReg(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getEmployeeRegist(userReg);
	}
}
