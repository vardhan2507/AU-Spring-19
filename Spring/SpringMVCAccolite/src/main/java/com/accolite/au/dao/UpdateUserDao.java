package com.accolite.au.dao;

import com.accolite.au.model.User;

public interface UpdateUserDao {
	
	void updateUser(User user, String username);

}