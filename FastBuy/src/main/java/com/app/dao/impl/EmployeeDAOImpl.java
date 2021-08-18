package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.Exception.BusinessException;
import com.app.dao.EmployeeDAO;
import com.app.dbutil.MySqlConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	Logger log = Logger.getLogger(Main.class);

	@Override
	public Boolean checkValidCredentials(String username, String password) throws BusinessException {
		boolean login = false;
		try (Connection connection = MySqlConnection.getConnection()) {
			String sql = "select username,password from employee_details where username=? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				login = true;
			} else {
				throw new BusinessException("Credentials not found.Try Again!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Problem Occured. Contact sysAdmin!");
		}
		return login;
	}

}
