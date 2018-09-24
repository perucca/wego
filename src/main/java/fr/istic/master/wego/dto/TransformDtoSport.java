package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.UserSport;

import java.util.HashSet;

public class TransformDtoSport {

    public static SportDto transformToDto(Sport sport){
        SportDto sportDto = new SportDto();

        sportDto.setSportName(sport.getSportName());
        sportDto.setType(sport.getType());
        sportDto.setIdealWeather(sport.getIdealWeather());

        return sportDto;
    }

    public static Sport transformFromDto(SportDto sportDto){
        Sport sport = new Sport();

        sport.setSportName(sportDto.getSportName());
        sport.setType(sportDto.getType());
        sport.setIdealWeather(sportDto.getIdealWeather());

        sport.setUserSports(new HashSet<UserSport>());

        return sport;
    }
}
