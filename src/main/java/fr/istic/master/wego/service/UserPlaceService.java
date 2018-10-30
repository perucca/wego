package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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
		Objects.requireNonNull(user);
		List<UserPlace> userPlaces = userPlaceDao.findByUser(user);
		List<UserPlaceDtoRead> userPlaceDto = new ArrayList<>();

		for (UserPlace userPlace : userPlaces) {
			userPlaceDto.add(TransformDtoUserPlace.transformToDto(userPlace));
		}

		return userPlaceDto;
	}

	public void deleteUserPlace(Long id) {
		Objects.requireNonNull(id);
		userPlaceDao.deleteById(id);
	}

	public void createUserPlace(UserPlaceDtoCreate userplaceDto) {
		Objects.requireNonNull(userplaceDto);
		Objects.requireNonNull(userplaceDto.getIdUser());
		Objects.requireNonNull(userplaceDto.getIdPlace());

		User user = userDao.getOne(userplaceDto.getIdUser());
		Place place = placeDao.getOne(userplaceDto.getIdPlace());

		if (userPlaceDao.existsByUserAndPlace(user, place))
			throw new IllegalStateException("Le userPlace existe déjà");

		UserPlace up = new UserPlace();
		up.setUser(user);
		up.setPlace(place);
		up.setPreferenceOrder(userplaceDto.getPreferenceOrder());
		userPlaceDao.save(up);
	}

	public void updateUserPlace(Long id, UserPlaceDtoCreate userplaceDto) {
		Objects.requireNonNull(id);
		Objects.requireNonNull(userplaceDto);
		UserPlace u = userPlaceDao.getOne(id);
		userPlaceDao.save(TransformDtoUserPlace.transformFromDto(userplaceDto, u));
	}

}
