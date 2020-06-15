package com.flipkart.dao;

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
import com.flipkart.service.DateAndTime;
import com.flipkart.utils.DBUtil;

public class StudentCourseDaoImpl implements StudentCourseDao{
	DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	// Adds a course to the student course list
		public void addCourse(int course_id,int user_id)
		{
			logger.info("hi");
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE);
				stmt.setInt(1,user_id);
				stmt.setInt(2,course_id);
				stmt.setString(3,DateAndTime.getCurrentDateTime().format(formatter));
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
		
		// Drop course from student course list
		public void dropCourse(int course_id,int user_id)
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.DROP_COURSE);
				stmt.setInt(1,user_id);
				stmt.setInt(2,course_id);
				int rows = stmt.executeUpdate();
				logger.debug(rows);
				
			}
			catch(SQLException e)
			{
				logger.error(e.getMessage());
			}
			
		}
		
		// Get a list of enrolled students in a course
		
		public List<User> getEnrolledStudents(int courseId) {
			// TODO Auto-generated method stub
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			List<User> userList = new ArrayList<User>();
			User user;
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.GET_ENROLLED_STUDENTS);
				stmt.setInt(1, courseId);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next())
				{
					user = new User();
					user.setUsername(rs.getString("username"));
					user.setGender(rs.getString("gender"));
					user.setId(rs.getInt("id"));
					userList.add(user);
				}
			}
			catch(SQLException e)
			{
				logger.error(e.getMessage());
			}
			catch(Exception e)
			{
				logger.error(e.getMessage());
			}
			
			return userList;
			
		}
		
		// Submit grades of a particular student for a course by professor
		@Override
		public void submitGrades(int courseId, String username,String grade) {
			// TODO Auto-generated method stub
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.SUBMIT_GRADES);
				stmt.setString(1,grade);
				stmt.setString(2,username);
				stmt.setInt(3,courseId);
				
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
		
		// Get list of enrolled courses by a student
		@Override
		public List<Course> getEnrolledCourses(int userId) {
			// TODO Auto-generated method stub
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			List<Course>courseList = new ArrayList<Course>();
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.GET_ENROLLED_COURSES);
				stmt.setInt(1,userId);
				
				
				ResultSet rs = stmt.executeQuery();
				Course course;
				while(rs.next())
				{
					course = new Course();
					course.setCourseid(rs.getInt("courseid"));
					course.setCoursename(rs.getString("name"));
					course.setPrice(rs.getFloat("price"));
					courseList.add(course);
				}
							
			}
			catch(SQLException e)
			{
				logger.error(e.getMessage());
			}
			catch(Exception e)
			{
				logger.error(e.getMessage());
			}
			return courseList;
		}

		@Override
		public void generateReportCard(int userId) {
			// TODO Auto-generated method stub
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = null;
			
			try
			{
				stmt = conn.prepareStatement(SQLConstantQueries.GENERATE_REPORT_CARD);
				stmt.setInt(1,userId);
				
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next())
				{
					
				}
				
				
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
