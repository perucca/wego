package fr.istic.master.wego.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.SportPlaceAssociationDtoBatch;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoCreate;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoRead;
import fr.istic.master.wego.model.UserSport;
import fr.istic.master.wego.service.SportPlaceAssociationService;
import fr.istic.master.wego.service.UserSportService;

/**
 * @author michel
 *
 *         REST controller for the SportPlaceAssociation Entity
 */
@RestController
@RequestMapping("/sportplaceassociations")
public class SportPlaceAssociationController {

	@Autowired
	private SportPlaceAssociationService sportPlaceAssociationService;

	@Autowired
	private UserSportService userSportService;

	// CREATE
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createSportPlaceAssociation(
			@RequestBody SportPlaceAssociationDtoCreate sportPlaceAssociationDtoCreate) {
		sportPlaceAssociationService.createSportPlaceAssociation(sportPlaceAssociationDtoCreate);
	}

	// READ
	@GetMapping("/byuser/{id}")
	public Collection<SportPlaceAssociationDtoRead> getSportPlaceAssociationsByUserId(@PathVariable("id") Long id) {
		return sportPlaceAssociationService.getAllSportPlaceAssociationByUserId(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public void updateSportPlaceAssociation(@PathVariable("id") Long id,
			@RequestBody SportPlaceAssociationDtoCreate sportPlaceAssociationDtoCreate) {
		sportPlaceAssociationService.updateSportPlaceAssociation(id, sportPlaceAssociationDtoCreate);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteSportPlaceAssociation(@PathVariable("id") Long id) {
		sportPlaceAssociationService.deleteSportPlaceAssociation(id);
	}

	// CREATE USERSPORT + BATCH
	@PostMapping("/createsportandbatch")
	@ResponseStatus(HttpStatus.CREATED)
	public void createMultipleSportPlaceAssociation(
			@RequestBody SportPlaceAssociationDtoBatch sportPlaceAssociationDtoBatch) {
		// create the userSport
		UserSport newUs = userSportService.createUserSport(sportPlaceAssociationDtoBatch.getUserSportDto());
		// then create the sportPlaceAssociations
		List<SportPlaceAssociationDtoCreate> spaList = sportPlaceAssociationDtoBatch.getSpaList();
		for (SportPlaceAssociationDtoCreate spa : spaList) {
			// use the id of the userSport newly created
			spa.setIdUserSport(newUs.getId());
			sportPlaceAssociationService.createSportPlaceAssociation(spa);
		}
	}

	// CREATE BATCH
	@PostMapping("/batch")
	@ResponseStatus(HttpStatus.CREATED)
	public void createSportPlaceAssociationBatch(@RequestBody List<SportPlaceAssociationDtoCreate> spaList) {

		for (SportPlaceAssociationDtoCreate spa : spaList) {
			sportPlaceAssociationService.createSportPlaceAssociation(spa);
		}
	}

	// DELETE BATCH
	@DeleteMapping("/batch")
	public void deleteSportPlaceAssociationBatch(@RequestHeader("data") List<Long> idList) {
		for (Long id : idList) {
			sportPlaceAssociationService.deleteSportPlaceAssociation(id);
		}
	}
}
