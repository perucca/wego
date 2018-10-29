package fr.istic.master.wego.dto;

import java.util.List;

public class SportPlaceAssociationDtoBatch {
    List<SportPlaceAssociationDtoCreate> spaList;
    UserSportDtoCreate userSportDto;

    public SportPlaceAssociationDtoBatch() {
    }

    public List<SportPlaceAssociationDtoCreate> getSpaList() {
        return spaList;
    }

    public void setSpaList(List<SportPlaceAssociationDtoCreate> spaList) {
        this.spaList = spaList;
    }

    public UserSportDtoCreate getUserSportDto() {
        return userSportDto;
    }

    public void setUserSportDto(UserSportDtoCreate userSportDto) {
        this.userSportDto = userSportDto;
    }
}
