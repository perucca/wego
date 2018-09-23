package fr.istic.master.wego.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.dto.user.UserDtoCreate;
import fr.istic.master.wego.dto.user.UserDtoDisplay;
import fr.istic.master.wego.dto.user.UserPlaceDtoDisplay;
import fr.istic.master.wego.dto.user.UserSportDto;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

/**
 * @author amontuwy Provides REST services for the User To Be Done
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	// Services to create a User

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid UserDtoCreate udto) {
		User u = new User();
		u.setFirstName(udto.getFirstName());
		u.setLastName(udto.getLastName());
		u.setMail(udto.getMail());
		u.setPassword(udto.getPassword());
		userDao.save(u);
	}

	// Services to read a User
	@GetMapping("/{id}")
	public UserDtoDisplay getUserById(@PathVariable("id") Long id) {
		User u = userDao.getOne(id);
		UserDtoDisplay udtod = new UserDtoDisplay();
		udtod.setFirstName(u.getFirstName());
		udtod.setLastName(u.getLastName());
		udtod.setId(u.getId());
		udtod.setMail(u.getMail());
		Set<UserPlaceDtoDisplay> upd = new HashSet<UserPlaceDtoDisplay>();
		Set<UserPlace> uplist = u.getMyPlaces();
		for (UserPlace p : uplist) {
			UserPlaceDtoDisplay tmp = new UserPlaceDtoDisplay();
			PlaceDto pdto = new PlaceDto(p.getPlace().getId(), p.getPlace().getName(), p.getPlace().getPostCode());
			tmp.setPlace(pdto);
			tmp.setPreferenceOrder(p.getPreferenceOrder());
			upd.add(tmp);
		}
		udtod.setMyPlaces(upd);
		// A modifier en fonction du UserSportDTO que fera Dorian
		Set<UserSportDto> usd = new HashSet<UserSportDto>();
		for (UserSport s : u.getMySports()) {
			UserSportDto tmp = new UserSportDto(s.getSport().getSportName(), s.getPreferenceOrder());
			usd.add(tmp);
		}
		udtod.setMySports(usd);
		return udtod;
	}

	@GetMapping("/by_email/{email}")
	public Optional<User> getUserByEmail(@PathVariable("email") String email) {
		return userDao.findByEmail(email);
	}

	@GetMapping("")
	public Collection<User> getAllUsers() {
		return userDao.findAll();
	}

	// Services to update a User
	@PutMapping("/{id}")
	public void updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserDtoCreate udto) {
		User u = userDao.getOne(id);
		u.setFirstName(udto.getFirstName());
		u.setLastName(udto.getLastName());
		u.setMail(udto.getMail());
		u.setPassword(udto.getPassword());
		userDao.save(u);
	}

	// Services to delete a User
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userDao.deleteById(id);
		System.err.println("Le compte utilisateur a été supprimé");
	}

}
