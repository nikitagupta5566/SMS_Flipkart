package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.utils.DBUtil;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;

public class UserDaoImpl implements UserDao{
	Connection conn = null;
	PreparedStatement stmt = null;
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	public String login(User user)
	{
		String role;
		conn = DBUtil.getConnection();
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.USER_LOGIN);
			
			stmt.setString(1,user.getUsername());
			stmt.setString(2, user.getPassword());
		
			
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				return "Wrong id or password";
			}
			else
			{
				role = rs.getString("role");
				logger.debug(role);
				return role;
			}
			
		}
		catch(SQLException e)
		{
			return e.getMessage();
		}
	
		
	}
	
	
}
