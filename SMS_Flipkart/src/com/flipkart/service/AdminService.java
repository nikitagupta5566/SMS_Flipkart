package com.flipkart.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class AdminService implements AdminInterface{
	UserDao userdao = new UserDaoImpl();
	CourseDao coursedao = new CourseDaoImpl();
	String s = "";
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	// View all users filtered by role of user 
	@Override
	public String viewAllUsers(String typeOfUser) {
		// TODO Auto-generated method stub 
		List<User>userList = userdao.fetchUsers();
		
		String userList1 = "\n=========================" + String.format("%-15s", "\nUserID")
				+ String.format("%-15s", "Username") + "\n=========================" + 
				userList.stream().
				filter(user -> user.getRole().equals(typeOfUser)).
				flatMap(user -> Stream.of(
						String.format("\n%-15s", user.getId()),user.getGender().equals("male") ? String.format("%-15s", "Mr.".concat(user.getUsername())): String.format("%-15s", "Miss.".concat( user.getUsername() )))).
				collect(Collectors.joining(""));
		
		return userList1;
	}
	
	// Add a new Course to the catalog
	@Override
	public void createCourse(Course course) {
		coursedao.createCourse(course);
		// TODO Auto-generated method stub
		
	}
	
	// Delete a course from catalog
	@Override
	public void deleteCourse(int course_id) {
		coursedao.deleteCourse(course_id);
	}

	// Add a new user
	@Override
	public void createUser(User user) {
		userdao.createUser(user);
	}

	
	// Generate result
	@Override
	public void generateResult() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		
	}

	// Delete a user from the system
	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userdao.deleteUser(username);
		
	}

	@Override
	public void updateUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCourse(int courseId) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	

}
