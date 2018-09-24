package fr.istic.master.wego.dto;


import java.util.HashSet;

import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

public class TransformDtoUserPlace {
	
    public static UserPlaceDto transformToDto(UserPlace userPlace){
        UserPlaceDto userPlaceDto = new UserPlaceDto();
        userPlaceDto.setId(userPlace.getId());
        userPlaceDto.setPlaceDto(TransformDtoPlace.transformToDto(userPlace.getPlace()));
        userPlaceDto.setPreferenceOrder(userPlace.getPreferenceOrder());

        return userPlaceDto;
    }
    
    public static UserPlace transformFromDto(UserPlaceDto userPlaceDto){
        UserPlace userPlace = new UserPlace();

        userPlace.setPlace(TransformDtoPlace.transformFromDto(userPlaceDto.getPlaceDto()));
        userPlace.setPreferenceOrder(userPlaceDto.getPreferenceOrder());

        return userPlace;
    }
}

