package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import fr.istic.master.wego.dao.SportPlaceAssociationDao;
import fr.istic.master.wego.model.SportPlaceAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dto.UserPlaceDtoCreate;
import fr.istic.master.wego.dto.UserPlaceDtoRead;
import fr.istic.master.wego.dto.transform.TransformDtoUserPlace;
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
	@Autowired
	private SportPlaceAssociationDao spaDao;

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

	@Transactional
	public void deleteUserPlaceAndUpdate(Long iduser, Long iduserplace) {
		Objects.requireNonNull(iduser);
		Objects.requireNonNull(iduserplace);

		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User not found!"));
		List<UserPlace> userplaces = userPlaceDao.findByUser(user);

		UserPlace u = userPlaceDao.getOne(iduserplace);
		int pref = u.getPreferenceOrder();

		userplaces.stream().filter(up -> (up.getPreferenceOrder()) > pref)
				.forEach(up -> increaseUserPlacePreference(up.getId()));

		List<SportPlaceAssociation> spasToDelete = spaDao.findAllByUserPlaceId(iduserplace);

		for (SportPlaceAssociation spa: spasToDelete) {
			spaDao.delete(spa);
		}

		userPlaceDao.deleteById(iduserplace);
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

	public void increaseUserPlacePreference(Long id) {
		Objects.requireNonNull(id);

		UserPlace u = userPlaceDao.getOne(id);
		u.setPreferenceOrder(u.getPreferenceOrder() - 1);
		userPlaceDao.save(u);
	}

	public void decreaseUserPlacePreference(Long id) {
		Objects.requireNonNull(id);

		UserPlace u = userPlaceDao.getOne(id);
		u.setPreferenceOrder(u.getPreferenceOrder() + 1);
		userPlaceDao.save(u);
	}

	@Transactional
	public void increaseUserPlace(Long iduserplace, Long iduser) {
		Objects.requireNonNull(iduser);
		Objects.requireNonNull(iduserplace);

		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User not found!"));
		List<UserPlace> userplaces = userPlaceDao.findByUser(user);

		UserPlace u = userPlaceDao.getOne(iduserplace);
		int pref = u.getPreferenceOrder();
		if (pref > 1) {
			userplaces.stream().filter(up -> (up.getPreferenceOrder()) == (pref - 1))
					.forEach(up -> decreaseUserPlacePreference(up.getId()));
			increaseUserPlacePreference(iduserplace);
		}
	}

	@Transactional
	public void decreaseUserPlace(Long iduserplace, Long iduser) {
		Objects.requireNonNull(iduser);
		Objects.requireNonNull(iduserplace);

		User user = userDao.findById(iduser).orElseThrow(() -> new RuntimeException("User not found!"));
		List<UserPlace> userplaces = userPlaceDao.findByUser(user);

		UserPlace u = userPlaceDao.getOne(iduserplace);
		int pref = u.getPreferenceOrder();

		List<UserPlace> listToChange = userplaces.stream().filter(up -> (up.getPreferenceOrder()) == (pref + 1))
				.collect(Collectors.toList());

		if (listToChange.size() > 0) {
			listToChange.forEach(up -> increaseUserPlacePreference(up.getId()));
			decreaseUserPlacePreference(iduserplace);
		}

	}

	//UPDATE BATCH
	public void updateUserPlaceBatch(List<UserPlaceDtoRead> userPlaceDtoReads) {
		for (UserPlaceDtoRead upd : userPlaceDtoReads) {
			Objects.requireNonNull(upd);
			Objects.requireNonNull(upd.getIdUserplace());
			Objects.requireNonNull(upd.getPreferenceOrder());
			Objects.requireNonNull(upd.getPlaceDto());

			UserPlace up = userPlaceDao.getOne(upd.getIdUserplace());
			Place place = placeDao.getOne(upd.getPlaceDto().getId());

			up.setPlace(place);
			up.setPreferenceOrder((int)upd.getPreferenceOrder());
			userPlaceDao.save(up);
		}
	}

}
