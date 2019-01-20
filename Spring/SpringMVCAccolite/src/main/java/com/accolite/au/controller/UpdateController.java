package com.accolite.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.au.dao.UpdateUserDao;
import com.accolite.au.dao.UserDao;
import com.accolite.au.model.User;

@Controller
@SessionAttributes("username")
public class UpdateController {
	
	@Autowired
	private UpdateUserDao updateUserDao;
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("username") String username,@RequestParam("username") String userId, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("location") String location) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUsername(userId);
		user.setPassword(password);
		user.setName(name);
		user.setLocation(location);

		updateUserDao.updateUser(user, username);
		
			mv.setViewName("menu");
			
			


		return mv;

	}

}