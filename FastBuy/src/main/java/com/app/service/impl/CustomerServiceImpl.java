package com.app.service.impl;
import com.app.Exception.BusinessException;
import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.model.Customer;
import com.app.service.CustomerService;
public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public Boolean checkValidCredentials(String username, String password) throws BusinessException {
		boolean login = false;
		if (username.length() < 3 || password.length() < 6) {
			throw new BusinessException("Please enter valid Username and Password!");
		} else {
			login = customerDAO.checkValidCredentials(username, password);
		}
		return login;
	}

	@Override
	public int createAccount(Customer customer) throws BusinessException {
		int c = 0;
		CustomerDAO customerDAO = new CustomerDAOImpl();
		c = customerDAO.createAccount(customer);

		return c;
	}

}
