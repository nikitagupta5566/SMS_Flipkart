package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement stmt = null;
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	public void login(User user)
	{
		conn = DBUtil.getConnection();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.USER_LOGIN);
			
			stmt.setString(1,user.getUsername());
			stmt.setString(2, user.getPassword());
		
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				user.setRoleId(rs.getInt("roleId"));
				user.setId(rs.getInt("id"));
			}
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
	
	}

	@Override
	public void createUser(User user) {
		conn = DBUtil.getConnection();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.CREATE_USER);
			
			stmt.setString(1,user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getRoleId());
			stmt.setString(4, user.getGender());
			int rows = stmt.executeUpdate();
			logger.debug(rows);
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
	}
	
	
	public void deleteUser(String username)
	{
		conn = DBUtil.getConnection();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_USER);
			
			stmt.setString(1,username);
			
			int rows = stmt.executeUpdate();
			logger.debug(rows);
		}
		catch(SQLException e)
		{
//			return e.getMessage();
		}
	}

	@Override
	public List<User> fetchUsers() {
		List<User>userList = new ArrayList<User>();
		
		conn = DBUtil.getConnection();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.SELECT_ALL_USERS);
			
			ResultSet rs = stmt.executeQuery();
			User user;
			
			while(rs.next())
			{
				user = new User();
				user.setRoleId(rs.getInt("id"));
				user.setGender(rs.getString("gender"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getInt("id"));
				userList.add(user);
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		return userList;
	}
	
	
}
