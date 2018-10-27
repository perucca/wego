package fr.istic.master.wego.service;

import fr.istic.master.wego.dao.*;
import fr.istic.master.wego.dto.*;
import fr.istic.master.wego.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SportPlaceAssociationService {

    @Autowired
    SportPlaceAssociationDao sportPlaceAssociationDao;
    @Autowired
    UserPlaceDao userPlaceDao;
    @Autowired
    UserSportDao userSportDao;
    @Autowired
    UserDao userDao;

    //CREATE
    public SportPlaceAssociation createSportPlaceAssociation(SportPlaceAssociationDtoCreate sportPlaceAssociationDto) {
    	Objects.requireNonNull(sportPlaceAssociationDto);
    	Objects.requireNonNull(sportPlaceAssociationDto.getIdUserPlace());
    	Objects.requireNonNull(sportPlaceAssociationDto.getIdUserSport());
    	
        UserSport userSport = userSportDao.getOne(sportPlaceAssociationDto.getIdUserSport());
        
        UserPlace userPlace = userPlaceDao.getOne(sportPlaceAssociationDto.getIdUserPlace());

        if (sportPlaceAssociationDao.existsByUsersportAndUserplace(userSport, userPlace)) {
        	throw new IllegalStateException("The SportPlaceAssocitation already exists");
        }
        
        SportPlaceAssociation spa = new SportPlaceAssociation();
        spa.setUsersport(userSport);
        spa.setUserplace(userPlace);
        return sportPlaceAssociationDao.save(spa);
    }

    //READ
    public Collection<SportPlaceAssociationDtoRead> getAllSportPlaceAssociationByUserId(Long id) {
    	Objects.requireNonNull(id);
        User user = userDao.getOne(id);

        List<SportPlaceAssociation> sportPlaceAssociations = sportPlaceAssociationDao.findByUser(user);
        List<SportPlaceAssociationDtoRead> sportPlaceAssociationDtoList = new ArrayList<>();

        for (SportPlaceAssociation sportPlaceAssociation : sportPlaceAssociations) {
            sportPlaceAssociationDtoList.add(TransformDtoSportPlaceAssociation.toDto(sportPlaceAssociation));
        }

        return sportPlaceAssociationDtoList;
    }

    //UPDATE
    public void updateSportPlaceAssociation(Long id, SportPlaceAssociationDtoCreate sportPlaceAssociationDto) {
      	Objects.requireNonNull(id);
    	Objects.requireNonNull(sportPlaceAssociationDto);
    	Objects.requireNonNull(sportPlaceAssociationDto.getIdUserPlace());
    	Objects.requireNonNull(sportPlaceAssociationDto.getIdUserSport());
    	
        SportPlaceAssociation spa = sportPlaceAssociationDao.getOne(id);
        UserSport userSport = userSportDao.getOne(id);
        UserPlace userPlace = userPlaceDao.getOne(id);

        spa.setId(id);
        spa.setUsersport(userSport);
        spa.setUserplace(userPlace);
        sportPlaceAssociationDao.save(spa);
    }

    //DELETE
    public void deleteSportPlaceAssociation(Long id) {
      	Objects.requireNonNull(id);
        sportPlaceAssociationDao.deleteById(id);
    }
}
