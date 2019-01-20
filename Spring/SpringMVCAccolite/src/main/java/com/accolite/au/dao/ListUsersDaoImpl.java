package com.accolite.au.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.au.model.User;

public class ListUsersDaoImpl implements ListUsersDao {

	private JdbcTemplate jdbcTemplate;

	public ListUsersDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	public List<User> listUsers() {
		
		return jdbcTemplate.query("select * from user",new RowMapper<User>(){  
		    public User mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        User u=new User();  
		        u.setUsername(rs.getString(1));
		        u.setName(rs.getString(3));
		        u.setLocation(rs.getString(4));
		        return u;  
		    }  
		    });  
	
	}
}
