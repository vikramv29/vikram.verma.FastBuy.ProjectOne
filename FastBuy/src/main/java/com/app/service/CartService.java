package com.app.service;

import com.app.Exception.BusinessException;

public interface CartService {
	public int addProductInCart(int productId) throws BusinessException;
}
