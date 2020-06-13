package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;

public class ProfessorOperation implements ProfessorInterface{

	@Override
	public void submitGrades() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewStudentDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String viewCourses() {
		CatalogDao catalogdao = new CatalogDaoImpl();
		
		List<Course> catalog = catalogdao.fetchCatalog();
		String s = "";
		Iterator<Course> i  = catalog.iterator();
		Course course;
		
		while(i.hasNext())
		{
			course = i.next();
//			logger.debug(course.getCourseid());
			s = s + course.getCourseid() + "," + course.getCoursename() + "," + course.getCoursedescription();
		}
		
		return s;
		
		// TODO Auto-generated method stub
		
	}

}
