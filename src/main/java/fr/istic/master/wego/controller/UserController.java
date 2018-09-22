package fr.istic.master.wego.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void createUser(@RequestBody UserDto udto) {
		System.out.println(udto.toString());
	}
	
	
	//Services to read a User
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userDao.findById(id);
	}
	
	@GetMapping("/users/{email}")
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
