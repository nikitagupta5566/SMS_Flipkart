package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.client.UserClient;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.service.DateAndTime;
import com.flipkart.utils.DBUtil;

public class ProfessorCourseDaoImpl implements ProfessorCourseDao{
	private static Logger logger = Logger.getLogger(UserClient.class);
	@Override
	public void selectCourse(int userId,int courseId) {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.SELECT_COURSE_TO_TEACH);
			stmt.setInt(1,userId);
			stmt.setInt(2,courseId);
			
			stmt.executeUpdate();
			
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
	@Override
	public void checkCourse(int courseId) throws CourseNotAvailableException{
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.GET_PROFESSOR_COURSE);
			stmt.setInt(1,courseId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				throw new CourseNotAvailableException();
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
	}
	
	
	@Override
	public boolean verifyProfessor(int courseId,int userId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.GET_PROFESSOR_COURSE);
			stmt.setInt(1,courseId);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				if(rs.getInt("user_id") == userId)
					return true;
			}
			
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		return false;
		
	}
	
}
