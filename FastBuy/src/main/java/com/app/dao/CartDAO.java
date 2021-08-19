package com.app.dao;

import java.util.List;
import com.app.model.Cart;
import com.app.Exception.BusinessException;

public interface CartDAO {
	public int addProductInCart(int productId, int customerId) throws BusinessException;

	public List<Cart> getProductFromCart(int customerId) throws BusinessException;

	public int deleteProductInCart(int customerId) throws BusinessException;
}
