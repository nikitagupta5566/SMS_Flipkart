package com.flipkart.client;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminService;
import com.flipkart.service.DateAndTime;

public class AdminClient implements RootClient{
	private static Logger logger = Logger.getLogger(UserClient.class);
	Scanner sc = new Scanner(System.in);
	String s = "";
	// show menu for admin
	public void showMenu()
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
	
	public void main(User user)
	{
		showMenu();
		AdminInterface adminOperation = new AdminService();
		Course course;
		
		while(true)
		{
			logger.info("****** Enter Choice ******");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					logger.info("Enter type of user to display: student, professor, admin");
					String typeOfUser = sc.next();
					
					logger.info(adminOperation.viewAllUsers(typeOfUser));
					break;
				case 2:
					logger.info("******** List of Courses ********");
					printCourses(adminOperation.viewAllCourses());
					
					break;
				case 3:
					User newUser = new User();
					logger.info("Enter Username, UserPassword, UserRole");
					newUser.setUsername(sc.next());
					newUser.setPassword(sc.next());
					String role = sc.next();
					
					if(role.equals("student"))
					{
						Student student = getStudentDetails();
						adminOperation.createStudent(newUser,student);
					}
					else if(role.equals("professor"))
					{
						Professor professor = getProfessorDetails();
						adminOperation.createProfessor(newUser,professor);
					}
					else if(role.equals("admin"))
					{
						Admin admin = getAdminDetails();
						adminOperation.createAdmin(newUser,admin);
					}
					
					break;
				case 4:
					logger.info("Enter username:");
					adminOperation.deleteUser(sc.next());
					break;
				case 5:
					logger.info("Enter Username:");
					
//					admin_operation.updateUser(sc.next());
					break;
				case 6:
					course = new Course();
					logger.info("Enter Course Id, Course Name and Course Description and Course Price");
					course.setCourseId(sc.nextInt());
					course.setCourseName(sc.next());
					course.setCourseDescription(sc.next());
					course.setPrice(sc.nextFloat());
					adminOperation.createCourse(course);
					break;
				case 7:
					logger.info("Enter Course Id:");
					adminOperation.deleteCourse(sc.nextInt());
					break;
				case 8:
					course = new Course();
					logger.info("Enter course Id of the course you want to update: ");
					course.setCourseId(sc.nextInt());
					logger.info("Enter Name, Price and description of course: ");
					course.setCourseName(sc.next());
					course.setPrice(sc.nextFloat());
					course.setCourseDescription(sc.next());
					adminOperation.updateCourse(course);
					break;
				case 9:
					logger.info("Enter userId of the user:");
					printReportCard(adminOperation.generateReportCard(sc.nextInt()));
					
					break;
				case 10:
					logger.info(DateAndTime.getCurrentDate() + "  " + DateAndTime.getCurrentTime() + " " + DateAndTime.getDayOfWeek() + ": Successfully logged out" );
					break;
					
			}
		}
	}
	
	
	public Student getStudentDetails()
	{
		Student student = new Student();
		
		logger.info("Enter name,gender and DOB:");
		student.setName(sc.next());
		student.setGender(sc.next());
		student.setDateOfBirth(Date.valueOf(sc.next()));
		
		return student;
	}
	
	public Professor getProfessorDetails()
	{
		Professor professor = new Professor();
		
		logger.info("Enter name,gender and DOB:");
		professor.setName(sc.next());
		professor.setGender(sc.next());
		professor.setDateOfBirth(Date.valueOf(sc.next()));
		return professor;
	}
	
	public Admin getAdminDetails()
	{
		Admin admin = new Admin();
		
		logger.info("Enter name,gender and DOB:");
		admin.setName(sc.next());
		admin.setGender(sc.next());
		admin.setDateOfBirth(Date.valueOf(sc.next()));
		
		return admin;
	}
	
	void printReportCard(HashMap<Course,String> gradeList)
	{
		s = "\n===============================================" 
				+ "\n" 
				+ String.format("%-20s", "CourseId:") 
				+ String.format("%-20s","Course Name:") 
				+ String.format("%-20s", "Grade")
				+ "\n===============================================";
		
		gradeList.forEach((course,grade) -> {
			if(grade == null)
			{
				logger.info(grade == null ? "Not upd": grade);;
			}
			s = s + String.format("\n%-20s", course.getCourseId()) 
			+ String.format("%-20s",course.getCourseName())
			+ String.format("%-20s", grade == null ? "Not updated yet": grade);
		});
		
		logger.info(s);
	}
}

