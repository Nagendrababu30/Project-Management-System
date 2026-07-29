package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.model.Product;

public class ProductDaoImpl implements ProductDao {

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
	public boolean updateExpiryDateByCode(String productCode, LocalDate expiryDate) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			DataSource dataSource = ConnectionPool.getDataSource();
			connection = dataSource.getConnection();
			String updateSQL = "UPDATE product SET expiry_date = ? WHERE product_code = ? ";
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setObject(1, expiryDate);
			preparedStatement.setString(2, productCode);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			
			if(noOfRowsAffected <= 0) {
				return false;
			}
			
			
		} catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return true;
	}

}
