package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.istic.master.wego.dao.UserDao;


/**
 * @author amontuwy
 * Provides REST services for the User
 * To Be Done
 */
@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
}
