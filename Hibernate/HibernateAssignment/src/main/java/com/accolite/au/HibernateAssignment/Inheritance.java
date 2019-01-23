package com.accolite.au.HibernateAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.model.Contract_Employee;
import com.accolite.au.model.Employee;
import com.accolite.au.model.Regular_Employee;
import com.accolite.au.util.HibernateUtil;

public class Inheritance {
	public static void main(String[] args) {

		// Creating Session Factory Object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//================================================================================================

		/*
		 * 10) Implementing Inheritance (single table,joined table)
		 */

		
		//Single Table
		Employee e1 = new Employee();
		e1.setName("Vardhan");

		Regular_Employee e2 = new Regular_Employee();
		e2.setName("Kat");
		e2.setSalary(50000);
		e2.setBonus(5);

		Contract_Employee e3 = new Contract_Employee();
		e3.setName("KV");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(e3);

		session.getTransaction().commit();
		session.close();

		// ==============================================================================================
		
		//Similarly for Joined table use
		/*
		 * @Inheritance(strategy = InheritanceType.JOINED)
		 */

		//================================================================================================
	}
}
