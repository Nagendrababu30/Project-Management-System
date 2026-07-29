package com.iispl.main;

import java.time.LocalDate;

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
		
	}
	
	public static void updateExpiryDateByCode(String productCode, LocalDate expiryDate) {
		
		boolean isUpdateExpiryDateSuccesfull = productService.updateExpiryDateByCode(productCode, expiryDate);
		
		if(isUpdateExpiryDateSuccesfull) {
			
			System.out.println("Updation Successfull");
			
		} else {
			
			System.out.println("Updation failed");
			
		}
		
	}
	
}
