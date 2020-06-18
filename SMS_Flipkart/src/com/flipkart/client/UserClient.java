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
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserInterface userOperation = new UserService();
		
		String username = null;
		String password=null;
		
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
				
				userOperation.login(user);
				break;
			}
			catch(LoginException e)
			{
				logger.error(e.getMessage());
			}
		}
		
		
		logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged in as " + username);
		
		if(user.getRoleId() == 1)
		{
			AdminClient adminClient = new AdminClient();
			adminClient.main(user);
		}
		else if(user.getRoleId() == 2)
		{
			StudentClient studentClient = new StudentClient();
			studentClient.main(user);
		}
		else if(user.getRoleId() == 3)
		{
			ProfessorClient professorClient = new ProfessorClient();
			professorClient.main(user);
		}
		
		
	}

}
