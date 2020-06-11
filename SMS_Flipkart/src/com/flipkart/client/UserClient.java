package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

public class UserClient {
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		UserInterface user_interface = new UserOperation();
		
		String username;
		String password;
		
		logger.info("Enter username");
		username = sc.next();
		
		logger.info("Enter password");
		password = sc.next();
		
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		
		String role = user_interface.login(user);
		
		if(role.equals("admin"))
		{
			logger.info("1. Add user\n2. Delete User\n3. Update User\n4. Add Course\n5. Delete Course\n6. Update Course \n7. Generate Report Card ");
			
			while(true)
			{
				logger.info("Enter Choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
						
				}
			}
			
			
//			AdminInterface admininterface = new AdminOperation();
		}
		else if(role.equals("student"))
		{
			StudentInterface student_interface = new StudentOperation();
			logger.info("1. Request Catalog\n2. Add Course\n3. Drop Course\n4. Pay Bill\n6. View Report Card ");
			
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
						
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
						
				}
			}
		}
		else
		{
			logger.info("1. View Courses\n2. Select Course\n3. Record Grades\n4. View Student Details");
			
			while(true)
			{
				logger.info("Enter Choice");
				int choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					
						
				}
			}
		}
		
		
	}

}
