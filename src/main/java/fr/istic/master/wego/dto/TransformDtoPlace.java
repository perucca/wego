package fr.istic.master.wego.dto;

import java.util.HashSet;

import fr.istic.master.wego.model.Forecast;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.UserPlace;

public class TransformDtoPlace {

    public static PlaceDto transformToDto(Place place){
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setPostCode(place.getPostCode());

        return placeDto;
    }

    public static Place transformFromDto(PlaceDto placeDto){
        Place place = new Place();

        place.setName(placeDto.getName());
        place.setPostCode(placeDto.getPostCode());

        place.setUserPlaces(new HashSet<UserPlace>());
        place.setForecast(new Forecast());

        return place;
    }
}
