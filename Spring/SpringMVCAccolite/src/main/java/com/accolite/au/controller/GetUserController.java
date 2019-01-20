package com.accolite.au.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accolite.au.dao.GetUserDao;
import com.accolite.au.dao.GetUserDaoImpl;
import com.accolite.au.dao.UserDao;
import com.accolite.au.model.User;

@Controller
@SessionAttributes("username")
public class GetUserController {
	
	@Autowired
	private GetUserDao getUserDao;
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("username") String username) {

		ModelAndView mv = new ModelAndView();
		
		User user=null;

		user = getUserDao.getUserDetails(username);

		if (user != null) {

			mv.setViewName("profile");
			mv.addObject("user",user);
			

		} else {

			mv.setViewName("login");
			mv.addObject("msg", "No user to display");
			
		}

		return mv;

	}

}
