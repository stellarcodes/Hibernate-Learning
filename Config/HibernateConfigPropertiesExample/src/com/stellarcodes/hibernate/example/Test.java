package com.stellarcodes.hibernate.example;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.stellarcodes.hibernate.entity.UserContact;

public class Test {

	public static void main(String args[]) {

		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("hibernate.properties"));

			Configuration config = new AnnotationConfiguration();
			config.setProperties(properties);
			config.addAnnotatedClass(UserContact.class);

			ServiceRegistry registry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();

			SessionFactory factory = config.buildSessionFactory(registry);

			Session session = factory.openSession();
			session.beginTransaction();

			UserContact contact = new UserContact("Harishna", "M",
					"9600270541", "test@test.com", new Date(), new Date());
			session.save(contact);

			session.getTransaction().commit();
			session.close();
			factory.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
