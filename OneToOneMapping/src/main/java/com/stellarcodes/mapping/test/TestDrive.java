package com.stellarcodes.mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stellarcodes.mapping.model.User;
import com.stellarcodes.mapping.model.Vehicle;

public class TestDrive {

	public static void main(String args[]) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MappingUnit");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		User usr = new User();
		usr.setContactNo("23456789");
		usr.setEmailAddress("Pravin@test.com");
		usr.setFirstName("Pravin");
		usr.setLastName("Test");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleMake("AUDI");
		vehicle.setVehicleModel("A3");
		vehicle.setVehicleName("CAR");

		usr.setVehicle(vehicle);

		manager.persist(usr);
		manager.persist(vehicle);

		manager.getTransaction().commit();

		usr = null;
		vehicle = null;

		manager.getTransaction().begin();

		usr = manager.find(User.class, 1L);
		usr.getVehicle();
		System.out.println("User:" + usr);

		vehicle = manager.find(Vehicle.class, 1L);
		System.out.println("User:" + vehicle);

		manager.getTransaction().commit();
		manager.close();
	}
}
