package com.iispl.service;

import java.util.List;

import com.iispl.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);
	
	public List<Product> listAllProducts();
	
	public Product getProductByCode(String productCode);
	
	public boolean deleteProductByCode(String productCode);
	
	public boolean updateExpiryDateByCode(String productCode);
	
}
