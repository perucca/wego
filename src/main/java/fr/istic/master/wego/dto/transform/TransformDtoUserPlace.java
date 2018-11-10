package fr.istic.master.wego.dto.transform;

import fr.istic.master.wego.dto.UserPlaceDtoCreate;
import fr.istic.master.wego.dto.UserPlaceDtoRead;
import fr.istic.master.wego.model.UserPlace;

public class TransformDtoUserPlace {

	public static UserPlaceDtoRead transformToDto(UserPlace userPlace) {
		UserPlaceDtoRead userPlaceDto = new UserPlaceDtoRead();
		userPlaceDto.setIdUserplace(userPlace.getId());
		userPlaceDto.setPlaceDto(TransformDtoPlace.transformToDto(userPlace.getPlace()));
		userPlaceDto.setPreferenceOrder(userPlace.getPreferenceOrder());
		return userPlaceDto;
	}

	public static UserPlace transformFromDto(UserPlaceDtoCreate userPlaceDto, UserPlace u) {
		u.setPreferenceOrder(userPlaceDto.getPreferenceOrder());
		return u;
	}
}
