package com.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.Main;
import com.app.Exception.BusinessException;
import com.app.dao.CartDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.EmployeeDAO;
import com.app.dao.ProductDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.EmployeeDAOImpl;
import com.app.dao.impl.ProductDAOImpl;
import com.app.model.Customer;
import com.app.model.Product;

class TestCases {

	
	// Test add product
	@Test
	void testAddProduct() throws BusinessException {
		ProductDAO dao = new ProductDAOImpl();
		
		Product product = new Product("AC", 50000.5, 4.2, 1);
		assertEquals(1,dao.addProduct(product), "Not Valid Product Details");
	}
	
	// Test add Customer 
	@Test
	void testAddCustomer() throws BusinessException {
		CustomerDAO dao = new CustomerDAOImpl();
		
		Customer customer = new Customer(1,"Vikram", "vikramv29","20182021" ,"vikramvv24@gmail.com");
		assertEquals(1,dao.createAccount(customer),"Not Valid Customer Details");
		
	}	
	
	// Test product add in cart
	@Test
	void testAddProductInCart() throws BusinessException {
		CartDAO dao = new CartDAOImpl();
		assertEquals(1,dao.addProductInCart(2, 1));
		
	}
	
	// Test product delete in cart
	@Test
	void testDeleteProductInCart() throws BusinessException {
		CartDAO dao = new CartDAOImpl();
		assertEquals(1,dao.deleteProductInCart(1));
		
	}
	
	// Test 
	@Test
	void testEmployeeLogin() throws BusinessException {
		
		EmployeeDAO dao = new EmployeeDAOImpl();
		assertEquals(true,dao.checkValidCredentials("vik29", "vikram"),"Not valid Entry");
		
	}
	

}