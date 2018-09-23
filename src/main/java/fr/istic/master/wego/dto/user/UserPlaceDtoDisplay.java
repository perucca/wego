package fr.istic.master.wego.dto.user;

import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.User;

public class UserPlaceDtoDisplay {

	private PlaceDto place;
	private float preferenceOrder;
	
	public UserPlaceDtoDisplay() {}
	
	public UserPlaceDtoDisplay(PlaceDto place, float preferenceOrder) {
		this.place = place;
		this.preferenceOrder = preferenceOrder;
	}
	
	public PlaceDto getPlace() {
		return place;
	}
	public void setPlace(PlaceDto place) {
		this.place = place;
	}
	public float getPreferenceOrder() {
		return preferenceOrder;
	}
	public void setPreferenceOrder(float preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + Float.floatToIntBits(preferenceOrder);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPlaceDtoDisplay other = (UserPlaceDtoDisplay) obj;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (Float.floatToIntBits(preferenceOrder) != Float.floatToIntBits(other.preferenceOrder))
			return false;
		return true;
	}

	
}
