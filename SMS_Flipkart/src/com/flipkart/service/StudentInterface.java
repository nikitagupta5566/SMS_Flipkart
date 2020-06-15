package com.flipkart.service;

public interface StudentInterface extends ServiceInterface{
	public void addCourse(int courseId,int userId);
	public void dropCourse(int courseId,int userId);
	public void payBill();
	public void register(int userId,int modeId) ;
	public void viewReportCard();
	public String viewEnrolledCourses(int userId);
}
