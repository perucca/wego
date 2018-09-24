package fr.istic.master.wego.dto;


import fr.istic.master.wego.model.UserPlace;

public class TransformDtoUserPlace {
    public static UserPlaceDto transformToDto(UserPlace userPlace){
        UserPlaceDto userPlaceDto = new UserPlaceDto();

        userPlaceDto.setPlaceDto(TransformDtoPlace.transformToDto(userPlace.getPlace()));
        userPlaceDto.setPreferenceOrder(userPlace.getPreferenceOrder());

        return userPlaceDto;
    }
}
