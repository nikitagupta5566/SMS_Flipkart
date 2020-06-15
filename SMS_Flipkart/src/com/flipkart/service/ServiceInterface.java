package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;

public interface ServiceInterface {
	
	default public String viewAllCourses() {
		// TODO Auto-generated method stub
		CatalogDao catalogdao = new CatalogDaoImpl();
		String s;
		List<Course> courseList = catalogdao.fetchCatalog();
		s = "\n===============================================" 
		+ "\n" 
		+ String.format("%-20s", "Id") 
		+ String.format("%-20s","Name")
		+ String.format("%-20s", "Price") 
		+ "\n===============================================";
		
//		courseList.forEach(course -> {
//			s = s + "\n" + String.format("%-20s", course.getCourseid()) 
//					+ String.format("%-20s", course.getCoursename())
//					+ String.format("%-20s", course.getPrice());
//			
//		});
		
		for(Course course:courseList)
		{
			s = s + "\n" + String.format("%-20s", course.getCourseid()) 
			+ String.format("%-20s", course.getCoursename())
			+ String.format("%-20s", course.getPrice());
		}
		
		return s;
		
	}
	
	default public void exit()
	{
		
	}
}
