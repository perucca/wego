package fr.istic.master.wego.dto;

public class UserPlaceDtoCreate {

	private Long idUser;
    private Long idPlace;
    private float preferenceOrder;

    public UserPlaceDtoCreate() {
    }

    public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Long idPlace) {
		this.idPlace = idPlace;
	}

	public float getPreferenceOrder() {
        return preferenceOrder;
    }

    public void setPreferenceOrder(float preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }
}
