package fr.istic.master.wego.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.UserDto;
import fr.istic.master.wego.service.UserService;

/**
 * @author amontuwy Provides REST services for the User To Be Done
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

    @GetMapping("")
    public Collection<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
	}

	@GetMapping("/by_email/{email}")
	public UserDto getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid UserDto userDto) {
        userService.createUser(userDto);
	}

	// Service to update a User
	@PutMapping("/{id}")
	public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) {
		userService.updateUser(id, userDto);
	}

	// Service to delete a User
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		System.err.println("Le compte utilisateur a été supprimé");
	}

}
