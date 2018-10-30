package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.dto.TransformDtoUserSport;
import fr.istic.master.wego.dto.UserSportDtoCreate;
import fr.istic.master.wego.dto.UserSportDtoRead;
import fr.istic.master.wego.model.Sport;
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

	//CREATE
	public UserSport createUserSport(UserSportDtoCreate userSportDto) {
		Objects.requireNonNull(userSportDto);
		Objects.requireNonNull(userSportDto.getIdUser());
		Objects.requireNonNull(userSportDto.getIdSport());
		
		User user = userDao.getOne(userSportDto.getIdUser());

		Sport sport = sportDao.getOne(userSportDto.getIdSport());

		if (userSportDao.existsByUserAndSport(user, sport)) {
			throw new IllegalStateException("this userSport already exists");
		}
		
		UserSport us = new UserSport();
		us.setUser(user);
		us.setSport(sport);
		us.setPreferenceOrder(userSportDto.getPreferenceOrder());
		return userSportDao.save(us);
	}

	//READ
	public Collection<UserSportDtoRead> getAllUserSportByUserId(Long id) {
		Objects.requireNonNull(id);
		User user = userDao.getOne(id);

		List<UserSport> userSports = userSportDao.findByUser(user);
		List<UserSportDtoRead> userSportDtoRead = new ArrayList<>();

		for (UserSport userSport : userSports) {
			userSportDtoRead.add(TransformDtoUserSport.toDto(userSport));
		}

		return userSportDtoRead;
	}

	//UPDATE
	public void updateUserSport(Long id, UserSportDtoCreate userSportDto) {
		Objects.requireNonNull(id);
		Objects.requireNonNull(userSportDto);
		Objects.requireNonNull(userSportDto.getIdUser());
		Objects.requireNonNull(userSportDto.getIdSport());
		
		
		UserSport us = userSportDao.getOne(id);
		User user = userDao.getOne(userSportDto.getIdUser());
		Sport sport = sportDao.getOne(userSportDto.getIdSport());

		us.setId(id);
		us.setUser(user);
		us.setSport(sport);
		us.setPreferenceOrder(userSportDto.getPreferenceOrder());
		userSportDao.save(us);
	}

	//DELETE
	public void deleteUserSport(Long id) {
		Objects.requireNonNull(id);
		userSportDao.deleteById(id);
	}

}
