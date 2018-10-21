package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.UserSport;

public class TransformDtoUserSport {

    public static UserSportDtoRead toDto(UserSport userSport){
        UserSportDtoRead userSportDtoRead = new UserSportDtoRead();
        userSportDtoRead.setIdUserSport(userSport.getId());
        userSportDtoRead.setSportDto(TransformDtoSport.transformToDto(userSport.getSport()));
        userSportDtoRead.setPreferenceOrder(userSport.getPreferenceOrder());

        return userSportDtoRead;
    }
}
