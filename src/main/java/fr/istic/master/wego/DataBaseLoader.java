package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dao.SportPlaceAssociationDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.SportPlaceAssociation;
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
	@Autowired
	SportPlaceAssociationDao spad;

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
		
		// déclaration de plusieurs user de test
		User p1 = new User();
		p1.setFirstName("Foo");
		p1.setLastName("Bar");
		p1.setMail("foo@bar.baz");
		p1.setPassword(User.PASSWORD_ENCODER.encode("password"));

		// Declaration de plusieurs lieux de test
	    Place redon = new Place();
	    redon.setName("Redon");
		redon.setPostCode("35600");
		
	    Place saintomer1 = new Place();
	    saintomer1.setName("Saint Omer");
		saintomer1.setPostCode("62500");

		// Déclaration de plusieurs UserPlace
		UserPlace up1 = new UserPlace();
		UserPlace up2 = new UserPlace();
		
		// remplissage des userplace
		up1.setPlace(redon);
		up1.setUser(p1);
		up1.setPreferenceOrder(2);
		up2.setPlace(saintomer1);
		up2.setUser(p1);
		up2.setPreferenceOrder(1);

		// Déclaration de plusieurs UserSport
		UserSport us1 = new UserSport();
		UserSport us2 = new UserSport();
		UserSport us3 = new UserSport();

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

		userdao.save(p1);

		placedao.save(redon);
		placedao.save(saintomer1);

		sportdao.save(kayak);
		sportdao.save(foot);
		sportdao.save(golf);

		upd.save(up1);
		upd.save(up2);

		usd.save(us1);
		usd.save(us2);
		usd.save(us3);
		
		
		SportPlaceAssociation spa1 = new SportPlaceAssociation(up1,us1);
		SportPlaceAssociation spa2 = new SportPlaceAssociation(up1,us2);
		SportPlaceAssociation spa3 = new SportPlaceAssociation(up2,us1);
		SportPlaceAssociation spa4 = new SportPlaceAssociation(up2,us3);

		
		spad.save(spa1);
		spad.save(spa2);
		spad.save(spa3);
		spad.save(spa4);
	}

}
