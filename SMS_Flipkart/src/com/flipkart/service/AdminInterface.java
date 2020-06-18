package com.flipkart.service;

import java.util.HashMap;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

public interface AdminInterface extends ServiceInterface{
	public void createCourse(Course course);
	public void deleteCourse(int course_id);
	public void createUser(User user,String role);
	public void deleteUser(String username);
	public String viewAllUsers(String typeOfUser);
	public void updateUser(User user);
	public void createStudent(User newUser, Student student);
	public void createProfessor(User newUser, Professor professor);
	public void createAdmin(User newUser, Admin admin);
	public void updateCourse(Course course);
	HashMap<Course, String> generateReportCard(int userId);
	
}
