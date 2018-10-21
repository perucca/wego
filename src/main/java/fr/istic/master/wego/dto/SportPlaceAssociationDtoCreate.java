package fr.istic.master.wego.dto;

public class SportPlaceAssociationDtoCreate {

    private Long idUserSport;
    private Long idUserPlace;

    public SportPlaceAssociationDtoCreate() {
    }

    public Long getIdUserSport() {
        return idUserSport;
    }

    public void setIdUserSport(Long idUserSport) {
        this.idUserSport = idUserSport;
    }

    public Long getIdUserPlace() {
        return idUserPlace;
    }

    public void setIdUserPlace(Long idUserPlace) {
        this.idUserPlace = idUserPlace;
    }
}
