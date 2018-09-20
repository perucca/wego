package fr.istic.master.wego.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.model.Place;

/**
 * @author amontuwy REST Services available for Place management To be done
 */

@RestController
public class PlaceController {

	@Autowired
	private PlaceDao placeDao;

	@GetMapping("/places/{postcode}")
	public Set<Place> getAllPlacesByPostCode(@PathVariable("postcode") String postcode) {
		return placeDao.findAllByPostCode(postcode);
	}

	@GetMapping("/places/{name}")
	public Set<Place> getAllPlacesByName(@PathVariable("name") String name) {
		return placeDao.findAllByName(name);
	}

	@GetMapping("/places/{id}")
	public Place getPlaceById(@PathVariable("id") Long id) {
		return placeDao.getOne(id);
	}

	@GetMapping("places/")
	public List<Place> getAllPlaces() {
		return placeDao.findAll();
	}

}
