package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.model.Place;

@Component
public class DataBaseLoader {

	@Autowired PlaceDao placedao;
	
	public void loadData() {
		Place redon = new Place();
		Place plerguer = new Place();
		Place rennes = new Place();
		Place brest = new Place();
		Place dunkerque = new Place();
		Place nantes = new Place();
		redon.setName("Redon");
		redon.setPostCode("35600");
		plerguer.setName("Plerguer");
		plerguer.setPostCode("59200");
		rennes.setName("Redon");
		rennes.setPostCode("35000");
		brest.setName("Brest");
		brest.setPostCode("29000");
		dunkerque.setName("Dunkerque");
		dunkerque.setPostCode("59200");
		nantes.setName("nantes");
		nantes.setPostCode("44000");
		
		placedao.save(redon);
		placedao.save(plerguer);
		placedao.save(rennes);
		placedao.save(brest);
		placedao.save(dunkerque);
		placedao.save(nantes);
	
	}

}
