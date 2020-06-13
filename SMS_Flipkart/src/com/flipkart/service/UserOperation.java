package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

public class UserOperation implements UserInterface{

	UserDao userdao = new UserDaoImpl();
	
	public String login(User user) throws LoginException {
		
			String role = userdao.login(user);
			
			if(role == null)
			{
				throw new LoginException();
			}
			
			return role;
	}

}
