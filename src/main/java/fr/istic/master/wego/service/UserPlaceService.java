package fr.istic.master.wego.service;

import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dto.SportDto;
import fr.istic.master.wego.dto.TransformDtoSport;
import fr.istic.master.wego.dto.TransformDtoUserPlace;
import fr.istic.master.wego.dto.UserPlaceDto;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserPlaceService {

    @Autowired
    private UserPlaceDao userPlaceDao;

    public Collection<UserPlaceDto> getAllUserPlacesByUserId(long id){
        List<UserPlace> userPlaces = userPlaceDao.findByUserId(id);
        List<UserPlaceDto> userPlaceDto = new ArrayList<>();

        for(UserPlace userPlace: userPlaces){
            userPlaceDto.add(TransformDtoUserPlace.transformToDto(userPlace));
        }

        return userPlaceDto;
    }
}

