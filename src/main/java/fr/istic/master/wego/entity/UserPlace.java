package fr.istic.master.wego.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author amontuwy
 * This class represents a place chosen by a user with a preference order 
 */
@Entity
public class UserPlace {

	private Long id;
	private Float preferenceOrder;
	private User user;
	private Place place;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(Float preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
