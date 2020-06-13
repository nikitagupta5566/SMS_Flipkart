package com.flipkart.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class AdminOperation implements AdminInterface{
	UserDao userdao = new UserDaoImpl();
	CourseDao coursedao = new CourseDaoImpl();
	
	@Override
	public String viewAllUsers(String typeOfUser) {
		// TODO Auto-generated method stub 
		List<User>userList = userdao.fetchUsers();
		System.out.println(userList.size());
		//		userList.stream().flatMap(user -> Stream.of(user.getUsername(), user.getPassword()));.filter(user -> user.getRole() == "student")
		String userList1 = userList.stream().filter(user -> user.getRole().equals(typeOfUser)).flatMap(user -> Stream.of(user.getGender().equals("male") ? "\nMr.".concat(user.getUsername()):"\nMiss.".concat(user.getUsername()), user.getPassword(), user.getRole())).collect(Collectors.joining("     "));
		
		System.out.println(userList1);
		return null;
	}
	
	@Override
	public void createCourse(Course course) {
		coursedao.createCourse(course);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteCourse(int course_id) {
		coursedao.deleteCourse(course_id);
	}

	@Override
	public void createUser(User user) {
		userdao.createUser(user);
	}

	@Override
	public void generateResult() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userdao.deleteUser(username);
		
	}

	

	
	
	

}
