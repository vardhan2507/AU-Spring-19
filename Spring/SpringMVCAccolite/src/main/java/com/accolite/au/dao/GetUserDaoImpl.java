package com.accolite.au.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.au.model.User;

public class GetUserDaoImpl implements GetUserDao{

	
	private JdbcTemplate jdbcTemplate;

	public GetUserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	public User getUserDetails(String username) {
		// TODO Auto-generated method stub
		List<User> user=jdbcTemplate.query("select * from user where username='"+username+"'",new RowMapper<User>(){  
		    public User mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        User u=new User();  
		        u.setUsername(rs.getString(1));
		        u.setPassword(rs.getString(2));
		        u.setName(rs.getString(3));
		        u.setLocation(rs.getString(4));
		        return u;  
		    }  
		    });  
		
		return user.get(0);
		}
		
	}