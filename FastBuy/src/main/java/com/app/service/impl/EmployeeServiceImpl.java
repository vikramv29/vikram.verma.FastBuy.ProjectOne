package com.app.service.impl;
import com.app.Exception.BusinessException;
import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.service.EmployeeService;
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public Boolean checkValidCredentials(String username, String password) throws BusinessException {
		boolean login = false;
		if (username.length() < 3 || password.length() < 6) {
			throw new BusinessException("Please enter valid Username and Password!");
		} else {
			login = employeeDAO.checkValidCredentials(username, password);
		}
		return login;
	}


}
