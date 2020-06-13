package com.flipkart.service;

public interface StudentInterface {
	String requestCatalog();
	public void addCourse(int course_id,int user_id);
	public void dropCourse(int course_id,int user_id);
	public void payBill();

}
