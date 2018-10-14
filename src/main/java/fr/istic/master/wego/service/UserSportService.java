package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserSportDao;
import fr.istic.master.wego.dto.TransformDtoUserSport;
import fr.istic.master.wego.dto.UserSportDto;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserSport;

@Service
public class UserSportService {

	@Autowired
	private UserSportDao userSportDao;

	@Autowired
	private UserDao userDao;

	public Collection<UserSportDto> getAllUserSportByUserId(long id) {
		User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

		List<UserSport> userSports = userSportDao.findByUser(user);
		List<UserSportDto> userSportDto = new ArrayList<>();

		for (UserSport userSport : userSports) {
			userSportDto.add(TransformDtoUserSport.toDto(userSport));
		}

		return userSportDto;
	}

}
