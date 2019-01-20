package com.accolite.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.au.dao.UserDao;
import com.accolite.au.model.User;

@Controller
public class UserRegistrataionController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("name") String name, 
			@RequestParam("location") String location) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setLocation(location);

		int counter = userDao.registerUser(user);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("login");

		return mv;

	}

}
