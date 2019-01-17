package com.accolite.endpoint;

import javax.xml.ws.Endpoint;

import com.accolite.service.ItemServiceImpl;


public class ItemServicePublisher {

	
	public static void main(String[] args) {
		   Endpoint.publish("http://localhost:9999/service/item", new ItemServiceImpl());
	    }
}
