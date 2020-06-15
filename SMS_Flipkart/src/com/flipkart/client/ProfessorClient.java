package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.service.DateAndTime;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorService;

public class ProfessorClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	ProfessorInterface professor_operation = new ProfessorService();
	
	// show menu for professor
	public void showMenu()
	{
//		logger.info("1. View Courses\n2. Select Course\n3. Record Grades\n4. View Student Details\n5. Exit");
		
		logger.info("============================");
	    logger.info("|      PROFESSOR MENU      |");
	    logger.info("============================");
	    logger.info("|  1. View Courses         |");
	    logger.info("|  2. Select Course        |");
	    logger.info("|  3. Record Grades        |");
	    logger.info("|  4. View Student Details |");
	    logger.info("|  5. Exit                 |");
	    logger.info("============================");
	}
	
	public void main(User user)
	{
		showMenu();
		
		while(true)
		{
			logger.info("Enter Choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					logger.info("*************List of Courses**********");
					logger.info(professor_operation.viewAllCourses());
					break;
				case 2:
					logger.info("Enter Course Id of the course you want to teach: ");
					professor_operation.selectCourse(user.getId(),sc.nextInt());
					break;
				case 3:
					logger.info("Enter Course Id, username of student and grade of student");
					professor_operation.submitGrades(sc.nextInt(),sc.next(),sc.next());
					break;
				case 4:
					logger.info("Enter Course Id:");
					professor_operation.viewEnrolledStudents(sc.nextInt(),user.getId());
					break;
				case 5:
					logger.info("Enter Course Id: ");
					logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );	
			}
		}
	}
}
