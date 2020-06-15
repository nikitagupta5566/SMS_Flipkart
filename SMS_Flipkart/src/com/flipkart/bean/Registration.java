package com.flipkart.bean;

import java.util.Date;
import java.time.LocalDate;

public class Registration {
	LocalDate registration_date;
	int registration_id;
	int student_id;
	int course_id;
	
	public LocalDate getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(LocalDate registration_date) {
		this.registration_date = registration_date;
	}
	public int getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(int registration_id) {
		this.registration_id = registration_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
}
