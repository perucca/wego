package fr.istic.master.wego.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author michel
 *
 *         Endpoint used for authenticating the user
 *
 */
@RestController
@RequestMapping("/login")
public class AuthenticationController {

	@PostMapping("")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void authenticate() {

	}

}
