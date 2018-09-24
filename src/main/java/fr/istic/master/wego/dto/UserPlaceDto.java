package fr.istic.master.wego.dto;

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
