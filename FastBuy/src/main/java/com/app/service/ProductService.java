package com.app.service;

import com.app.Exception.BusinessException;
import com.app.model.Product;

public interface ProductService {
	public int addProduct(Product product) throws BusinessException;

	public int deleteProduct(Product product) throws BusinessException;

}
