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
		
	}
	
	public static void listAllProducts() {
		
	}
	
	public static void getProductByCode(String productCode) {
		
	}
	
	public static void deleteProductByCode(String productCode) {
		Product product =productService.getProductByCode(productCode);
		if(product==null) {
			System.out.println("Product doesn't exist to delete");
			return;
		}
		if(productService.deleteProductByCode(productCode)) {
			System.out.println("Product Successfully removed");
		}else {
			System.out.println("Product has not been removed");
		}
		
		
	}
	
	public static void updateExpiryDateByCode(String productCode) {
		
	}
	
}
