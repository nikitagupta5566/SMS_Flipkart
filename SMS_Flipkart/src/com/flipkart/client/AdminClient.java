package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminService;
import com.flipkart.service.DateAndTime;

public class AdminClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	// show menu for admin
	public static void showMenu()
	{
		logger.info("============================");
	    logger.info("|        ADMIN MENU        |");
	    logger.info("============================");
	    logger.info("|  1. View all users       |");
	    logger.info("|  2. View all courses     |");
	    logger.info("|  3. Add user             |");
	    logger.info("|  4. Delete User          |");
	    logger.info("|  5. Update User          |");
	    logger.info("|  6. Add Course           |");
	    logger.info("|  7. Delete Course        |");
	    logger.info("|  8. Update Course        |");
	    logger.info("|  9. Generate Report Card |");
	    logger.info("|  10. Exit                |");
	    logger.info("============================");
	}
	
	public void main()
	{
		AdminClient.showMenu();
		AdminInterface admin_operation = new AdminService();
		
		while(true)
		{
			logger.info("****** Enter Choice ******");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					logger.info("Enter type of user to display: student, professor, admin");
					String typeOfUser = sc.next();

					logger.info(admin_operation.viewAllUsers(typeOfUser));
					break;
				case 2:
					logger.info("******** List of Courses ********");
					logger.info(admin_operation.viewAllCourses());

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
					logger.info("Enter Username:");
					admin_operation.updateUser(sc.next());
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
					logger.info("Enter course Id: ");
					admin_operation.updateCourse(sc.nextInt());
					break;
				case 9:
					break;
				case 10:
					logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
					break;
					
			}
		}
	}
}

