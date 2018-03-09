package com.snipe.community.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Response;
import com.snipe.community.response.Responsedto;
import com.snipe.community.service.Userservice;


@RequestMapping("/admin")
public class AdminPanel {
	
	
	@Autowired
	private Userservice userService;
	
	
	private static final Logger logger = Logger.getLogger(AdminPanel.class);	
	
	@RequestMapping(value ="/admin", method = RequestMethod.POST)
	public @ResponseBody Response ContactUs(@RequestBody Requestdto userReg) {
		logger.info("******UserRegistrationController.ontact**************");
		return userService.admin(userReg);
	}
	

}
