package com.app.service;

import java.util.List;

import com.app.Exception.BusinessException;
import com.app.model.Order;

public interface OrderService {
	public int createOrder(int customerId,int productId,double price) throws BusinessException;
	
	public List<Order> getOrderList(int customerId) throws BusinessException;
}