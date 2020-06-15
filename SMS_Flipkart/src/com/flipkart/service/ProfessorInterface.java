package com.flipkart.service;

public interface ProfessorInterface extends ServiceInterface{
	public void submitGrades(int courseId, String username,String grade);
	public void viewEnrolledStudents(int courseId,int usesId);
	public void selectCourse(int userId,int courseId);
}
