package com.flipkart.constant;

public class SQLConstantQueries {
	public static final String USER_LOGIN = "select id,username,password,role from user where username = ? and password = ?";
	public static final String SELECT_ALL_USERS = "select * from user";
	public static final String SELECT_ALL_COURSES = "select * from course";
	public static final String ADD_COURSE = "insert into registration(userid,courseid,registration_date) values(?,?,?)";
	public static final String DROP_COURSE = "delete from registration where userid = ? and courseid = ?";
	public static final String CREATE_COURSE = "insert into course values(?,?,?)";
	public static final String DELETE_COURSE = "delete from course where id = ?";
	public static final String CREATE_USER = "insert into user(username,password,role,gender) values (?,?,?,?)";
	public static final String DELETE_USER = "delete from user where username = ?";
}
