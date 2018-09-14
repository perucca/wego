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
public class UserPlace {
	private long id;
	private long userId;
	private long sportId;
	private float preferenceOrder;
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

	public float getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(float preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToMany (mappedBy="userPlaces")
	public SortedSet<UserSport> getUserSports() {
		return userSports;
	}

	public void setUserSports(SortedSet<UserSport> userSports) {
		this.userSports = userSports;
	}
	
	
	
	
}
