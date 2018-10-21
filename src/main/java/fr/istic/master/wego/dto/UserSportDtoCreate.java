package fr.istic.master.wego.dto;

public class UserSportDtoCreate {

    private Long idUser;
    private Long idSport;
    private float preferenceOrder;

    public UserSportDtoCreate() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdSport() {
        return idSport;
    }

    public void setIdSport(Long idSport) {
        this.idSport = idSport;
    }

    public float getPreferenceOrder() {
        return preferenceOrder;
    }

    public void setPreferenceOrder(float preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }
}
