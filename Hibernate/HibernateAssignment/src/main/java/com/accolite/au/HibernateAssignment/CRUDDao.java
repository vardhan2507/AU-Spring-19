package com.accolite.au.HibernateAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.model.Item;
import com.accolite.au.model.Person;
import com.accolite.au.util.HibernateUtil;

public class CRUDDao {

	public static void main(String args[]) {
		// Creating Session Factory Object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// =================================================================================================

		
		
		
		/*
		 * CRUD operations
		 */
		
		session.beginTransaction();
		
		//create
		Item item =new Item();
		item.setName("Dell Laptop");
		session.save(item);
		
		///request
		Item receivedItem=session.get(Item.class, 1);
		
		//update
		receivedItem.setName("Asus Laptop");
		session.save(receivedItem);
		
		//delete
		session.delete(receivedItem);
		
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
