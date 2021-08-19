package com.app.service;

import java.util.List;
import com.app.Exception.BusinessException;
import com.app.model.Cart;

public interface CartService {
	public int addProductInCart(int productId, int customerId) throws BusinessException;

	public List<Cart> getProductFromCart(int customerId) throws BusinessException;
}
