package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.model.Place;

/**
 * @author amontuwy REST Services available for Place management To be done
 */
@Controller
public class PlaceController {

	@Autowired
	private PlaceDao placeDao;

	@RequestMapping("/places/{id}")
	public Place getPlace(@RequestParam("id") long id) {
		return placeDao.findById(id).get();
	}

}
