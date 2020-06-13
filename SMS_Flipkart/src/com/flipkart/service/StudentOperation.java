package com.flipkart.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.client.UserClient;
import com.flipkart.dao.CatalogDao;
import com.flipkart.dao.CatalogDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;

public class StudentOperation implements StudentInterface{
	private static Logger logger = Logger.getLogger(UserClient.class);
	String s;
	@Override
	public String requestCatalog() {
		CatalogDao catalogdao = new CatalogDaoImpl();
		List<Course> catalog = catalogdao.fetchCatalog();
//		String s = "",f= " ";
//		Iterator<Course> i  = catalog.iterator();
		
		catalog.forEach(course -> {
			s = s + course.getCourseid() + "," + course.getCoursename() + "," + course.getCoursedescription();
		});
//		catalog.forEach(System.out::println);
		
//		while(i.hasNext())
//		{
//			course = i.next();
////			logger.debug(course.getCourseid());
//			;
//		}
		
		return s;
	}
	@Override
	public void addCourse(int course_id,int user_id) {
		logger.debug(course_id + " "+ user_id);
		RegistrationDao registrationdao = new RegistrationDaoImpl();
		registrationdao.addCourse(course_id,user_id);
		
	}
	
	
	@Override
	public void dropCourse(int course_id, int user_id) {
		RegistrationDao registrationdao = new RegistrationDaoImpl();
		registrationdao.dropCourse(course_id,user_id);
		
	}
	@Override
	public void payBill() {
		// TODO Auto-generated method stub
		
	}
}


