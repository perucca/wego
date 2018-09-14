package fr.istic.master.wego.entity;

import java.util.SortedSet;

import javax.persistence.Column;
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
public class UserSport implements Comparable<UserSport>{
	private long id;
	private long userId;
	private long sportId;
	private long preferenceOrder;
	private SortedSet<UserPlace> userPlaces;
	
	public UserSport() {
		
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@ManyToOne
	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}

	public long getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(long preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToMany 
	public SortedSet<UserPlace> getUserPlaces() {
		return userPlaces;
	}

	public void setUserPlaces(SortedSet<UserPlace> userPlaces) {
		this.userPlaces = userPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (preferenceOrder ^ (preferenceOrder >>> 32));
		result = prime * result + (int) (sportId ^ (sportId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		if (id != other.id)
			return false;
		if (preferenceOrder != other.preferenceOrder)
			return false;
		if (sportId != other.sportId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int compareTo(UserSport o) {
		if(this.preferenceOrder > o.preferenceOrder) {
			return 1;
		}else if(this.preferenceOrder < o.preferenceOrder) {
			return -1;
		}
		return 0;
	}
		
	

}
