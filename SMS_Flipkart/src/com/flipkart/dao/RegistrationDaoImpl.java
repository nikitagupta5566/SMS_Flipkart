package com.flipkart.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.exception.RegistrationCompletedException;
import com.flipkart.service.DateAndTime;
import com.flipkart.utils.DBUtil;

public class RegistrationDaoImpl implements RegistrationDao{
	private static Logger logger = Logger.getLogger(UserClient.class);
	DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	
	// Check if registration of student is completed
	public void checkRegistration(int userId) throws RegistrationCompletedException
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.CHECK_REGISTRATION);
			stmt.setInt(1,userId);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{
				throw new RegistrationCompletedException();
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
	}
	
	
	// Complete final Register by student
	@Override
	public void register(int userId,int paymentId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.REGISTER_COURSE);
			stmt.setInt(1,userId);
			stmt.setString(2,DateAndTime.getCurrentDateTime().format(formatter));
			stmt.setInt(3, paymentId);
			int rows = stmt.executeUpdate();
			logger.debug(rows);
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}
	

	
}
