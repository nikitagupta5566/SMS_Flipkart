package com.flipkart.client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminService;
import com.flipkart.service.DateAndTime;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorService;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserService;
import com.flipkart.exception.LoginException;

public class UserClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)  {
//		logger.setUseParentHandlers(false);
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserInterface userOperation = new UserService();
		
		String username = null;
		String password=null;
		String role=null;
		User user=null;
		
		System.out.println("hello");
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
			AdminClient adminClient = new AdminClient();
			adminClient.main();
		}
		else if(role.equals("student"))
		{
			StudentClient studentClient = new StudentClient();
			studentClient.main(user);
		}
		else if(role.equals("professor"))
		{
			ProfessorClient professorClient = new ProfessorClient();
			professorClient.main(user);
		}
		
		
	}

}
