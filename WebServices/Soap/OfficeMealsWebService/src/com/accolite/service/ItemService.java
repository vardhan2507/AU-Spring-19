package com.accolite.service;

import com.accolite.beans.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ItemService {
	
	@WebMethod
	public boolean addItem(Item i);
	
	@WebMethod
	public boolean deleteItem(int id);
	
	@WebMethod
	public Item getItem(int id);
	
	@WebMethod
	public Item[] getAllItems();

}
