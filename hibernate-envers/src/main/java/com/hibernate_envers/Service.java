package com.hibernate_envers;

import java.util.Date;  
import org.hibernate.*;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.hibernate.entities.Customer;

public class Service {
	public static void main(String[] args) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Customer customer1 = new Customer();
			customer1.setFirstName("Pratik");
			customer1.setLastName("Mashere");
			customer1.setCreatedOn(new Date());

			Customer customer2 = new Customer();
			customer2.setFirstName("Shubham");
			customer2.setLastName("Kale");
			customer2.setCreatedOn(new Date());

			Customer customer3 = new Customer();
			customer3.setFirstName("Abhijit");
			customer3.setLastName("Shinde");
			customer3.setCreatedOn(new Date());

			session.save(customer1);
			session.save(customer2);
			session.save(customer3);

			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
		System.out.println("--------------------- Update Record ---------------------");

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			long customerId = 1l;

			Customer customer = session.get(Customer.class, customerId);

			if (customer != null) {
				tx = session.beginTransaction();
				customer.setLastName("Thorat");
				session.update(customer);
				tx.commit();
			} else {
				System.out.println("Customer details not found with ID : " + customerId);
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}

		System.out.println("--------------------- Delete Record ---------------------");

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			long customerId = 2l;

			Customer customer = session.get(Customer.class, customerId);

			if (customer != null) {
				tx = session.beginTransaction();
				session.delete(customer);
				tx.commit();
			} else {
				System.out.println("Customer details not found with ID : " + customerId);
			}
			System.out.println("-------Delete Record ----------------");
		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}
}