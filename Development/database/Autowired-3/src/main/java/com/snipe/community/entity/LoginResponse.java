package com.snipe.community.entity;

public class LoginResponse {
	
	
	public static final int SUCCESS=0;
private int returnCode=SUCCESS;
	
	public int getReturnCode() {
	return returnCode;
}

public void setReturnCode(int returnCode) {
	this.returnCode = returnCode;
}

public String getMessageReturn() {
	return messageReturn;
}

public void setMessageReturn(String string) {
	this.messageReturn = string;
}

public static int getSuccess() {
	return SUCCESS;
}

	private String messageReturn;

	

}
