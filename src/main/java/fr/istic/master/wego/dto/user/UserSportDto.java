package fr.istic.master.wego.dto.user;

import java.util.HashSet;
import java.util.Set;

import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;

public class UserSportDto {

	//private Long idUserSport;
	private String sportName;
	private long preferenceOrder;
	
//	public Long getIdUserSport() {
//		return idUserSport;
//	}
//	public void setIdUserSport(Long idUserSport) {
//		this.idUserSport = idUserSport;
//	}
	
	public UserSportDto () {};
	
	public UserSportDto(String sportName, long preferenceOrder) {
		this.sportName=sportName;
		this.preferenceOrder=preferenceOrder;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public long getPreferenceOrder() {
		return preferenceOrder;
	}
	public void setPreferenceOrder(long preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (preferenceOrder ^ (preferenceOrder >>> 32));
		result = prime * result + ((sportName == null) ? 0 : sportName.hashCode());
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
		UserSportDto other = (UserSportDto) obj;
		if (preferenceOrder != other.preferenceOrder)
			return false;
		if (sportName == null) {
			if (other.sportName != null)
				return false;
		} else if (!sportName.equals(other.sportName))
			return false;
		return true;
	}
	
	
	
	//private Set<SportPlaceAssociation> myPlacesForThisSport = new HashSet<SportPlaceAssociation>();
	
	
}
