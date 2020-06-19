package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.ProfessorCourseDao;
import com.flipkart.dao.ProfessorCourseDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.StudentCourseDao;
import com.flipkart.dao.StudentCourseDaoImpl;
import com.flipkart.exception.CourseNotAvailableException;

public class ProfessorService implements ProfessorInterface{
	private static Logger logger = Logger.getLogger(UserClient.class);
	StudentCourseDao studentCourseDao = new StudentCourseDaoImpl();
	ProfessorCourseDao professorCourseDao = new ProfessorCourseDaoImpl();
	
	String s = "";
	
	
	
	@Override
	public void submitGrades(int courseId, String username,String grade) {
		// Submit grades for a student of a particular course
		RegistrationDao registrationDao = new RegistrationDaoImpl();
		studentCourseDao.submitGrades(courseId,username,grade);
	}

	// Select a course to teach by professor
	@Override
	public void selectCourse(int userId,int courseId) {
		ProfessorCourseDao professorCourseDao = new ProfessorCourseDaoImpl();
		
		try
		{
			professorCourseDao.checkCourse(courseId);
			professorCourseDao.selectCourse(userId,courseId);
			logger.info("Course selected with id: " + courseId);
		}
		catch(CourseNotAvailableException e)
		{
			logger.error(e.getMessage());
		}
	}

	
	
	@Override
	public List<User> viewEnrolledStudents(int courseId,int userId) {
		// View list of enrolled students in the courses taught by professor
		List<User> userList = null;
		
		if(professorCourseDao.verifyProfessor(courseId,userId))
		{
			RegistrationDao registrationDao = new RegistrationDaoImpl(); 
			userList = studentCourseDao.getEnrolledStudents(courseId);	
		}
		
		return userList;
	}
	
	// View list of courses taught by the professor
	public List<Course> viewAllottedCourses(int userId)
	{
		List<Course>allotedCourseList = professorCourseDao.viewAllottedCourses(userId);
		return allotedCourseList;
	}
}
