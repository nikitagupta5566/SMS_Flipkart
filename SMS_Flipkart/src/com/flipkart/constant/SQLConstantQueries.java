package com.flipkart.constant;

public class SQLConstantQueries {
	public static final String USER_LOGIN = "select id,username,password,role from user where username = ? and password = ?";
	public static final String SELECT_ALL_USERS = "select id from user";
	public static final String SELECT_ALL_COURSES = "select * from course";
}
