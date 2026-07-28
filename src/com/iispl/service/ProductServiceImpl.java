package com.iispl.service;

import java.util.List;

import com.iispl.dao.ProductDao;
import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByCode(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProductByCode(String productCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateExpiryDateByCode(String productCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
