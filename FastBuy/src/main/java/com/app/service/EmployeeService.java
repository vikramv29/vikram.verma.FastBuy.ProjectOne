package com.app.service;

import com.app.Exception.BusinessException;

public interface EmployeeService {
	public Boolean checkValidCredentials(String username, String password) throws BusinessException;

}
