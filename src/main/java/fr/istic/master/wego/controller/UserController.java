package fr.istic.master.wego.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.UserDto;
import fr.istic.master.wego.model.User;
/**
 * @author amontuwy Provides REST services for the User To Be Done
 */

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;
	
	//Services to create a User
	
	@PostMapping("users/")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody UserDto udto) {
		User u = new User();
		u.setName(udto.getFirstName());
		u.setLastName(udto.getLastName());
		u.setMail(udto.getMail());
		u.setPassword(udto.getPassword());
		userDao.save(u);
	}
	
	
	//Services to read a User
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userDao.findById(id);
	}
	
	@GetMapping("/users/by_email/{email}")
	public Optional<User> getUserByEmail(@PathVariable("email") String email) {
		return userDao.findByEmail(email);
	}
	
	//Services to update a User
	
	// Services to delete a User
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userDao.deleteById(id);
		System.err.println("Le compte utilisateur a été supprimé");
	}
	

	

}
