package fr.istic.master.wego.dto;

public class UserPlaceDtoRead {

	// on a pas besoin de passer des éléments sur le user car on appelle depuis le user courant
	private Long idUserplace;
    private PlaceDto placeDto;
    private float preferenceOrder;

    public UserPlaceDtoRead() {
    }

	public Long getIdUserplace() {
		return idUserplace;
	}

	public void setIdUserplace(Long idUserplace) {
		this.idUserplace = idUserplace;
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
