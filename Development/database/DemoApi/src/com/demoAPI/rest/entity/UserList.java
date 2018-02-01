package com.demoAPI.rest.entity;

import java.util.List;

public class UserList {
	
	public List<EmployeeEntity> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<EmployeeEntity> emplist) {
		this.emplist = emplist;
	}

	private List<EmployeeEntity> emplist;
	
	
}
