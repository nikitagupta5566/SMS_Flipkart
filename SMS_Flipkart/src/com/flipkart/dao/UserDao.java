package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.User;

public interface UserDao {
	public String login(User user);
	public void createUser(User user);
	public void deleteUser(String username);
	public List<User> fetchUsers();
}
