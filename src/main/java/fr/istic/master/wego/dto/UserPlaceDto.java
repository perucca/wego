package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;

import java.util.HashSet;
import java.util.Set;

public class UserPlaceDto {

	private Long id;
    private PlaceDto placeDto;
    private float preferenceOrder;

    public UserPlaceDto() {
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
