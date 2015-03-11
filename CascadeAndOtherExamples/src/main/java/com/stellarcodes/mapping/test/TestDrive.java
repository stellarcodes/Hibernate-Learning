package com.stellarcodes.mapping.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stellarcodes.mapping.model.Address;
import com.stellarcodes.mapping.model.User;
import com.stellarcodes.mapping.model.Vehicle;

public class TestDrive {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setFirstName("Test");
		user.setLastName("User");
		user.setDateofBirth(new Date());

		session.save(user);

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle("Car");
		vehicle.setVehicleMake("AUDI");
		vehicle.setVehicleModel("2015");

		session.save(vehicle);
		session.getTransaction().commit();
		session.close();

		vehicle = null;

		session = factory.openSession();

		vehicle = (Vehicle) session.get(Vehicle.class, 1L);
		System.out.println("Vehicle is: " + vehicle);

		/**
		 * Validating cascade operation, normally the hibernate will not persist
		 * the entity within another entity. we need trigger it using cascade.
		 * 
		 * CascadeType.ALL will support for all operations like, insert, delete,
		 * update. you can also set the cascade for specific operations.
		 */

		user = new User();
		user.setDateofBirth(new Date());
		user.setFirstName("Second User");
		user.setLastName("Test");

		Address address = new Address();
		address.setAddress1("Test1");
		address.setAddress2("test2");
		address.setCity("NC");
		address.setState("NC");
		address.setCountry("USA");
		address.setPincode("45765");
		address.setUser(user);

		Address address1 = new Address();
		address1.setAddress1("Test11");
		address1.setAddress2("test21");
		address1.setCity("NC1");
		address1.setState("NC1");
		address1.setCountry("USA1");
		address1.setPincode("457651");
		address1.setUser(user);

		user.getAddresses().add(address);
		user.getAddresses().add(address1);

		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
