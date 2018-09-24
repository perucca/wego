package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.dto.TransformDtoPlace;
import fr.istic.master.wego.model.Place;

@Service
public class PlaceService {

    @Autowired
    private PlaceDao placeDao;

    public Collection<PlaceDto> getAllPlaces(){
        List<PlaceDto> listDto = new ArrayList<>();
        List<Place> listDao = placeDao.findAll();

        for(Place place: listDao){
            listDto.add(TransformDtoPlace.transformToDto(place));
        }

        return listDto;
    }

    public PlaceDto getPlacesById(long id){
        Place place = placeDao.findById(id).orElse(null);
        if (place.equals(null)){
            return null;
        }else{
            return TransformDtoPlace.transformToDto(place);
        }
    }

    public Collection<PlaceDto> getAllPlacesByName(String name){
        Set<Place> places = placeDao.findAllByName(name);
        Set<PlaceDto> placesDto = new HashSet<>();

        for(Place place: places){
            placesDto.add(TransformDtoPlace.transformToDto(place));
        }

        return placesDto;
    }

    public Collection<PlaceDto> getAllPlacesByPostCode(String postCode){
        Set<Place> places = placeDao.findAllByPostCode(postCode);
        Set<PlaceDto> placesDto = new HashSet<>();

        for(Place place: places){
            placesDto.add(TransformDtoPlace.transformToDto(place));
        }

        return placesDto;
    }
}
