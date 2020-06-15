package com.flipkart.dao;

import com.flipkart.exception.CourseNotAvailableException;

public interface ProfessorCourseDao {
	public void selectCourse(int userId,int courseId);
	public void checkCourse(int courseId) throws CourseNotAvailableException;
	public boolean verifyProfessor(int courseId,int userId);
}
