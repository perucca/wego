package fr.istic.master.wego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.istic.master.wego.dao.UserDAO;
import fr.istic.master.wego.model.User;

@Controller
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/users/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) {
		User user = new User();
		user.setLastName("toto");
		user.setMail("toto@gmail.com");
		user.setName("titi");
		user.setPassword("pass");
		userDAO.save(user);
		user = userDAO.findById(id).get();
		return user;
	}
}
