package com.snipe.community.email;

import com.snipe.community.entity.Employee;

public interface EmailService {
	public void sendResetPassword(Employee emp,String password) throws Exception;
}
