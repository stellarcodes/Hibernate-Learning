package com.stellarcodes.mapping.test;

import java.util.ArrayList;
import java.util.List;

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

		User user = new User();
		user.setContactNo("67898767890");
		user.setEmailAddress("Pravin@test.com");
		user.setFirstName("Pravin");
		user.setLastName("Test");

		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		Vehicle veh1 = new Vehicle();
		veh1.setVehicleMake("Audi");
		veh1.setVehicleModel("2013");
		veh1.setVehicleName("Car");

		Vehicle veh2 = new Vehicle();
		veh2.setVehicleMake("Audi");
		veh2.setVehicleModel("2014");
		veh2.setVehicleName("Car");

		veh1.setUser(user);
		veh2.setUser(user);

		user.setVehicles(vehicles);

		vehicles.add(veh1);
		vehicles.add(veh2);

		manager.persist(user);
		manager.persist(veh1);
		manager.persist(veh2);

		manager.getTransaction().commit();
		manager.close();

		user = null;
		veh1 = null;

		manager = factory.createEntityManager();
		manager.getTransaction().begin();

		veh1 = manager.find(Vehicle.class, 1L);
		System.out.println("User Val:" + veh1);
		System.out.println("Vehicle user:" + veh1.getUser());

		manager.getTransaction().commit();
		manager.close();

	}
}
