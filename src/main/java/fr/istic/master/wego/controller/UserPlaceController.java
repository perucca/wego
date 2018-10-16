package fr.istic.master.wego.controller;

import java.util.Collection;

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

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.UserPlaceDtoCreate;
import fr.istic.master.wego.dto.UserPlaceDtoRead;
import fr.istic.master.wego.dto.UserSportDto;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.service.UserPlaceService;

@RestController
@RequestMapping("/userplaces")
public class UserPlaceController {

	@Autowired
	private UserPlaceService userplaceService;

	@Autowired
	private UserDao userDao;

	// Services de Get de User Places

	// celle-ci est juste pour tester
	@GetMapping("")
	public Collection<UserPlaceDtoRead> getAllUserPlacesinBase() {
		return userplaceService.getAllUserPlace();
	}
	
	@GetMapping("/byuser/{id}")
	public Collection<UserPlaceDtoRead> getAllUserPlacesForUserId(@PathVariable("id") Long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

		return userplaceService.getAllUserPlacesByUser(user);
	}

	// service de create d'un userplace pour un user
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUserPlace(@RequestBody UserPlaceDtoCreate userplaceDto) {
		userplaceService.createUserPlace(userplaceDto);
	}

	// service de delete
	@DeleteMapping("/{id}")
	public void deleteUserPlace(@PathVariable("id") Long id) {
		userplaceService.deleteUserPlace(id);
		System.err.println("La UserPlace a été supprimée");
	}

	// service de update
	@PutMapping("/{id}")
	public void updateUserPlace(@PathVariable("id") Long id, @RequestBody UserPlaceDtoCreate userplaceDto) {
		userplaceService.updateUserPlace(id, userplaceDto);
		System.err.println("La UserPlace a été mise à jour");
	}
}
