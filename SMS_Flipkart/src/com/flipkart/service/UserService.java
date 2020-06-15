package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

public class UserService implements UserInterface{

	UserDao userdao = new UserDaoImpl();
	
	public void login(User user) throws LoginException {
			
			int roleId;
			userdao.login(user);
			roleId = user.getRoleId();
			
			if(roleId == -1)
			{
				throw new LoginException();
			}
			
	}

}
