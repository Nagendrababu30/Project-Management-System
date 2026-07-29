package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<Product> productList = new ArrayList<Product>();
		Connection connection = null;
		PreparedStatement prepStmt = null;
		String selectSql = "select * from product";
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSql);
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				productList.add(new Product(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDate(4).toLocalDate(),resultSet.getDate(5).toLocalDate()));
			}
			connection.close();
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return productList;
	}

	@Override
	public Product getProductByCode(String productCode) {
		// TODO Auto-generated method stub
		Product product = null;
		Connection connection = null;
		String selectSQL = "SELECT* FROM product WHERE product_code = ?";
		PreparedStatement prepStmt = null;
		
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			prepStmt.setString(1, productCode);
			ResultSet resultSet = prepStmt.executeQuery();
			
			if(resultSet.next()) {
			product = new Product(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDate(4).toLocalDate(),resultSet.getDate(5).toLocalDate());
		}
		connection.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
		return product;
	}

	@Override
	public boolean deleteProductByCode(String productCode) {
		String sqlquery="delete from product where product_code=?";
		DataSource dataSource=null;
		Connection connection=null;
		try {
			dataSource=ConnectionPool.getDataSource();
			connection=dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sqlquery);
			preparedStatement.setString(1, productCode);
			int effectedRows=preparedStatement.executeUpdate();
			if(effectedRows>0)
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
