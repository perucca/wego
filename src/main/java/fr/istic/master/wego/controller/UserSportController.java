package fr.istic.master.wego.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.istic.master.wego.dto.UserSportDtoCreate;
import fr.istic.master.wego.dto.UserSportDtoRead;
import fr.istic.master.wego.model.UserSport;
import fr.istic.master.wego.service.UserSportService;

/**
 * @author dorian
 * 
 *         REST controller for the UserSport Entity
 *
 */
@RestController
@RequestMapping("/usersports")
public class UserSportController {
	@Autowired
	private UserSportService userSportService;

	// CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createUserSport(@RequestBody UserSportDtoCreate userSportDto) {
		UserSport userSport = userSportService.createUserSport(userSportDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSport.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	// READ
	@GetMapping("/byuser/{id}")
	public Collection<UserSportDtoRead> getUserSportsByUserId(@PathVariable("id") Long id) {
		return userSportService.getAllUserSportByUserId(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public void updateUserSport(@PathVariable("id") Long id, @RequestBody UserSportDtoCreate userSportDtoCreate) {
		userSportService.updateUserSport(id, userSportDtoCreate);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteUserSport(@PathVariable("id") Long id) {
		userSportService.deleteUserSport(id);
	}

	// UPDATE BATCH
	@PutMapping("")
	public void updateUserSportBatch(@RequestBody List<UserSportDtoRead> userSportDtoReads) {

		userSportService.updateUserSportBatch(userSportDtoReads);

	}
}
