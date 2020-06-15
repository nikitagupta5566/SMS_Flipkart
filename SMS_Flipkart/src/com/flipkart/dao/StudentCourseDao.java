package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface StudentCourseDao {
	public void addCourse(int courseId,int userId);
	public void dropCourse(int courseId,int userId);
	public List<User> getEnrolledStudents(int courseId);
	public void submitGrades(int courseId, String username, String grade);
	public List<Course> getEnrolledCourses(int userId);
	public void generateReportCard(int userId);
}
