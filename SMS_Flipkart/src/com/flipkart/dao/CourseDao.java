package com.flipkart.dao;

import com.flipkart.bean.Course;

public interface CourseDao {
	
	public void createCourse(Course course);
	public void deleteCourse(int course_id);
	public void updateCourse(Course course);
}
