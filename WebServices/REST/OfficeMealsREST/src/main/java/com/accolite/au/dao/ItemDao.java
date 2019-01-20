package com.accolite.au.dao;

import java.util.List;

import com.accolite.au.model.Item;

public interface ItemDao {
	
	public String addItem(Item item);
	public  Item getItem(int id);
	public String updateItem(int id, Item item);
	public String removeItem(int id, Item item);
	public List<Item> getAllItems();
	
}
