package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;

public interface UserDao {
	public void login(User user);
	public void createUser(User user,String role);
	public void deleteUser(String username);
	public List<User> fetchUsers();
}
