package com.flipkart.client;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;

public interface RootClient {
	static Logger logger = Logger.getLogger(UserClient.class);
	default void printCourses(List<Course> courseList)
	{
		String s;
		
		s = "\n===============================================" 
				+ "\n" 
				+ String.format("%-20s", "Id") 
				+ String.format("%-20s","Name")
				+ String.format("%-20s", "Price") 
				+ "\n===============================================";
				
				for(Course course:courseList)
				{
					s = s + "\n" + String.format("%-20s", course.getCourseId()) 
					+ String.format("%-20s", course.getCourseName())
					+ String.format("%-20s", course.getPrice());
				}
				
				logger.info(s);
	}
	
	public void showMenu();
	
	
}
