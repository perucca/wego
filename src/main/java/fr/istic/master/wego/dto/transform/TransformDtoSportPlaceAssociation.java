package fr.istic.master.wego.dto.transform;

import fr.istic.master.wego.dto.SportPlaceAssociationDtoRead;
import fr.istic.master.wego.model.SportPlaceAssociation;

public class TransformDtoSportPlaceAssociation {

    public static SportPlaceAssociationDtoRead toDto(SportPlaceAssociation sportPlaceAssociation){
        SportPlaceAssociationDtoRead sportPlaceAssociationDtoRead = new SportPlaceAssociationDtoRead();
        sportPlaceAssociationDtoRead.setId(sportPlaceAssociation.getId());
        sportPlaceAssociationDtoRead.setUserSportDtoRead(TransformDtoUserSport.toDto(sportPlaceAssociation.getUsersport()));
        sportPlaceAssociationDtoRead.setUserPlaceDtoRead(TransformDtoUserPlace.transformToDto(sportPlaceAssociation.getUserplace()));

        return sportPlaceAssociationDtoRead;
    }

}
