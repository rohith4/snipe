package com.demoAPI.rest.entity;

import java.util.List;

public class Lists {
	
	
	private List<UserEntity> userentity;
 
	private List<EmployeeEntity> employeeentity;
	public List<EmployeeEntity> getEmployeeentity() {
		return employeeentity;
	}

	public void setEmployeeentity(List<EmployeeEntity> employeeentity) {
		this.employeeentity = employeeentity;
		
	}

	public List<UserEntity> getUserentity() {
		return userentity;
	}

	public void setUserentity(List<UserEntity> userentity) {
		this.userentity = userentity;
	}

}
