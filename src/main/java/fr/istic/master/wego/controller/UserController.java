package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.User;

/**
 * @author amontuwy Provides REST services for the User To Be Done
 */
@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/users/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) {
		User user = new User();
		user.setLastName("toto");
		user.setMail("toto@gmail.com");
		user.setName("titi");
		user.setPassword("pass");
		userDao.save(user);
		user = userDao.findById(id).get();
		return user;
	}

}
