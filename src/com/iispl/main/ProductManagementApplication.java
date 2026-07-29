package com.iispl.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductManagementApplication {
	
	static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char goToMainMenu;
		
		do {
			
			System.out.println("1.Save Product 2.List all products 3.Get Product 4.Delete Product 5.Update Expiry Date");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
				
				case 1-> {
					System.out.println("Enter Product Code: ");
					String productCode = scanner.nextLine();
					
					System.out.println("Enter Product Name: ");
					String productName = scanner.nextLine();
					
					System.out.println("Enter Product Descrpition: ");
					String productDescrpition = scanner.nextLine();
					
					saveProduct(new Product(productCode, productName, productDescrpition, 
							LocalDate.of(2026, 07, 27), LocalDate.now().plusYears(6)));
				
					
				}
				
				case 2 -> {
					listAllProducts();
				}
					
				case 3 -> {
					System.out.println("Enter Product Code: ");
					String productCode = scanner.nextLine();
					
					getProductByCode(productCode);

					
				}
					
				case 4 -> {
					System.out.println("Enter Product Code: ");
					String productCode = scanner.nextLine();
					
					deleteProductByCode(productCode);
				}
				
				case 5 -> {
					System.out.println("Enter Product Code: ");
					String productCode = scanner.nextLine();
					
					Product product = productService.getProductByCode(productCode);
					
					
					updateExpiryDateByCode(productCode, product.getExpiryDate().plusYears(3));
				}	
				
				
				default -> 
					System.out.println("Inavild Choice");
			}
			
			System.out.println("Do want to continue(y/n): ");
			goToMainMenu = scanner.next().charAt(0);
			
		} while(goToMainMenu == 'y' || goToMainMenu == 'Y');
		
		scanner.close();
		
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
