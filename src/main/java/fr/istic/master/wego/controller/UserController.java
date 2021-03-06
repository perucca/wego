package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.UserDtoCreate;
import fr.istic.master.wego.dto.UserDtoRead;
import fr.istic.master.wego.service.UserService;

/**
 * @author amontuwy Provides REST services for the User
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public Collection<UserDtoRead> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public UserDtoRead getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/by_email/{email}")
	public UserDtoRead getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email);
	}

	// Service to update a User
	@PutMapping("/{id}")
	public UserDtoRead updateUser(@PathVariable("id") Long id, @RequestBody UserDtoCreate userDto) {
		userService.updateUser(id, userDto);
		return userService.getUserById(id);
	}

	// Service to delete a User
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		System.err.println("Le compte utilisateur a été supprimé");
	}

}
