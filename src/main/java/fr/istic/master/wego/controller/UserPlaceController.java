package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.istic.master.wego.dao.UserPlaceDao;

/**
 * @author amontuwy REST services for UserPlace Management To be done
 */
@Controller
public class UserPlaceController {

	@Autowired
	private UserPlaceDao userPlaceDao;

}
