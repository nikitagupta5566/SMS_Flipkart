package com.flipkart.bean;

public class Course {
	String coursename;
	int courseid;
	String coursedescription;
	Float price;
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursedescription() {
		return coursedescription;
	}
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
}
