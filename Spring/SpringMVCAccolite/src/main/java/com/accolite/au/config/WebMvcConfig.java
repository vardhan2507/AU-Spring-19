package com.accolite.au.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.accolite.au.dao.GetUserDao;
import com.accolite.au.dao.GetUserDaoImpl;
import com.accolite.au.dao.ListUsersDao;
import com.accolite.au.dao.ListUsersDaoImpl;
import com.accolite.au.dao.UpdateUserDao;
import com.accolite.au.dao.UpdateUserDaoImpl;
import com.accolite.au.dao.UserDao;
import com.accolite.au.dao.UserDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan("com.accolite.au")
public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;

	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/vardhan");
		ds.setUsername("vardhan");
		ds.setPassword("vardhan");

		return ds;

	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl(getDataSource());
	}
	
	@Bean
	public ListUsersDao getListUsersDao() {
		return new ListUsersDaoImpl(getDataSource());
	}
	
	@Bean
	public GetUserDao getGetUserDao() {
		return new GetUserDaoImpl(getDataSource());
	}
	
	@Bean
	public UpdateUserDao getUpdateUserDao() {
		return new UpdateUserDaoImpl(getDataSource());
	}
	
}
