package com.stellarcodes.hibernate.sample;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stellarcodes.hibernate.entity.UserContact;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		UserContact contact = new UserContact("Rithvika", "Sri", "9600270541",
				"test@test.com", new Date(), new Date());

		session.save(contact);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
