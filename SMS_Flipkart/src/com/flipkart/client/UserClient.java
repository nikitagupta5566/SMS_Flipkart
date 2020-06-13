package com.flipkart.client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.DateAndTime;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;
import com.flipkart.exception.LoginException;

public class UserClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserInterface userOperation = new UserOperation();
		
		String username = null;
		String password=null;
		String role=null;
		User user=null;
		
		logger.info("***********Welcome To Student Management System***********");
		while(true)
		{
			try
			{
				logger.info("Enter username");
				username = sc.next();
				
				logger.info("Enter password");
				password = sc.next();
				
				user = new User();
				user.setPassword(password);
				user.setUsername(username);
				
				role = userOperation.login(user);
				break;
			}
			catch(LoginException e)
			{
				logger.error(e.getMessage());
			}
		}
		
		
		
		logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged in as " + username);
		
		if(role.equals("admin"))
		{
			logger.info("\n1. View all users\n2. View all courses\n3. Add user\n4. Delete User\n5. Update User\n6. Add Course\n7. Delete Course\n8. Update Course \n9. Generate Report Card\n10.Exit ");
			AdminInterface admin_operation = new AdminOperation();
			while(true)
			{
				logger.info("Enter Choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						logger.info("Enter type of user to display: student, professor, admin");
						String typeOfUser = sc.next();
						admin_operation.viewAllUsers(typeOfUser);
						break;
					case 2:
						break;
					case 3:
						User new_user = new User();
						logger.info("Enter Username, UserPassword and UserRole and Gender");
						new_user.setUsername(sc.next());
						new_user.setPassword(sc.next());
						new_user.setRole(sc.next());
						new_user.setGender(sc.next());
						
						admin_operation.createUser(new_user);
						break;
					case 4:
						logger.info("Enter username:");
						admin_operation.deleteUser(sc.next());
						break;
					case 5:
						break;
					case 6:
						Course course = new Course();
						logger.info("Enter Course Id, Course Name and Course Description ");
						course.setCourseid(sc.nextInt());
						course.setCoursename(sc.next());
						course.setCoursedescription(sc.next());
						admin_operation.createCourse(course);
						break;
					case 7:
						logger.info("Enter Course Id:");
						admin_operation.deleteCourse(sc.nextInt());
						break;
					case 8:
						break;
					case 9:
						break;
					case 10:
						logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
						break;
						
				}
			}
			
			
//			AdminInterface admininterface = new AdminOperation();
		}
		else if(role.equals("student"))
		{
			StudentInterface student_interface = new StudentOperation();
			logger.info("1. Request Catalog\n2. Add Course\n3. Drop Course\n4. Pay Bill\n6. View Report Card \n7.Exit");
			int course_id;
			
			while(true)
			{
				logger.info("Enter Choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						String course_catalog = student_interface.requestCatalog();
						logger.info(course_catalog);
						break;
					case 2:
						logger.info("Enter course_id:");
						course_id = sc.nextInt();
//						logger.debug(user.getId()+" "+user.getUsername());
						student_interface.addCourse(course_id,user.getId());
						break;
					case 3:
						logger.info("Enter course_id:");
						course_id = sc.nextInt();
						student_interface.dropCourse(course_id,user.getId());
						break;
					case 4:
						student_interface.payBill();
						break;
					case 5:
						break;
					case 6:
						
						break;
					case 7:
						logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
						
						
				}
			}
		}
		else if(role.equals("professor"))
		{
			logger.info("1. View Courses\n2. Select Course\n3. Record Grades\n4. View Student Details\n5. Exit");
			ProfessorInterface professor_operation = new ProfessorOperation();
			while(true)
			{
				logger.info("Enter Choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						professor_operation.viewCourses();
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
					
						
				}
			}
		}
		
		
	}

}
