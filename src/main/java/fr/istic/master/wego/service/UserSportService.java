package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dto.SportPlaceAssociationDtoCreate;
import fr.istic.master.wego.dto.UserSportDtoCreate;
import fr.istic.master.wego.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.dto.TransformDtoUserSport;
import fr.istic.master.wego.dto.UserSportDtoRead;

@Service
public class UserSportService {

	@Autowired
	private UserSportDao userSportDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private SportDao sportDao;

	//CREATE
	public void createUserSport(UserSportDtoCreate userSportDto) {
		User user = userDao.findById(userSportDto.getIdUser())
				.orElseThrow(() -> new RuntimeException("User: " + userSportDto.getIdUser() + " not found!"));

		Sport sport = sportDao.findById(userSportDto.getIdSport())
				.orElseThrow(() -> new RuntimeException("Sport: " + userSportDto.getIdSport() + " not found!"));

		if (!userSportDao.existsByUserAndSport(user, sport)) {
			UserSport us = new UserSport();
			us.setUser(user);
			us.setSport(sport);
			us.setPreferenceOrder(userSportDto.getPreferenceOrder());
			userSportDao.save(us);
		} else {
			System.err.println("this userSport already exists");
		}
	}

	//READ
	public Collection<UserSportDtoRead> getAllUserSportByUserId(long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

		List<UserSport> userSports = userSportDao.findByUser(user);
		List<UserSportDtoRead> userSportDtoRead = new ArrayList<>();

		for (UserSport userSport : userSports) {
			userSportDtoRead.add(TransformDtoUserSport.toDto(userSport));
		}

		return userSportDtoRead;
	}

	//UPDATE
	public void updateUserSport(Long id, UserSportDtoCreate userSportDto) {
		UserSport us = userSportDao.findById(id)
				.orElseThrow(() -> new RuntimeException("UserSport with id=" + id + " not found!"));

		User user = userDao.findById(userSportDto.getIdUser())
				.orElseThrow(() -> new RuntimeException("User with id=" + userSportDto.getIdUser() + " not found!"));

		Sport sport = sportDao.findById(userSportDto.getIdSport())
				.orElseThrow(() -> new RuntimeException("Sport with id=" + userSportDto.getIdSport() + " not found!"));

		UserSport newUs = new UserSport();
		newUs.setId(id);
		newUs.setUser(user);
		newUs.setSport(sport);
		newUs.setPreferenceOrder(userSportDto.getPreferenceOrder());
		userSportDao.save(newUs);
	}

	//DELETE
	public void deleteUserSport(Long id) {
		userSportDao.deleteById(id);
	}

}
