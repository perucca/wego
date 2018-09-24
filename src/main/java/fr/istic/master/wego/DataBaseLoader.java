package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;

@Component
public class DataBaseLoader {

	@Autowired
	PlaceDao placedao;
	@Autowired
	UserDao userdao;
	@Autowired
	UserPlaceDao upd;

	public void loadData() {

//	if (placedao.count() != 0)
//			return;

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
		p1.setFirstName("toto");
		p1.setLastName("titi");
		p1.setMail("toto@toto.fr");
		p1.setPassword("pss");

		User p2 = new User();
		p2.setFirstName("Johnny");
		p2.setLastName("Hallyday");
		p2.setMail("john.hallyday@toto.fr");
		p2.setPassword("ahque");

		User p3 = new User();
		p3.setFirstName("Monique");
		p3.setLastName("Dupont");
		p3.setMail("monique@toto.fr");
		p3.setPassword("password");

		User p4 = new User();
		p4.setFirstName("Paul");
		p4.setLastName("Delamarre");
		p4.setMail("polo@tamer.fr");
		p4.setPassword("yolo");

		// Declaration de plusieurs lieux de test
		Place redon = new Place();
		Place plerguer = new Place();
		Place rennes = new Place();
		Place brest = new Place();
		Place dunkerque = new Place();
		Place nantes = new Place();
		redon.setName("Redon");
		redon.setPostCode("35600");
		plerguer.setName("Plerguer");
		plerguer.setPostCode("35123");
		rennes.setName("Rennes");
		rennes.setPostCode("35000");
		brest.setName("Brest");
		brest.setPostCode("29000");
		dunkerque.setName("Dunkerque");
		dunkerque.setPostCode("59200");
		nantes.setName("nantes");
		nantes.setPostCode("44000");

		// Creaation de plusieurs instances de UserSport
//					UserSport us1 = new UserSport();
//					UserSport us2 = new UserSport();
//					UserSport us3 = new UserSport();
//					UserSport us4 = new UserSport();
//					UserSport us5 = new UserSport();
//					UserSport us6 = new UserSport();
//					UserSport us7 = new UserSport();
//					UserSport us8 = new UserSport();
//					UserSport us9 = new UserSport();
//					UserSport us10 = new UserSport();
//					UserSport us11 = new UserSport();
//					UserSport us12 = new UserSport();

		// Remplissage des UserSport
//					us1.setUser(p1);
//					us1.setSport(kayak);
//					us1.setPreferenceOrder(2);
//					us2.setUser(p1);
//					us2.setSport(foot);
//					us2.setPreferenceOrder(1);
//
//					us3.setUser(p2);
//					us3.setSport(voile);
//					us3.setPreferenceOrder(1);
//					us4.setUser(p2);
//					us4.setSport(foot);
//					us4.setPreferenceOrder(3);
//					us5.setUser(p2);
//					us5.setSport(ski);
//					us5.setPreferenceOrder(2);
//
//					us6.setUser(p3);
//					us6.setSport(tennis);
//					us6.setPreferenceOrder(3);
//					us7.setUser(p3);
//					us7.setSport(voile);
//					us7.setPreferenceOrder(1);
//					us8.setUser(p3);
//					us8.setSport(ski);
//					us8.setPreferenceOrder(2);
//
//					us9.setUser(p4);
//					us9.setSport(tennis);
//					us9.setPreferenceOrder(3);
//					us10.setUser(p4);
//					us10.setSport(voile);
//					us10.setPreferenceOrder(1);
//					us11.setUser(p4);
//					us11.setSport(ski);
//					us11.setPreferenceOrder(2);
//					us12.setUser(p4);
//					us12.setSport(kayak);
//					us12.setPreferenceOrder(4);

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

		// new SportPlaceAssociation(up2, us9);

		userdao.save(p1);
		userdao.save(p2);
		userdao.save(p3);
		userdao.save(p4);

		placedao.save(redon);
		placedao.save(plerguer);
		placedao.save(rennes);
		placedao.save(dunkerque);
		placedao.save(nantes);
		placedao.save(brest);

		upd.save(up1);
		upd.save(up2);
		upd.save(up3);
		upd.save(up4);
		upd.save(up5);
		upd.save(up6);
		upd.save(up7);
		upd.save(up8);
		upd.save(up9);
		upd.save(up10);
	}

}
