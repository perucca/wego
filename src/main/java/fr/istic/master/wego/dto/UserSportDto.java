package fr.istic.master.wego.dto;

public class UserSportDto {
    private SportDto sportDto;
    private float preferenceOrder;

    public UserSportDto() {
    }

    public SportDto getSportDto() {
        return sportDto;
    }

    public void setSportDto(SportDto sportDto) {
        this.sportDto = sportDto;
    }

    public float getPreferenceOrder() {
        return preferenceOrder;
    }

    public void setPreferenceOrder(float preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }
}
