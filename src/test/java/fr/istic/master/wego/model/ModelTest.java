package fr.istic.master.wego.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ModelTest {

	private static EntityManager manager;
	private static EntityManagerFactory factory;

	@BeforeAll
	public static void beforeclass() {

		factory = Persistence.createEntityManagerFactory("test");
		manager = factory.createEntityManager();
	}

	@AfterAll
	public static void afterclass() {
		try {
			manager.close();
		} catch (Exception e) {
			System.out.println("Erreur: " + e);
		}
		;
		try {
			factory.close();
		} catch (Exception e) {
			System.out.println("Erreur: " + e);
		}
		;
	}

	@Test
	public void testModel() {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			// Declaration de plusieurs lieux de test
			Sport kayak = new Sport();
			kayak.setSportName("kayak");

			// déclaration de plusieurs user de test
			User p1 = new User();
			p1.setFirstName("toto");
			p1.setLastName("titi");
			p1.setMail("titi@tata");
			p1.setPassword("p1");

			// Declaration de plusieurs lieux de test
			Place redon = new Place();
			redon.setName("Redon");
			redon.setPostCode("35600");

			// Creaation de plusieurs instances de UserSport
			UserSport us1 = new UserSport();

			// Remplissage des UserSport
			us1.setUser(p1);
			us1.setSport(kayak);
			us1.setPreferenceOrder(2);

			// Déclaration de plusieurs UserPlace
			UserPlace up1 = new UserPlace();

			// remplissage des userplace
			up1.setPlace(redon);
			up1.setUser(p1);
			up1.setPreferenceOrder(2);

			new SportPlaceAssociation(up1, us1);

			// Mise en base de tous les objets
			manager.persist(p1);

			manager.persist(kayak);
			manager.persist(redon);
			manager.persist(up1);
			manager.persist(us1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

}
