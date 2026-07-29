package com.iispl.main;

import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductManagementApplication {
	
	static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {
		
		//Don't code anything here.
		
	}
	
	public static void saveProduct(Product product) {
		ProductServiceImpl productServiceImpl=new ProductServiceImpl();
		boolean result=productServiceImpl.saveProduct(product);
		if(result) {
			System.out.println("Product Saved Successfully");
		}
		else {
			System.out.println("Product Not saved");
		}
		
	}
	
	public static void listAllProducts() {
		
	}
	
	public static void getProductByCode(String productCode) {
		
	}
	
	public static void deleteProductByCode(String productCode) {
		
	}
	
	public static void updateExpiryDateByCode(String productCode) {
		
	}
	
}
