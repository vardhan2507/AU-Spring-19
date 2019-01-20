package com.accolite.au.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.accolite.au.dao.ListUsersDao;
import com.accolite.au.model.User;

@Controller
public class ListAllUsersController {

	@Autowired
	private ListUsersDao listUsers;
	
	@RequestMapping(value = "/listusers", method = RequestMethod.POST)
	public ModelAndView displayAllUsers() {
		ModelAndView mv = new ModelAndView();

		List<User> users=null;

		users = listUsers.listUsers();

		if (users != null) {

			mv.setViewName("users");
			mv.addObject("users",users);
			

		} else {

			mv.setViewName("login");
			mv.addObject("msg", "No users to display");
			
		}

		return mv;

	}
	
}
