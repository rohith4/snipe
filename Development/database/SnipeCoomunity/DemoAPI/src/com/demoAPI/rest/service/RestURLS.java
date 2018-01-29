package com.demoAPI.rest.service;

public interface RestURLS {
	/* Rest URL */
	String DEMO_REST_CONTEXT = "/rest";
	String DEMO_REST_REGISTERUSER = "/registerUser";
	String DEMO_REST_LOGIN="/loginUser";
	String DEMO_REST_GETUSERS = "/getUsersList";
	String DEMO_REST_MODIFYUSER = "/modifyUser";
	String DEMO_REST_DELETEUSER = "/deleteUser";
	String DEMO_REST_LOGOUT="/logout";
	
	
	String TAGS="/tags";
	String ASK_Q="/askq";
	String RECENT="/recent";
	String ANSWERED="/answered";
	String EMPLOYEE_REGISTER="/registerEmployee";
	String DELETE_EMPLOYEE="/deleteEmployee";
	String UPDATEPWD="/updatepwd";
	String RESETPWD="/resetpwd";
}
