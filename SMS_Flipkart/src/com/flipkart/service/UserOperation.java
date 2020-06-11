package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class UserOperation implements UserInterface{

	
	UserDao userdao = new UserDaoImpl();
	public String login(User user) {
		try
		{
			return userdao.login(user);
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
