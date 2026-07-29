package com.iispl.main;

import java.util.List;

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
		List<Product> productList = productService.listAllProducts();
		System.out.println("Product code" + "     " + "product name" + "     " + "product description" + "        "
				+ "activation date" + "           " + "expiry date");
		for (Product product : productList) {
			System.out.println(product.getProductCode() + "              " + product.getProductName()
					+ "                 " + product.getProductDescription() + "                   "
					+ product.getActivationDate() + "            " + product.getExpiryDate());
		}

		
	}
	
	public static void getProductByCode(String productCode) {
		
	}
	
	public static void deleteProductByCode(String productCode) {
		
	}
	
	public static void updateExpiryDateByCode(String productCode) {
		
	}
	
}
