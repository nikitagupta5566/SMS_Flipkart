package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.constant.SQLConstantQueries;
import com.flipkart.service.DateAndTime;
import com.flipkart.utils.DBUtil;

public class CourseDaoImpl implements CourseDao{
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	public void createCourse(Course course)
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.CREATE_COURSE);
			stmt.setInt(1,course.getCourseid());
			stmt.setString(2,course.getCoursename());
			stmt.setString(3, course.getCoursedescription());
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
	
	
	public void deleteCourse(int course_id)
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try
		{
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSE);
			stmt.setInt(1,course_id);
		
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
