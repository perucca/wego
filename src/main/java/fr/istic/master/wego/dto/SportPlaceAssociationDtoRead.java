package fr.istic.master.wego.dto;

public class SportPlaceAssociationDtoRead {
    private Long id;
    private UserSportDtoRead userSportDtoRead;
    private UserPlaceDtoRead userPlaceDtoRead;

    public SportPlaceAssociationDtoRead() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserSportDtoRead getUserSportDtoRead() {
        return userSportDtoRead;
    }

    public void setUserSportDtoRead(UserSportDtoRead userSportDtoRead) {
        this.userSportDtoRead = userSportDtoRead;
    }

    public UserPlaceDtoRead getUserPlaceDtoRead() {
        return userPlaceDtoRead;
    }

    public void setUserPlaceDtoRead(UserPlaceDtoRead userPlaceDtoRead) {
        this.userPlaceDtoRead = userPlaceDtoRead;
    }
}
