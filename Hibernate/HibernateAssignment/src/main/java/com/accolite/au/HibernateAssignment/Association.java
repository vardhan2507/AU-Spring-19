package com.accolite.au.HibernateAssignment;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.au.model.Customer;
import com.accolite.au.model.Supplier;
import com.accolite.au.model.Vehicle;
import com.accolite.au.util.HibernateUtil;

public class Association {

	public static void main(String[] args) {

		// Creating Session Factory Object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		/*
		 * 7) One To One Mapping
		 * 
		 * 1 customer - 2 Vehicle
		 */

		Customer customer = new Customer();
		customer.setName("Vardhan");
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Ciaz");
		customer.setVehcile(vehicle);

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();

		// ===================================================================================================

		/*
		 * 8) One To Many Mapping
		 * 
		 * 1 Supplier - Many Vehicles
		 */

		Supplier supplier = new Supplier();
		supplier.setName("Vardhan");
		Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle newVehicle = new Vehicle();
		vehicle.setName("Ciaz");
		vehicles.add(newVehicle);

		supplier.setVehciles(vehicles);

		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();

		// ================================================================================================

	}
}
