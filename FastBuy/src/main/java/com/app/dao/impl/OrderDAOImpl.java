package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.Exception.BusinessException;
import com.app.dao.OrderDAO;
import com.app.dbutil.MySqlConnection;
import com.app.model.Order;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public int createOrder(int customerId, int productId, double price) throws BusinessException {
		
		int c =0;
		try (Connection connection = MySqlConnection.getConnection()) {
			
			String sql = "insert into orders(or_cu_id,or_pr_id,or_price,or_status) values(?,?,?,'Shipped')";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1,customerId);
			preparedStatement.setInt(2,productId);
			preparedStatement.setDouble(3, price);
			c = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException(e.getMessage()+" Internal Problem Occured. Contact sysAdmin!");
		}
		return c;
		
	}

	@Override
	public List<Order> getOrderList(int customerId) throws BusinessException {
		List<Order> orderList = new ArrayList<>();
		
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select or_id,pro_id,pro_name,pro_price,or_status from orders join product on or_pr_id=pro_id join customer_details on or_cu_id= cu_id where cu_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();			
			while(resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("or_id"));
				order.setProductId(resultSet.getInt("pro_id"));
				order.setProductName(resultSet.getString("pro_name"));
				order.setPrice(resultSet.getDouble("pro_price"));
				order.setOrderStatus(resultSet.getString("or_status"));
				orderList.add(order);
			}
			if(orderList.size()<1) {
				throw new BusinessException("You have no orders");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage()+" Internal Problem Occured. Contact sysAdmin!");
		}
		return orderList;
	}
	@Override
	public List<Order> getOrderList() throws BusinessException {
		List<Order> orderList = new ArrayList<>();

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select or_id,pro_id,pro_name,pro_price,or_status from orders join product on or_pr_id=pro_id join customer_details on or_cu_id= cu_id where or_status=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "ordered");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("or_id"));
				order.setProductId(resultSet.getInt("pro_id"));
				order.setProductName(resultSet.getString("pro_name"));
				order.setPrice(resultSet.getDouble("pro_price"));
				order.setOrderStatus(resultSet.getString("or_status"));
				orderList.add(order);
			}
			if (orderList.size() < 1) {
				throw new BusinessException("Customers have no orders Yet!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage() + " Internal Problem Occured. Contact sysAdmin!");
		}
		return orderList;
	}
	@Override
	public int updateOrderStatus(int orderId,String status) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlConnection.getConnection()) {

			String sql = "update orders set or_status = ? where or_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, orderId);
			
			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException(e.getMessage() + " Internal Problem Occured. Contact sysAdmin!");
		}
		return c;

	}
	@Override
	public List<Order> markGetOrderList(int customerId) throws BusinessException {
		List<Order> orderList = new ArrayList<>();

		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select or_id,pro_id,pro_name,pro_price,or_status from orders join product on or_pr_id=pro_id join customer_details on or_cu_id= cu_id where cu_id=? and or_status=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			preparedStatement.setString(2, "shipped");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = new Order();
				order.setOrderId(resultSet.getInt("or_id"));
				order.setProductId(resultSet.getInt("pro_id"));
				order.setProductName(resultSet.getString("pro_name"));
				order.setPrice(resultSet.getDouble("pro_price"));
				order.setOrderStatus(resultSet.getString("or_status"));
				orderList.add(order);
			}
			if (orderList.size() < 1) {
				throw new BusinessException("Customers have no orders Yet!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage() + " Internal Problem Occured. Contact sysAdmin!");
		}
		return orderList;
	}

}