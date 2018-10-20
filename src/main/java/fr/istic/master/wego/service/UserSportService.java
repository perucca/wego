package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dto.UserSportDtoCreate;
import fr.istic.master.wego.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.dto.TransformDtoUserSport;
import fr.istic.master.wego.dto.UserSportDtoRead;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserSport;

@Service
public class UserSportService {

	@Autowired
	private UserSportDao userSportDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private SportDao sportDao;

	public Collection<UserSportDtoRead> getAllUserSportByUserId(long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

		List<UserSport> userSports = userSportDao.findByUser(user);
		List<UserSportDtoRead> userSportDtoRead = new ArrayList<>();

		for (UserSport userSport : userSports) {
			userSportDtoRead.add(TransformDtoUserSport.toDto(userSport));
		}

		return userSportDtoRead;
	}

	public void createUserSport(UserSportDtoCreate userSportDto) {
		User user = userDao.findById(userSportDto.getIdUser())
				.orElseThrow(() -> new RuntimeException("User: " + userSportDto.getIdUser() + " not found!"));

		Sport sport = sportDao.findById(userSportDto.getIdSport())
				.orElseThrow(() -> new RuntimeException("Place: " + userSportDto.getIdSport() + " not found!"));

		if (!userSportDao.existsByUserAndSport(user, sport)) {
			UserSport us = new UserSport();
			us.setUser(user);
			us.setSport(sport);
			us.setPreferenceOrder(userSportDto.getPreferenceOrder());
			userSportDao.save(us);
		} else {
			System.err.println("this userPlace already exists");
		}
	}

}
