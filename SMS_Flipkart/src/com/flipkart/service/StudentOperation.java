package com.flipkart.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Registration;
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
	
	// drop a course
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
	public float getBill(int userId) {
		float amount = 0;
		// TODO Auto-generated method stub
		try
		{
			registrationDao.checkRegistration(userId);
			amount = studentCourseDao.calculateFee(userId);
		}
		catch(RegistrationCompletedException e)
		{
			logger.error(e.getMessage());
		}
		
		return amount;
		
	}
	
	// Register the courses
	@Override
	public void register(int userId,int modeId) {
		// TODO Auto-generated method stub
		
		registrationDao.register(userId,modeId);
		
	}

	
	// View Report Card after semester completion
	@Override
	public HashMap<Course,String> viewReportCard(int userId) {
		HashMap<Course,String> gradeList = studentCourseDao.generateReportCard(userId);
		
		return gradeList;
		
		// TODO Auto-generated method stub
		
	}

	// View list of enrolled courses
	@Override
	public List<Course> viewEnrolledCourses(int userId) {
		// TODO Auto-generated method stub
		List<Course> courseList = studentCourseDao.getEnrolledCourses(userId);
		return courseList;
	}
	
	public Registration getRegistrationDetails(int userId)
	{
		Registration registration = new Registration();
		registration.setUserId(userId);
		return registrationDao.getRegistrationDetails(registration);
	}

	
}


