package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.SportPlaceAssociationDao;

/**
 * @author amontuwy REST Services available for Place management
 */

@RestController
@RequestMapping("/places")
public class SportPlaceAssociationController {

	@Autowired
	private SportPlaceAssociationDao sportPlaceAssociationDao;

}
