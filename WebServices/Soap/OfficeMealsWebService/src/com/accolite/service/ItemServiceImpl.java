package com.accolite.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.accolite.beans.Item;

@WebService(endpointInterface = "com.accolite.service.ItemService")
public class ItemServiceImpl implements ItemService{
	
	private static Map<Integer,Item> items = new HashMap<Integer,Item>();

	@Override
	public boolean addItem(Item i) {
		// TODO Auto-generated method stub
		if(items.get(i.getId()) != null) return false;
		items.put(i.getId(), i);
		return true;
		
	}

	@Override
	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		if(items.get(id) == null) return false;
		items.remove(id);
		return true;
		
	}

	@Override
	public Item getItem(int id) {
		// TODO Auto-generated method stub
		return items.get(id);
		
	}

	@Override
	public Item[] getAllItems() {
		// TODO Auto-generated method stub
		Set<Integer> ids = items.keySet();
		Item[] i = new Item[ids.size()];
		int j=0;
		for(Integer id : ids){
			i[j] = items.get(id);
			j++;
		}
		return i;
		
	}

	

}
