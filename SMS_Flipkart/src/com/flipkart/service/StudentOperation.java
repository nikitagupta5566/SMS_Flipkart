package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.StudentCourseDao;
import com.flipkart.dao.StudentCourseDaoImpl;
import com.flipkart.exception.RegistrationCompletedException;

public class StudentOperation implements StudentInterface{
	private static Logger logger = Logger.getLogger(UserClient.class);
	RegistrationDao registrationDao = new RegistrationDaoImpl();
	StudentCourseDao studentCourseDao = new StudentCourseDaoImpl();
	String s;

	
	// Add a course to list of main courses
	@Override
	public void addCourse(int courseId,int userId) {
		try
		{
			registrationDao.checkRegistration(userId);
			studentCourseDao.addCourse(courseId,userId);
		}
		catch(RegistrationCompletedException e)
		{
			logger.error(e.getMessage());
		}
		
	}
	
	// drop a course from main course
	@Override
	public void dropCourse(int courseId, int userId) {
		try
		{
			registrationDao.checkRegistration(userId);
			studentCourseDao.dropCourse(courseId,userId);
		}
		catch(RegistrationCompletedException e)
		{
			logger.error(e.getMessage());
		}
		
		
		
	}
	
	// Pay bill for all the registered courses  
	@Override
	public void payBill() {
		// TODO Auto-generated method stub
		
		
	}
	
	// Register the courses
	@Override
	public void register(int userId,int modeId) {
		// TODO Auto-generated method stub
		try
		{
			registrationDao.checkRegistration(userId);
			registrationDao.register(userId,modeId);
		}
		catch(RegistrationCompletedException e)
		{
			logger.error(e.getMessage());
		}
		
	}

	
	// View Report Card after semester completion
	@Override
	public void viewReportCard() {
		
		// TODO Auto-generated method stub
		
	}

	// View list of enrolled courses
	@Override
	public String viewEnrolledCourses(int userId) {
		// TODO Auto-generated method stub
		List<Course> courseList = studentCourseDao.getEnrolledCourses(userId);
		s = "\n===============================================" 
				+ "\n" 
				+ String.format("%-20s", "Id") 
				+ String.format("%-20s","Name")
				+ String.format("%-20s", "Price") 
				+ "\n===============================================";
		
		courseList.forEach(course -> {
			s = s + "\n" + String.format("%-20s", course.getCourseid()) 
			+ String.format("%-20s", course.getCoursename())
			+ String.format("%-20s", course.getPrice());
		});
		
		return s;
	}
}


