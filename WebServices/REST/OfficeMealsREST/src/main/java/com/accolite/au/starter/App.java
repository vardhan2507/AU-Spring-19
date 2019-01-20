package com.accolite.au.starter;


import org.springframework.boot.SpringApplication;

import com.accolite.au.controller.ItemController;

public class App {

	 public static void main( String[] args )
	    {
	    	SpringApplication.run(ItemController.class, args);
	    }
}
