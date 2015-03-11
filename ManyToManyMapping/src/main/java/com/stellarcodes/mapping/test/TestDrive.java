package com.stellarcodes.mapping.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stellarcodes.mapping.model.User;
import com.stellarcodes.mapping.model.UserRole;

public class TestDrive {

	public static void main(String args[]) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MappingUnit");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		User user = new User();
		user.setAge(25);
		user.setContactNo("456789");
		user.setDateOfBirth(new Date());
		user.setEmailAddress("pravin@test.com");
		user.setFirstName("PravinKumar");
		user.setLastName("VP");

		UserRole role = new UserRole();
		role.setRole("ADMIN");
		role.setRoleDesc("Administrator");

		role.getUsers().add(user);
		user.getRoles().add(role);

		manager.persist(user);
		manager.persist(role);

		manager.getTransaction().commit();
		manager.close();

		manager = factory.createEntityManager();
		manager.getTransaction().begin();

		user = manager.find(User.class, 1L);

		System.out.println("User: " + user);

		System.out.println("Roles: " + user.getRoles());

		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
