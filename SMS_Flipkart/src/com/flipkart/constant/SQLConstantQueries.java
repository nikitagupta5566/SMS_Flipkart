package com.flipkart.constant;

public class SQLConstantQueries {
	public static final String USER_LOGIN = "select * from user where username = ? and password = ?";
	public static final String SELECT_ALL_USERS = "select * from user";
	public static final String SELECT_ALL_COURSES = "select * from course";
	public static final String ADD_COURSE = "insert into student_course(userid,courseid,date) values(?,?,?)";
	public static final String DROP_COURSE = "delete from student_course where userid = ? and courseid = ?";
	public static final String CREATE_COURSE = "insert into course values(?,?,?)";
	public static final String DELETE_COURSE = "delete from course where id = ?";
	public static final String CREATE_USER = "insert into user(username,password,role,gender) values (?,?,?,?)";
	public static final String DELETE_USER = "delete from user where username = ?";
	public static final String REGISTER_COURSE = "insert into registration(userId,date,paymentId) values(?,?,?)";
	public static final String CHECK_REGISTRATION = "select userId from registration where userId = ?";
	public static final String SELECT_COURSE_TO_TEACH = "insert into professor_course(user_id,course_id) values(?,?)";
	public static final String GET_PROFESSOR_COURSE ="select * from professor_course where course_id = ?";
	public static final String GET_ENROLLED_STUDENTS = "select * from student_course join user on student_course.userid = user.id where courseid = ?";
	public static final String SUBMIT_GRADES = "update student_course set grade = ? where userid = (select userid from user where user.username = ?) and courseid = ?";
	public static final String GET_ENROLLED_COURSES = "select * from student_course join course on student_course.courseid = course.id where userid = ?";
	public static final String GENERATE_REPORT_CARD = "select * from student_course where userId = ?";
	public static final String GET_ROLE_NAME = "select name from role where roleId = ?";
	public static final String GET_ROLE_ID = "select roleId from role where name = ?";
}
