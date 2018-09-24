package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.UserPlaceDto;
import fr.istic.master.wego.service.UserPlaceService;

@RestController
@RequestMapping("/userplaces")
public class UserPlaceController {

	@Autowired
	private UserPlaceService userplaceService;
	private UserDao userdao;

	// Services de Get de User Places

		// celle-ci est juste pour tester
	@GetMapping("")
	public Collection<UserPlaceDto> getAllUserPlacesinBase() {
		return userplaceService.getAllUserPlace();
	}

	@GetMapping("/{id}")
	public Collection<UserPlaceDto> getAllUserPlacesForId(@PathVariable("id") Long id) {
		return userplaceService.getAllUserPlacesByUserId(id);
	}
	
	// service de create d'un userplace pour un user
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUserPlace(@PathVariable ("id") Long userid, @RequestBody UserPlaceDto userplaceDto) {
        userplaceService.createUserPlace(userplaceDto, userdao.getOne(userid));
	}

	
	// service de delete
	@DeleteMapping("/{id}")
	public void deleteUserPlace(@PathVariable("id") Long id) {
		userplaceService.deleteUserPlace(id);
		System.err.println("Le compte utilisateur a été supprimé");
	}
	
	// service de update
}
