package com.accolite.au.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.au.model.User;

public class UpdateUserDaoImpl implements UpdateUserDao{
	
	private JdbcTemplate jdbcTemplate;

	public UpdateUserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	

	public void updateUser(User user, String username) {
		// TODO Auto-generated method stub
		String sql = "UPDATE USER SET USERNAME=?, PASSWORD=?, NAME=?, LOCATION=? WHERE USERNAME='"+username+"'";

		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getName(), user.getLocation() });

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
