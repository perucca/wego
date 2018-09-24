package fr.istic.master.wego.dto;

public class UserPlaceDto {

    private PlaceDto placeDto;
    private float preferenceOrder;

    public UserPlaceDto() {
    }

    public PlaceDto getPlaceDto() {
        return placeDto;
    }

    public void setPlaceDto(PlaceDto placeDto) {
        this.placeDto = placeDto;
    }

    public float getPreferenceOrder() {
        return preferenceOrder;
    }

    public void setPreferenceOrder(float preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }
}
