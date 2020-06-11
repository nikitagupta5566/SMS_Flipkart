package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;

public class StudentOperation implements StudentInterface{
	private static Logger logger = Logger.getLogger(UserClient.class);
	@Override
	public String requestCatalog() {
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
	}
	@Override
	public void addCourse() {
		
		
	}

}
