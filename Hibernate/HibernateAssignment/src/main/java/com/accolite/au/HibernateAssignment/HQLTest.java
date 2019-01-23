package com.accolite.au.HibernateAssignment;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.model.Vehicle;
import com.accolite.au.util.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		/*
		 * 13) Introducing HQL and the Query Object 
		 * 
		 * 14) Select and Pagination in HQL
		 * 
		 */

		String hql = "FROM Vehicle";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<Vehicle> results = ((org.hibernate.query.Query) query).list();
		System.out.println(results);
		
		
		/*
		 * 15) Parameter Binding and Named Queries
		 */
		
		String hql1 = "from vehicle where name= :name";
		Query namedQuery = session.createQuery(hql);
		query.setParameter("name", "BMW");
		List<Vehicle> result = ((org.hibernate.query.Query) query).list();
		System.out.println(result);
	}

}
