package com.accolite.au.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	 @RequestMapping(value="/logout",method = RequestMethod.POST)
	 public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		   ModelAndView view = new ModelAndView("login");
		   request.getSession().invalidate();
		   return view;
		 }      
}
