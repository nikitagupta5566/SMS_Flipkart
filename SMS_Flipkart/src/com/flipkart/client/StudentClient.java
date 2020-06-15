package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.service.DateAndTime;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;

public class StudentClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	
	// shows menu for student
	public static void showMenu()
	{
		logger.info("============================");
		logger.info("|        STUDENT MENU       |");
		logger.info("============================");
	    logger.info("|  1. Request Catalog       |");
	    logger.info("|  2. Add Course            |");
	    logger.info("|  3. Drop Course           |");
	    logger.info("|  4. Regiser               |");
	    logger.info("|  5. Update Profile        |");
	    logger.info("|  6. View Enrolled Courses |");
	    logger.info("|  7. View Report Card      |");
	    logger.info("|  8. Exit                  |");
	    logger.info("============================");
	}
	
	public void main(User user)
	{
		StudentClient.showMenu();
		
		StudentInterface studentOperation = new StudentOperation();
		int courseId;
		
		while(true)
		{
			logger.info("Enter Choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					logger.info("*************List of Courses**********");
					logger.info(studentOperation.viewAllCourses());
					break;
				case 2:
					logger.info("Enter course_id:");
					courseId = sc.nextInt();
					studentOperation.addCourse(courseId,user.getId());
					break;
				case 3:
					logger.info("Enter course_id:");
					courseId = sc.nextInt();
					studentOperation.dropCourse(courseId,user.getId());
					break;
				case 4:
					logger.info("Note: After completing registration, you would not be able to add/drop courses");
					logger.info("Do you want to proceed(y/n)");
					if(sc.next().equals("y"))
					{
						logger.info("Select Mode of Payment:");
						logger.info("Credit Card");
						logger.info("Debit Card");
						logger.info("Cash");
						studentOperation.register(user.getId(),sc.nextInt());
					}
					
					break;
				case 5:
					studentOperation.payBill();
					break;
				case 6:
					logger.info(studentOperation.viewEnrolledCourses(user.getId()));
				case 7:
					studentOperation.viewReportCard();
					break;
				case 8:
					logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
			}
		}
	}
	
}
