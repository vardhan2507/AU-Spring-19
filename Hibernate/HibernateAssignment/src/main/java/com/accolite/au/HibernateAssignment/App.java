package com.accolite.au.HibernateAssignment;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.model.Address;
import com.accolite.au.model.Contract_Employee;
import com.accolite.au.model.Customer;
import com.accolite.au.model.Employee;
import com.accolite.au.model.Item;
import com.accolite.au.model.Person;
import com.accolite.au.model.Regular_Employee;
import com.accolite.au.model.Supplier;
import com.accolite.au.model.Vehicle;
import com.accolite.au.model.Worker;
import com.accolite.au.util.HibernateUtil;

/**
 * Contains various demos of hibernate framework concepts
 *
 */
public class App {
	public static void main(String[] args) {

		// Creating Session Factory Object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// =================================================================================================

		/*
		 * 1) Saving Objects using Hibernate
		 */

		session.beginTransaction();
		Person savePerson = new Person();
		savePerson.setName("Vardhan");
		session.save(savePerson);
		session.getTransaction().commit();
		session.close();

		// =================================================================================================

		/*
		 * 2) Retrieving Objects using session
		 */

		session = sessionFactory.openSession();
		session.beginTransaction();
		Person getPerson = session.get(Person.class, 1);
		// System.out.println("Person " + getPerson.getName());
		session.getTransaction().commit();
		session.close();

		// ================================================================================================

		/*
		 * 3) Primary Keys
		 * 
		 * Ans)
		 * 
		 * @Id
		 * 
		 * @GeneratedValue(strategy = GenerationType.IDENTITY)
		 * 
		 * @Column(name = "id", updatable = false, nullable = false) private Long id;
		 */

		// ==================================================================================================

		/*
		 * 4) Value Types
		 * 
		 * Address is embedded into Person Entity... Check the model package
		 */
		session = sessionFactory.openSession();
		session.beginTransaction();
		Person embeddedPerson = new Person();
		embeddedPerson.setName("Kasturi");
		Address embeddingAddress = new Address();
		embeddingAddress.setStreet("Nallakunta");
		embeddingAddress.setCity("Hyderabad");
		embeddedPerson.setAddress(embeddingAddress);
		session.save(embeddedPerson);
		session.getTransaction().commit();
		session.close();

		// ==================================================================================================

		/*
		 * 5) AttributeOverrides and Embedded Objects
		 * 
		 * Check Employee and Address entities in model package
		 */

		Employee emp = new Employee();
		emp.setName("Vardhan");

		Address homeAddress = new Address();
		homeAddress.setCity("Hyderabad");
		homeAddress.setStreet("Nizampet");
		emp.setHomeAddress(homeAddress);

		Address officeAddress = new Address();
		officeAddress.setCity("Warangal");
		officeAddress.setStreet("Nallakunta");
		emp.setOfficeAddress(officeAddress);

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();

		// ============================================================================================

		/*
		 * 6) Saving Collections
		 */

		Worker worker = new Worker();
		worker.setDailyWage(100);

		Address address1 = new Address();
		address1.setStreet("Street1");
		address1.setCity("city1");

		Address address2 = new Address();
		address2.setStreet("Street2");
		address2.setCity("city2");

		worker.getLisOfAddresses().add(address1);
		worker.getLisOfAddresses().add(address2);

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(worker);
		session.getTransaction().commit();
		session.close();

		// ===================================================================================================

		/*
		 * 9) Cascade Types
		 * 
		 * Already tried in Supplier Entity
		 */

		// ==================================================================================================

		/*
		 * 12) Transient, Persistent and Detached Objects
		 */

		Item item = new Item();
		item.setName("Chicken");

		// item is in transient state

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(item);

		// item is is now in a persistent state

		session.getTransaction().commit();
		session.close();

		// item in detached state
		
		//=================================================================================================
		
			

	}
}
