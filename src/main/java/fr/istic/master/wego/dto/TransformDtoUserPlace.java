package fr.istic.master.wego.dto;


import fr.istic.master.wego.model.UserPlace;

public class TransformDtoUserPlace {
	
    public static UserPlaceDtoRead transformToDto(UserPlace userPlace){
        UserPlaceDtoRead userPlaceDto = new UserPlaceDtoRead();
        userPlaceDto.setIdUserplace(userPlace.getId());
        userPlaceDto.setPlaceDto(TransformDtoPlace.transformToDto(userPlace.getPlace()));
        userPlaceDto.setPreferenceOrder(userPlace.getPreferenceOrder());
        return userPlaceDto;
    }
    
//    public static UserPlace transformFromDto(UserPlaceDtoCreate userPlaceDto){
//        UserPlace userPlace = new UserPlace();
//        userPlace.setUser(userDao.getOne(userPlaceDto.getIdUser()));
//        userPlace.setPlace(placeDao.getOne(userPlaceDto.getIdPlace()));
//        userPlace.setPreferenceOrder(userPlaceDto.getPreferenceOrder());
//
//        return userPlace;
//    }
}

