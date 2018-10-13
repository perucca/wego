package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dto.TransformDtoUserPlace;
import fr.istic.master.wego.dto.UserPlaceDtoCreate;
import fr.istic.master.wego.dto.UserPlaceDtoRead;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;

@Service
public class UserPlaceService {
	@Autowired
	UserPlaceDao userPlaceDao;
	@Autowired
	UserDao userDao;
	@Autowired
	PlaceDao placeDao;

	public Collection<UserPlaceDtoRead> getAllUserPlace() {
		List<UserPlaceDtoRead> listDto = new ArrayList<>();
		List<UserPlace> listDao = userPlaceDao.findAll();

		for (UserPlace userplace : listDao) {
			listDto.add(TransformDtoUserPlace.transformToDto(userplace));
		}

		return listDto;
	}

	public Collection<UserPlaceDtoRead> getAllUserPlacesByUser(User user) {
		List<UserPlace> userPlaces = userPlaceDao.findByUser(user);
		List<UserPlaceDtoRead> userPlaceDto = new ArrayList<>();

		for (UserPlace userPlace : userPlaces) {
			userPlaceDto.add(TransformDtoUserPlace.transformToDto(userPlace));
		}

		return userPlaceDto;
	}

	public void deleteUserPlace(Long id) {
		userPlaceDao.deleteById(id);
	}

	public void createUserPlace(UserPlaceDtoCreate userplaceDto) {
		User user = userDao.findById(userplaceDto.getIdUser())
				.orElseThrow(() -> new RuntimeException("User: " + userplaceDto.getIdUser() + " not found!"));

		Place place = placeDao.findById(userplaceDto.getIdPlace())
				.orElseThrow(() -> new RuntimeException("Place: " + userplaceDto.getIdPlace() + " not found!"));

		if (!userPlaceDao.existsByUserAndPlace(user, place)) {
			UserPlace up = new UserPlace();
			up.setUser(user);
			up.setPlace(place);
			up.setPreferenceOrder(userplaceDto.getPreferenceOrder());
			userPlaceDao.save(up);
		} else {
			System.err.println("Le userPlace existe déjà");
		}
	}

	public void updateUserPlace(Long id, UserPlaceDtoCreate userplaceDto) {
		UserPlace u = userPlaceDao.getOne(id);
		userPlaceDao.save(TransformDtoUserPlace.transformFromDto(userplaceDto, u));
	}

}
