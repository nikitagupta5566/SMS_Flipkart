package com.flipkart.service;

import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Registration;

public interface StudentInterface extends ServiceInterface{
	public void addCourse(int courseId,int userId);
	public void dropCourse(int courseId,int userId);
	public float getBill(int userId);
	public void register(int userId,int modeId) ;
	public List<Course> viewEnrolledCourses(int userId);
	HashMap<Course, String> viewReportCard(int userId);
	public Registration getRegistrationDetails(int userId);
}
