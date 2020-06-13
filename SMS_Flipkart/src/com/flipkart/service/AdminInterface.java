package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface AdminInterface {
	public void createCourse(Course course);
	public void deleteCourse(int course_id);
	public void createUser(User user);
	public void deleteUser(String username);
	public void generateResult();
	public void generateReportCard();
	public String viewAllUsers(String typeOfUser);
	
}
