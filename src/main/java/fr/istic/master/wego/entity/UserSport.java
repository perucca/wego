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
public class UserSport {
	private long id;
	private long userId;
	private long sportId;
	private float preferenceOrder;
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

	public float getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(float preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToMany 
	public SortedSet<UserPlace> getUserPlaces() {
		return userPlaces;
	}

	public void setUserPlaces(SortedSet<UserPlace> userPlaces) {
		this.userPlaces = userPlaces;
	}

}
