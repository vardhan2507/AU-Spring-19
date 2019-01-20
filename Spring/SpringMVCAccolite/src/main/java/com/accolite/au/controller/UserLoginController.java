package com.accolite.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.au.dao.UserDao;
import com.accolite.au.model.User;

@Controller
@SessionAttributes("username")
public class UserLoginController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		String name = userDao.loginUser(user);

		if (name != null) {

			mv.setViewName("menu");
			mv.addObject("currentUser",username);
			

		} else {

			mv.setViewName("login");
			mv.addObject("msg", "Invalid user id or password.");
			
		}

		return mv;

	}
	
	@ModelAttribute("username")
	public String getUsername(String username) {
		return username;
	}

}
