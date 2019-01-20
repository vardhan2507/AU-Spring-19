package com.accolite.au.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.au.model.User;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public int registerUser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USER VALUES(?,?,?,?)";

		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getName(), user.getLocation() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public String loginUser(User user) {
		// TODO Auto-generated method stub
String sql = "SELECT USERNAME FROM USER WHERE USERNAME=? AND PASSWORD=?";
		
		List<String> users = jdbcTemplate.queryForList(sql, new Object[] { user.getUsername(), user.getPassword() },String.class);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
