package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.UserSport;

public class TransformDtoUserSport {

    public static UserSportDto toDto(UserSport userSport){
        UserSportDto userSportDto = new UserSportDto();

        userSportDto.setSportDto(TransformDtoSport.transformToDto(userSport.getSport()));
        userSportDto.setPreferenceOrder(userSport.getPreferenceOrder());

        return userSportDto;
    }
}
