package com.app.service.impl;

import com.app.Exception.BusinessException;
import com.app.dao.ProductDAO;
import com.app.dao.impl.ProductDAOImpl;
import com.app.model.Product;
import com.app.service.ProductService;

public class ProductServiceImpl implements ProductService {
	@Override
	public int addProduct(Product product) throws BusinessException {
		int c = 0;
		ProductDAO productDAO = new ProductDAOImpl();
		c = productDAO.addProduct(product);
		return c;
	}

	@Override
	public int deleteProduct(Product product) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
