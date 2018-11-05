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

		if (userdao.count() != 0)
			return;

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
	    redon.setName("Redon");
		redon.setPostCode("35600");
		
	    Place vannes = new Place();
	    vannes.setName("Vannes");
		vannes.setPostCode("56000");
		
	    Place nantes = new Place();
	    nantes.setName("Nantes");
		nantes.setPostCode("44000");
		
		Place nantes1 = new Place();
		nantes1.setName("Nantes");
		nantes1.setPostCode("44001");
		
		Place nantes2 = new Place();
		nantes2.setName("Nantes");
		nantes2.setPostCode("44002");
		
	    Place saintbrieuc = new Place();
	    saintbrieuc.setName("Saint Brieuc");
		saintbrieuc.setPostCode("22000");
		
	    Place caen = new Place();
	    caen.setName("Caen");
		caen.setPostCode("14000");
		
	    Place dunkerque = new Place();
	    dunkerque.setName("Dunkerque");
		dunkerque.setPostCode("59120");
		
	    Place annecy = new Place();
	    annecy.setName("Annecy");
		annecy.setPostCode("74000");
		
	    Place marseille = new Place();
	    marseille.setName("Marseille");
		marseille.setPostCode("13000");
		
	    Place marseille1 = new Place();
	    marseille1.setName("Marseille");
		marseille1.setPostCode("13001");
		
	    Place marseille2 = new Place();
	    marseille2.setName("Marseille");
		marseille2.setPostCode("13002");
		
	    Place marseille3 = new Place();
	    marseille3.setName("Marseille");
		marseille3.setPostCode("13003");
		
	    Place bainssuroust = new Place();
	    bainssuroust.setName("Bain sur Oust");
		bainssuroust.setPostCode("35600");
		
	    Place saintomer1 = new Place();
	    saintomer1.setName("Saint Omer");
		saintomer1.setPostCode("62500");
		
	    Place saintomer2 = new Place();
	    saintomer2.setName("Saint Omer");
		saintomer2.setPostCode("44130");
		
	    Place saintemarie = new Place();
	    saintemarie.setName("Sainte Marie de Redon");
		saintemarie.setPostCode("35600");

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
		up2.setPlace(saintomer1);
		up2.setUser(p1);
		up2.setPreferenceOrder(1);

		up3.setPlace(marseille);
		up3.setUser(p2);
		up3.setPreferenceOrder(1);
		up4.setPlace(annecy);
		up4.setUser(p2);
		up4.setPreferenceOrder(3);
		up5.setPlace(bainssuroust);
		up5.setUser(p2);
		up5.setPreferenceOrder(2);

		up6.setPlace(dunkerque);
		up6.setUser(p3);
		up6.setPreferenceOrder(1);
		up7.setPlace(saintomer2);
		up7.setUser(p3);
		up7.setPreferenceOrder(2);
		up8.setPlace(redon);
		up8.setUser(p3);
		up8.setPreferenceOrder(4);
		up9.setPlace(marseille3);
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
		placedao.save(vannes);
		placedao.save(nantes);
		placedao.save(nantes1);
		placedao.save(nantes2);
		placedao.save(saintbrieuc);
		placedao.save(caen);
		placedao.save(dunkerque);
		placedao.save(annecy);
		placedao.save(marseille);
		placedao.save(marseille1);
		placedao.save(marseille2);
		placedao.save(marseille3);
		placedao.save(bainssuroust);
		placedao.save(saintomer1);
		placedao.save(saintomer2);
		placedao.save(saintemarie);

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
