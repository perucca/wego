package fr.istic.master.wego.dto.user;

import java.util.HashSet;
import java.util.Set;

import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;

public class UserPlaceDtoCreate {

	private Long userid;
	private Long placeid;
	private float preferenceOrder;
	
	public UserPlaceDtoCreate() {};
	
	public UserPlaceDtoCreate(Long userid, Long placeid,Float preference) {
		this.userid=userid;
		this.placeid = placeid;
		this.preferenceOrder=preference;
	}
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getPlaceid() {
		return placeid;
	}
	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
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
		result = prime * result + ((placeid == null) ? 0 : placeid.hashCode());
		result = prime * result + Float.floatToIntBits(preferenceOrder);
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		UserPlaceDtoCreate other = (UserPlaceDtoCreate) obj;
		if (placeid == null) {
			if (other.placeid != null)
				return false;
		} else if (!placeid.equals(other.placeid))
			return false;
		if (Float.floatToIntBits(preferenceOrder) != Float.floatToIntBits(other.preferenceOrder))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
}
