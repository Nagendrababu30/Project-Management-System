package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
		return null;
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
	public boolean updateExpiryDateByCode(String productCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
