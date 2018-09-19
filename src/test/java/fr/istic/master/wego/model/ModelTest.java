package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

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
			Sport foot = new Sport();
			foot.setSportName("football");
			Sport golf = new Sport();
			golf.setSportName("golf");
			Sport voile = new Sport();
			voile.setSportName("voile");
			Sport tennis = new Sport();
			tennis.setSportName("tennis");
			Sport ski = new Sport();
			ski.setSportName("ski");

			// déclaration de plusieurs user de test
			User p1 = new User();
			p1.setName("toto");
			p1.setLastName("titi");

			User p2 = new User();
			p2.setName("Johnny");
			p2.setLastName("Hallyday");

			User p3 = new User();
			p3.setName("Monique");
			p3.setLastName("Dupont");

			User p4 = new User();
			p4.setName("Paul");
			p4.setLastName("Delamarre");

			// Declaration de plusieurs lieux de test
			Place redon = new Place();
			Place plerguer = new Place();
			Place rennes = new Place();
			Place brest = new Place();
			Place dunkerque = new Place();
			Place nantes = new Place();
			redon.setName("Redon");
			redon.setPostCode(35600);
			plerguer.setName("Plerguer");
			plerguer.setPostCode(35123);
			rennes.setName("Rennes");
			rennes.setPostCode(35000);
			brest.setName("Brest");
			brest.setPostCode(29000);
			dunkerque.setName("Dunkerque");
			dunkerque.setPostCode(59200);
			nantes.setName("nantes");
			nantes.setPostCode(44000);

			// Creaation de plusieurs instances de UserSport
			UserSport us1 = new UserSport();
			UserSport us2 = new UserSport();
			UserSport us3 = new UserSport();
			UserSport us4 = new UserSport();
			UserSport us5 = new UserSport();
			UserSport us6 = new UserSport();
			UserSport us7 = new UserSport();
			UserSport us8 = new UserSport();
			UserSport us9 = new UserSport();
			UserSport us10 = new UserSport();
			UserSport us11 = new UserSport();
			UserSport us12 = new UserSport();

			// Remplissage des UserSport
			us1.setUser(p1);
			us1.setSport(kayak);
			us1.setPreferenceOrder(2);
			us2.setUser(p1);
			us2.setSport(foot);
			us2.setPreferenceOrder(1);

			us3.setUser(p2);
			us3.setSport(voile);
			us3.setPreferenceOrder(1);
			us4.setUser(p2);
			us4.setSport(foot);
			us4.setPreferenceOrder(3);
			us5.setUser(p2);
			us5.setSport(ski);
			us5.setPreferenceOrder(2);

			us6.setUser(p3);
			us6.setSport(tennis);
			us6.setPreferenceOrder(3);
			us7.setUser(p3);
			us7.setSport(voile);
			us7.setPreferenceOrder(1);
			us8.setUser(p3);
			us8.setSport(ski);
			us8.setPreferenceOrder(2);

			us9.setUser(p4);
			us9.setSport(tennis);
			us9.setPreferenceOrder(3);
			us10.setUser(p4);
			us10.setSport(voile);
			us10.setPreferenceOrder(1);
			us11.setUser(p4);
			us11.setSport(ski);
			us11.setPreferenceOrder(2);
			us12.setUser(p4);
			us12.setSport(kayak);
			us12.setPreferenceOrder(4);

			// Déclaration de plusieurs UserPlace
			UserPlace up1 = new UserPlace();
			UserPlace up2 = new UserPlace();
			UserPlace up3 = new UserPlace();
			UserPlace up4 = new UserPlace();
			UserPlace up5 = new UserPlace();
			UserPlace up6 = new UserPlace();
			UserPlace up7 = new UserPlace();
			UserPlace up8 = new UserPlace();
			UserPlace up9 = new UserPlace();
			UserPlace up10 = new UserPlace();

			// remplissage des userplace
			up1.setPlace(redon);
			up1.setUser(p1);
			up1.setPreferenceOrder(2);
			up2.setPlace(brest);
			up2.setUser(p1);
			up2.setPreferenceOrder(1);

			up3.setPlace(plerguer);
			up3.setUser(p2);
			up3.setPreferenceOrder(1);
			up4.setPlace(rennes);
			up4.setUser(p2);
			up4.setPreferenceOrder(3);
			up5.setPlace(plerguer);
			up5.setUser(p2);
			up5.setPreferenceOrder(2);

			up6.setPlace(dunkerque);
			up6.setUser(p3);
			up6.setPreferenceOrder(1);
			up7.setPlace(rennes);
			up7.setUser(p3);
			up7.setPreferenceOrder(2);
			up8.setPlace(redon);
			up8.setUser(p3);
			up8.setPreferenceOrder(4);
			up9.setPlace(plerguer);
			up9.setUser(p3);
			up9.setPreferenceOrder(3);

			up10.setPlace(dunkerque);
			up10.setUser(p4);
			up10.setPreferenceOrder(1);

			// Association de lieux et sport pour 1 user
			SportPlaceAssociation spa1 = new SportPlaceAssociation(up2, us9);		
			
			// Mise en base de tous les objets
			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
			manager.persist(p4);

			manager.persist(kayak);
			manager.persist(foot);
			manager.persist(golf);
			manager.persist(voile);
			manager.persist(tennis);
			manager.persist(ski);

			manager.persist(redon);
			manager.persist(plerguer);
			manager.persist(rennes);
			manager.persist(brest);
			manager.persist(dunkerque);
			manager.persist(nantes);

			manager.persist(up1);
			manager.persist(up2);
			manager.persist(up3);
			manager.persist(up4);
			manager.persist(up5);
			manager.persist(up6);
			manager.persist(up7);
			manager.persist(up8);
			manager.persist(up9);
			manager.persist(up10);

			manager.persist(us1);
			manager.persist(us2);
			manager.persist(us3);
			manager.persist(us4);
			manager.persist(us5);
			manager.persist(us6);
			manager.persist(us7);
			manager.persist(us8);
			manager.persist(us9);
			manager.persist(us10);
			manager.persist(us11);
			manager.persist(us12);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

	}

}
