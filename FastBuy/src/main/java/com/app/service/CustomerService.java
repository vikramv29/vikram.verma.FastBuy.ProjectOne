package com.app.service;

import com.app.Exception.BusinessException;
import com.app.model.Customer;

public interface CustomerService {
	public Customer checkValidCredentials(String username, String password) throws BusinessException;

	public int createAccount(Customer customer) throws BusinessException;

}
