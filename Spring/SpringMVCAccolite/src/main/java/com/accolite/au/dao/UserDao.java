package com.accolite.au.dao;

import com.accolite.au.model.User;

public interface UserDao {
	
	public int registerUser(User user);

	public String loginUser(User user);

}
