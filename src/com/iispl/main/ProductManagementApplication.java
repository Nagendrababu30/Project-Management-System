package com.iispl.main;

import java.time.LocalDate;
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
		Product product = productService.getProductByCode(productCode);
		if(product!=null) {
			System.out.println(product.getProductCode()+"    "+product.getProductName()+"    "+product.getProductDescription()+"   "+product.getActivationDate()+"   "+product.getExpiryDate());		
		}else {
			System.out.println("Product Not Found");
		}
		
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
	
	public static void updateExpiryDateByCode(String productCode, LocalDate expiryDate) {
		
		boolean isUpdateExpiryDateSuccesfull = productService.updateExpiryDateByCode(productCode, expiryDate);
		
		if(isUpdateExpiryDateSuccesfull) {
			
			System.out.println("Updation Successfull");
			
		} else {
			
			System.out.println("Updation failed");
			
		}
		
	}
	
}
