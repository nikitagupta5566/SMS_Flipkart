package com.flipkart.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.client.UserClient;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.RoleDao;
import com.flipkart.dao.RoleDaoImpl;
import com.flipkart.dao.StudentCourseDao;
import com.flipkart.dao.StudentCourseDaoImpl;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class AdminService implements AdminInterface{
	UserDao userDao = new UserDaoImpl();
	CourseDao courseDao = new CourseDaoImpl();
	RoleDao roleDao = new RoleDaoImpl();
	StudentDao studentDao = new StudentDaoImpl();
	ProfessorDao professorDao = new ProfessorDaoImpl();
	AdminDao adminDao = new AdminDaoImpl();
	StudentCourseDao studentCourseDao = new StudentCourseDaoImpl();
	String s = "";
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	// View all users filtered by role of user 
	@Override
	public String viewAllUsers(String typeOfUser) {
		// TODO Auto-generated method stub
		
		String userList = "\n=========================================================" + String.format("%-15s", "\nUserID")
		+ String.format("%-15s", "Name")+ String.format("%-15s", "Username") + String.format("%-15s", "Date Of Birth") + "\n=========================================================" ;
		
		if(typeOfUser.equals("student"))
		{
			List<Student> studentList = studentDao.fetchStudents();
			logger.debug(studentList.size());
			userList = userList + studentList.stream().flatMap(user -> Stream.of(
					String.format("\n%-15s", user.getId())
					,user.getGender().equals("male") ? String.format("%-15s", "Mr.".concat(user.getName())): String.format("%-15s", "Miss.".concat(user.getName()))
					,String.format("%-15s", user.getUsername())
					,String.format("%-15s", user.getDateOfBirth()))).
			collect(Collectors.joining(""));
		}
		else if(typeOfUser.equals("professor"))
		{
			List<Professor> professorList = professorDao.fetchProfessors();
			
			userList = userList + professorList.stream().flatMap(user -> Stream.of(
					String.format("\n%-15s", user.getId())
					,user.getGender().equals("male") ? String.format("%-15s", "Mr.".concat(user.getName())): String.format("%-15s", "Miss.".concat(user.getName()))
					,String.format("%-15s", user.getUsername())
					,String.format("%-15s", user.getDateOfBirth()))).
			collect(Collectors.joining(""));
		}
		else if(typeOfUser.equals("admin"))
		{
			List<Admin> adminList = adminDao.fetchAdmin();
			
			userList = userList + adminList.stream().flatMap(user -> Stream.of(
					String.format("\n%-15s", user.getId())
					,user.getGender().equals("male") ? String.format("%-15s", "Mr.".concat(user.getName())): String.format("%-15s", "Miss.".concat(user.getName()))
					,String.format("%-15s", user.getUsername())
					,String.format("%-15s", user.getDateOfBirth()))).
			collect(Collectors.joining(""));
		}
		
		return userList;
	}
	
	// Add a new Course to the catalog
	@Override
	public void createCourse(Course course) {
		courseDao.createCourse(course);
		// TODO Auto-generated method stub
		
	}
	
	// Delete a course from catalog
	@Override
	public void deleteCourse(int course_id) {
		courseDao.deleteCourse(course_id);
	}

	// Add a new user
	@Override
	public void createUser(User user,String role) {
		userDao.createUser(user,role);
	}
	
	// Create student credentials and add student details
	public void createStudent(User user,Student student)
	{
		userDao.createUser(user,"student");
		student.setUsername(user.getUsername());
		studentDao.createStudent(student);
	}
	
	// Create professor credentials and add professor details
	public void createProfessor(User user,Professor professor)
	{
		userDao.createUser(user, "professor");
		professor.setUsername(user.getUsername());
		professorDao.createProfessor(professor);
	}
	
	// Create admin credentials and add admin details
	public void createAdmin(User user,Admin admin)
	{
		userDao.createUser(user, "admin");
		admin.setUsername(user.getUsername());
		adminDao.createAdmin(admin);
	}

	
	// View Report card of any student
	@Override
	public HashMap<Course, String> generateReportCard(int userId) {
		// TODO Auto-generated method stub
		HashMap<Course, String> gradeList= studentCourseDao.generateReportCard(userId);
		return gradeList;
	}

	// Delete a user from the system
	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userDao.deleteUser(username);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		int roleId = user.getRoleId();
		if(roleId == 1)
		{
			adminDao.updateAdmin();
		}
		else if(roleId == 2)
		{
//			studentDao.updateStudent();
		}
		else
		{
//			professorDao.updateProfessor();
		}
		
	}

	// Update course details
	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.updateCourse(course);
		
	}


	

	
	

	

	
	
	

}
