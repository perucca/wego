package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.UserSport;

public class TransformDtoSportPlaceAssociation {

    public static SportPlaceAssociationDtoRead toDto(SportPlaceAssociation sportPlaceAssociation){
        SportPlaceAssociationDtoRead sportPlaceAssociationDtoRead = new SportPlaceAssociationDtoRead();
        sportPlaceAssociationDtoRead.setId(sportPlaceAssociation.getId());
        sportPlaceAssociationDtoRead.setUserSportDtoRead(TransformDtoUserSport.toDto(sportPlaceAssociation.getUsersport()));
        sportPlaceAssociationDtoRead.setUserPlaceDtoRead(TransformDtoUserPlace.transformToDto(sportPlaceAssociation.getUserplace()));

        return sportPlaceAssociationDtoRead;
    }

}
