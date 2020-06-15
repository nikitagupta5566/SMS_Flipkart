package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.exception.RegistrationCompletedException;

public interface RegistrationDao {
	
	public void register(int userId,int modeId);
	public void checkRegistration(int userId) throws RegistrationCompletedException;
	
}
