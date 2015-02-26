package com.stellarcodes.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stellarcodes.hibernate.entity.Address;
import com.stellarcodes.hibernate.entity.User;

public class TestDrive {

	public static void main(String[] args) {

		/**
		 * Creating Session factory for this application. Configuration is class
		 * which used to load all the configuration information from the
		 * hibernate.cfg.xml.
		 * 
		 * While configuring it is automatically will look for a configuration
		 * file to load the configuration.
		 * 
		 * Every Application will have one sessionfactory. You can use more than
		 * one sessionfactory's when, you need configure multiple databases for
		 * single application.
		 */
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();

		/**
		 * Creating new session to perform CRUD operations
		 */
		Session session = factory.openSession();

		/**
		 * creating new entry for the user entity
		 */
		Set<Address> addresses = new HashSet<Address>();

		Address address = new Address("XXXX", "YYYYY", "NY", "USA", "78779");
		Address officeAddress = new Address("XXXX", "YYYYY", "NC", "USA",
				"78778");

		addresses.add(address);
		addresses.add(officeAddress);

		User user = new User("PravinKumar", "VP", "97897896786", addresses);

		/**
		 * Creating transaction
		 */

		session.beginTransaction();
		/**
		 * Saving object
		 */
		session.save(user);

		/**
		 * committing if the transaction is success
		 */
		session.getTransaction().commit();

		/**
		 * Closing session
		 */
		session.close();

		session = factory.openSession();
		/**
		 * Checking fetch types
		 */
		user = null;
		user = (User) session.get(User.class, 5L);
		session.close();
		System.out.println("list of address: " + user);

		/**
		 * closing session factory
		 */
		factory.close();

	}

}
