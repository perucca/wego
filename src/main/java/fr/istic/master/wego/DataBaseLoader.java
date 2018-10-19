package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.TypeSport;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

@Component
public class DataBaseLoader {

	@Autowired
	PlaceDao placedao;
	@Autowired
	SportDao sportdao;
	@Autowired
	UserDao userdao;
	@Autowired
	UserPlaceDao upd;
	@Autowired
	UserSportDao usd;

	public void loadData() {

		// Declaration de plusieurs lieux de test
		Sport kayak = new Sport();
		kayak.setSportName("kayak");
		kayak.setType(TypeSport.EAU);
		Sport foot = new Sport();
		foot.setSportName("football");
		foot.setType(TypeSport.TERRE);
		Sport golf = new Sport();
		golf.setSportName("golf");
		golf.setType(TypeSport.TERRE);
		Sport voile = new Sport();
		voile.setSportName("voile");
		voile.setType(TypeSport.AIR);
		Sport tennis = new Sport();
		tennis.setSportName("tennis");
		tennis.setType(TypeSport.TERRE);
		Sport ski = new Sport();
		ski.setSportName("ski");
		ski.setType(TypeSport.NEIGE);

		// déclaration de plusieurs user de test
		User p1 = new User();
		p1.setFirstName("toto");
		p1.setLastName("titi");
		p1.setMail("toto@toto.fr");
		p1.setPassword(User.PASSWORD_ENCODER.encode("pss"));

		User p2 = new User();
		p2.setFirstName("Johnny");
		p2.setLastName("Hallyday");
		p2.setMail("john.hallyday@toto.fr");
		p2.setPassword(User.PASSWORD_ENCODER.encode("ahque"));

		User p3 = new User();
		p3.setFirstName("Monique");
		p3.setLastName("Dupont");
		p3.setMail("monique@toto.fr");
		p3.setPassword(User.PASSWORD_ENCODER.encode("password"));

		User p4 = new User();
		p4.setFirstName("Paul");
		p4.setLastName("Delamarre");
		p4.setMail("polo@tamer.fr");
		p4.setPassword(User.PASSWORD_ENCODER.encode("yolo"));

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
		plerguer.setPostCode("35000");
		rennes.setName("Rennes");
		rennes.setPostCode("35000");
		brest.setName("Brest");
		brest.setPostCode("29000");
		dunkerque.setName("Dunkerque");
		dunkerque.setPostCode("59200");
		nantes.setName("nantes");
		nantes.setPostCode("44000");

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

		// Déclaration de plusieurs UserSport
		UserSport us1 = new UserSport();
		UserSport us2 = new UserSport();
		UserSport us3 = new UserSport();
		UserSport us4 = new UserSport();
		UserSport us5 = new UserSport();
		UserSport us6 = new UserSport();

		// remplissage des UserSport
		us1.setSport(foot);
		us1.setUser(p1);
		us1.setPreferenceOrder(2);
		us2.setSport(kayak);
		us2.setUser(p1);
		us2.setPreferenceOrder(1);
		us3.setSport(golf);
		us3.setUser(p1);
		us3.setPreferenceOrder(3);

		us4.setSport(kayak);
		us4.setUser(p2);
		us4.setPreferenceOrder(1);

		us4.setSport(foot);
		us4.setUser(p3);
		us4.setPreferenceOrder(1);

		us6.setSport(tennis);
		us6.setUser(p4);
		us6.setPreferenceOrder(1);

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

		sportdao.save(kayak);
		sportdao.save(foot);
		sportdao.save(golf);
		sportdao.save(voile);
		sportdao.save(tennis);
		sportdao.save(ski);

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

		usd.save(us1);
		usd.save(us2);
		usd.save(us3);
		usd.save(us4);
		usd.save(us5);
		usd.save(us6);
	}

}
