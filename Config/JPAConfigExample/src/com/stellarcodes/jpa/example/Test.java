package com.stellarcodes.jpa.example;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.stellarcodes.jpa.entity.UserContact;

public class Test {

	public static void main(String args[]) {

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("STELLAR_PERSISTENCE");

		EntityManager manager = entityManagerFactory.createEntityManager();

		manager.getTransaction().begin();

		UserContact contact = new UserContact();

		contact.setContactNo("9600270541");
		contact.setCreatedDate(new Date());
		contact.setUpdatedDate(new Date());
		contact.setEmailAddress("pravinkumaratwork@gmail.com");
		contact.setFirstName("PravinKumar");
		contact.setLastName("P");

		manager.persist(contact);
		manager.getTransaction().commit();
		manager.close();

		manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();

		List<UserContact> contacts = manager.createQuery("from UserContact",
				UserContact.class).getResultList();

		int i = 0;
		for (UserContact con : contacts) {
			i++;
			System.out.println("Row " + i + " : " + con.getId() + ", "
					+ con.getEmailAddress() + ", " + con.getContactNo() + ", "
					+ con.getFirstName() + ", " + con.getLastName() + ", "
					+ con.getCreatedDate() + ", " + con.getUpdatedDate());
		}

		manager.getTransaction().commit();
		manager.close();
		entityManagerFactory.close();

	}
}
