package com.iispl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
 
import java.util.List;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean saveProduct(Product product) {

		Connection connection=null;
		String selectSQL = "INSERT INTO Product values(?,?,?,?,?)";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setString(1, product.getProductCode());
			prepStmt.setString(2, product.getProductName());
			prepStmt.setString(3, product.getProductDescription());
			prepStmt.setDate(4, Date.valueOf(product.getActivationDate()));
			prepStmt.setDate(5, Date.valueOf(product.getExpiryDate()));
			int count = prepStmt.executeUpdate();
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
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
