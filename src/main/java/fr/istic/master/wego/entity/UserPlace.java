package fr.istic.master.wego.entity;

import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author amontuwy
 * This class represents a place chosen by a user with a preference order 
 */
@Entity
public class UserPlace implements Comparable <UserPlace>{
	private long id;
	private long userId;
	private long sportId;
	private Long preferenceOrder;
	private SortedSet<UserSport> userSports;
	
	public UserPlace() {
		
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}

	public Long getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(Long preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToMany (mappedBy="userPlaces")
	public SortedSet<UserSport> getUserSports() {
		return userSports;
	}

	public void setUserSports(SortedSet<UserSport> userSports) {
		this.userSports = userSports;
	}

	public int compareTo(UserPlace o) {
		if (o.preferenceOrder > this.preferenceOrder)
			return 1;
		else if (o.preferenceOrder<this.preferenceOrder)
			return -1 ;
		else return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((preferenceOrder == null) ? 0 : preferenceOrder.hashCode());
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
		UserPlace other = (UserPlace) obj;
		if (id != other.id)
			return false;
		if (preferenceOrder == null) {
			if (other.preferenceOrder != null)
				return false;
		} else if (!preferenceOrder.equals(other.preferenceOrder))
			return false;
		if (sportId != other.sportId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
	
	
	
	
}
