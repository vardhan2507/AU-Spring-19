package com.accolite.au.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.au.dao.ItemDao;
import com.accolite.au.model.Item;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.accolite.au.dao.*;

@RestController
@EnableAutoConfiguration
public class ItemController {
	
	ItemDao itemDao;
	
	ItemController() throws ClassNotFoundException, SQLException{
		itemDao=new ItemDaoImpl();
	}
	
	/*
	 * Get All Items
	 * get localhost:8080/items
	 */
	@RequestMapping(value = "/items", method=RequestMethod.GET)
	public ResponseEntity<?> getItems()
	{
		List<Item> items = itemDao.getAllItems();
		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
	}
	
	/*
	 * Get Item =>
     * get localhost:8080/items/{id}
	 */
	@RequestMapping(value = "/items/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getItems(@PathVariable("id")int id)
	{
		Item item =  itemDao.getItem(id);
		if(item != null)
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Not Found",HttpStatus.BAD_REQUEST); 
	}
	
	/*
	 * New Item =>
	 * post localhost:8080/items
	 */
	
	@RequestMapping(value = "/items", method=RequestMethod.POST)
	public ResponseEntity<?> postItems(@RequestBody Item item)
	{
		 String result=itemDao.addItem(item);
		 if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);
		 else
				return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);	
		
			
	}
	
	/*
	 * Update Item =>
	 * post  localhost:8080/item/{id}
	 */
	
	@RequestMapping(value = "/item/{id}", method=RequestMethod.POST)
	public ResponseEntity<?> updateItems(@RequestBody Item item, @PathVariable("id")int id)
	{
		String result = itemDao.updateItem(id, item);
		if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		else
			return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);	
	}

	/*
	 * Remove Item =>
	 * delete  localhost:8080/item/{id}
	 */
	
	@RequestMapping(value = "/item/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteItem(@RequestBody Item item, @PathVariable("id")int id)
	{
		String result = itemDao.removeItem(id, item);
		if(result != null)
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		else
			return new ResponseEntity<String>("Invalid_Id",HttpStatus.BAD_REQUEST);	
	}
	
}
