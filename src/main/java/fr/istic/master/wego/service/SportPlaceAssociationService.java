package fr.istic.master.wego.service;

import fr.istic.master.wego.dao.*;
import fr.istic.master.wego.dto.*;
import fr.istic.master.wego.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        UserSport userSport = userSportDao.findById(sportPlaceAssociationDto.getIdUserSport())
                .orElseThrow(() -> new RuntimeException("User: " + sportPlaceAssociationDto.getIdUserSport() + " not found!"));

        UserPlace userPlace = userPlaceDao.findById(sportPlaceAssociationDto.getIdUserPlace())
                .orElseThrow(() -> new RuntimeException("Place: " + sportPlaceAssociationDto.getIdUserPlace() + " not found!"));

        if (!sportPlaceAssociationDao.existsByUsersportAndUserplace(userSport, userPlace)) {
            SportPlaceAssociation spa = new SportPlaceAssociation();
            spa.setUsersport(userSport);
            spa.setUserplace(userPlace);
            return sportPlaceAssociationDao.save(spa);
        } else {
            System.err.println("The SportPlaceAssocitation already exists");
            return null;
        }
    }

    //READ
    public Collection<SportPlaceAssociationDtoRead> getAllSportPlaceAssociationByUserId(long id) {
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User: " + id + " not found!"));

        List<SportPlaceAssociation> sportPlaceAssociations = sportPlaceAssociationDao.findByUser(user);
        List<SportPlaceAssociationDtoRead> sportPlaceAssociationDtoList = new ArrayList<>();

        for (SportPlaceAssociation sportPlaceAssociation : sportPlaceAssociations) {
            sportPlaceAssociationDtoList.add(TransformDtoSportPlaceAssociation.toDto(sportPlaceAssociation));
        }

        return sportPlaceAssociationDtoList;
    }

    //UPDATE
    public void updateSportPlaceAssociation(Long id, SportPlaceAssociationDtoCreate sportPlaceAssociationDto) {
        SportPlaceAssociation spa = sportPlaceAssociationDao.findById(id)
                .orElseThrow(() -> new RuntimeException("SportPlaceAssociation with id=" + id + " not found!"));

        UserSport userSport = userSportDao.findById(sportPlaceAssociationDto.getIdUserSport())
                .orElseThrow(() -> new RuntimeException("User: " + sportPlaceAssociationDto.getIdUserSport() + " not found!"));

        UserPlace userPlace = userPlaceDao.findById(sportPlaceAssociationDto.getIdUserPlace())
                .orElseThrow(() -> new RuntimeException("Place: " + sportPlaceAssociationDto.getIdUserPlace() + " not found!"));

        SportPlaceAssociation newSpa = new SportPlaceAssociation();
        newSpa.setId(id);
        newSpa.setUsersport(userSport);
        newSpa.setUserplace(userPlace);
        sportPlaceAssociationDao.save(newSpa);
    }

    //DELETE
    public void deleteSportPlaceAssociation(Long id) {
        sportPlaceAssociationDao.deleteById(id);
    }
}
