package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.istic.master.wego.dao.PlaceDao;


/**
 * @author amontuwy
 * REST Services available for Place management
 * To be done
 */
@Controller
public class PlaceController {

	@Autowired
	private PlaceDao placeDao;

}
