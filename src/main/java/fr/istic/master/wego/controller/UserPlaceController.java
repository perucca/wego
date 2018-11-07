package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dto.UserPlaceDtoCreate;
import fr.istic.master.wego.dto.UserPlaceDtoRead;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.service.UserPlaceService;

@RestController
@RequestMapping("/userplaces")
public class UserPlaceController {

	@Autowired
	private UserPlaceService userplaceService;

	@Autowired
	private UserDao userDao;

//	@GetMapping("")
//	public Collection<UserPlaceDtoRead> getAllUserPlacesinBase() {
//		return userplaceService.getAllUserPlace();
//	}

	@GetMapping("/byuser/{id}")
	public Collection<UserPlaceDtoRead> getAllUserPlacesForUserId(@PathVariable("id") Long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));
		return userplaceService.getAllUserPlacesByUser(user);
	}

	// service de create d'un userplace pour un user
	@PostMapping("/byuser/{id}")
	public Collection<UserPlaceDtoRead> createUserPlace(@PathVariable("id") Long id,
			@RequestBody UserPlaceDtoCreate userplaceDto) {
		userplaceService.createUserPlace(userplaceDto);
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
		return userplaceService.getAllUserPlacesByUser(user);
	}

	// service de delete
	@DeleteMapping("byuser/{iduser}/{iduserplace}")
	public Collection<UserPlaceDtoRead> deleteUserPlace(@PathVariable("iduser") Long iduser,
			@PathVariable("iduserplace") Long iduserplace) {
		userplaceService.deleteUserPlaceAndUpdate(iduser, iduserplace);
		System.err.println("La UserPlace a été supprimée");
		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User: not found!"));
		return userplaceService.getAllUserPlacesByUser(user);
	}

	// service de update
//	@PutMapping("/{id}")
//	public void updateUserPlace(@PathVariable("id") Long id, @RequestBody UserPlaceDtoCreate userplaceDto) {
//		userplaceService.updateUserPlace(id, userplaceDto);
//		System.err.println("La UserPlace a été mise à jour");
//	}

	@GetMapping("/increased/{iduser}/{idplace}")
	public Collection<UserPlaceDtoRead> increaseUserPlacePreference(@PathVariable("iduser") Long iduser,
			@PathVariable("idplace") Long idplace) {
		userplaceService.increaseUserPlace(idplace, iduser);
		System.err.println("La préférence de la UserPlace a été augmentée");
		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User not found!"));
		return userplaceService.getAllUserPlacesByUser(user);
	}

	@GetMapping("/decreased/{iduser}/{idplace}")
	public Collection<UserPlaceDtoRead> decreaseUserPlacePreference(@PathVariable("iduser") Long iduser,
			@PathVariable("idplace") Long idplace) {
		userplaceService.decreaseUserPlace(idplace, iduser);
		System.err.println("La préférence de la UserPlace a été diminuée");
		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User not found!"));
		return userplaceService.getAllUserPlacesByUser(user);
	}
}
