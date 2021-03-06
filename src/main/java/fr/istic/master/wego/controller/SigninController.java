package fr.istic.master.wego.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.UserDtoCreate;
import fr.istic.master.wego.service.UserService;

/**
 * @author michel
 *
 *         REST controller used for the signin of the user to the wego
 *         application
 */
@RestController
@RequestMapping("/signin")
public class SigninController {

	@Autowired
	private UserService userService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid UserDtoCreate userDto) {
		userService.createUser(userDto);
	}

}
