package com.accolite.au.HibernateAssignment;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.accolite.au.model.Item;
import com.accolite.au.util.HibernateUtil;

public class CriteriaTest {

	public static void main(String[] args) {

		// Creating Session Factory Object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// =================================================================================================

		/*
		 * 16) Introduction to Criteria API
		 * 
		 * 17) Restrictions
		 * 
		 * 18) Projections
		 * 
		 * In hiberante 5 all the above three functionalities can be done by the below code
		 */

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Item> cr = cb.createQuery(Item.class);
		Root<Item> root = cr.from(Item.class);
		cr.select(root).where(cb.equal(root.get("name"), "BMW"));

		Query query = session.createQuery(cr);
		List<Item> results = query.getResultList();

		System.out.println(results);
		
		
	}

}
