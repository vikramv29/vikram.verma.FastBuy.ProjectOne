package com.app.dao;

import com.app.Exception.BusinessException;

public interface CartDAO {
	public int addProductInCart(int productId) throws BusinessException;

}
