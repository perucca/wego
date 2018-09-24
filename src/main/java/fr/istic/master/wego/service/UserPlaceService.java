package fr.istic.master.wego.service;

import java.util.ArrayList;
import fr.istic.master.wego.dao.PlaceDao;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserPlaceDao;
import fr.istic.master.wego.dto.TransformDtoPlace;
import fr.istic.master.wego.dto.TransformDtoUser;
import fr.istic.master.wego.dto.TransformDtoUserPlace;
import fr.istic.master.wego.dto.UserDto;
import fr.istic.master.wego.dto.UserPlaceDto;
import fr.istic.master.wego.model.UserPlace;

@Service
public class UserPlaceService {

    @Autowired
    private UserPlaceDao userPlaceDao;
    private PlaceDao placeDao;
    
    public Collection<UserPlaceDto> getAllUserPlace(){
        List<UserPlaceDto> listDto = new ArrayList<>();
        List<UserPlace> listDao = userPlaceDao.findAll();

        for(UserPlace userplace: listDao){
            listDto.add(TransformDtoUserPlace.transformToDto(userplace));
        }

        return listDto;
    }

    public Collection<UserPlaceDto> getAllUserPlacesByUserId(long id){
        List<UserPlace> userPlaces = userPlaceDao.findByUserId(id);
        List<UserPlaceDto> userPlaceDto = new ArrayList<>();

        for(UserPlace userPlace: userPlaces){
            userPlaceDto.add(TransformDtoUserPlace.transformToDto(userPlace));
        }
         
        return userPlaceDto;
    }

	public void deleteUserPlace(Long id) {
		userPlaceDao.deleteById(id);;
	}

	public void createUserPlace(UserPlaceDto userplaceDto, User u) {
		UserPlace userplace = new UserPlace();
		userplace.setUser(u);
		userplace.setPlace(placeDao.getOne(userplaceDto.getId()));
		userplace.setPreferenceOrder(userplaceDto.getPreferenceOrder());
		userPlaceDao.save(userplace);
	}
}

