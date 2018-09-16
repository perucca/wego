package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 * @author dorian
 *
 */
@Entity
public class UserSport {
	
	private Long id;
	private User user;
	private Sport sport;
	private long preferenceOrder;
	
	private Set<UserPlace> myPlacesForThisSport = new HashSet<UserPlace>();
	
	public UserSport() {
		
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public long getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(long preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToMany (mappedBy="mySportsAtThisPlace")
	public Set<UserPlace> getMyPlacesForThisSport() {
		return myPlacesForThisSport;
	}

	public void setMyPlacesForThisSport(Set<UserPlace> myPlacesForThisSport) {
		this.myPlacesForThisSport = myPlacesForThisSport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((myPlacesForThisSport == null) ? 0 : myPlacesForThisSport.hashCode());
		result = prime * result + Float.floatToIntBits(preferenceOrder);
		result = prime * result + ((sport == null) ? 0 : sport.hashCode());
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
		UserSport other = (UserSport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (myPlacesForThisSport == null) {
			if (other.myPlacesForThisSport != null)
				return false;
		} else if (!myPlacesForThisSport.equals(other.myPlacesForThisSport))
			return false;
		if (Float.floatToIntBits(preferenceOrder) != Float.floatToIntBits(other.preferenceOrder))
			return false;
		if (sport == null) {
			if (other.sport != null)
				return false;
		} else if (!sport.equals(other.sport))
			return false;
		return true;
	}
}
