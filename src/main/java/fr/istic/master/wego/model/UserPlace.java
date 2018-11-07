package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author amontuwy This class represents a place chosen by a user with a
 *         preference order
 */
@Entity
public class UserPlace {

	private Long id;
	private User user;
	private Place place;
	private int preferenceOrder;

	private Set<SportPlaceAssociation> mySportsAtThisPlace = new HashSet<SportPlaceAssociation>();

	public UserPlace() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public int getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(int preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}

	@OneToMany(mappedBy = "userplace")
	public Set<SportPlaceAssociation> getMySportsAtThisPlace() {
		return mySportsAtThisPlace;
	}

	public void setMySportsAtThisPlace(Set<SportPlaceAssociation> mySportsAtThisPlace) {
		this.mySportsAtThisPlace = mySportsAtThisPlace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mySportsAtThisPlace == null) ? 0 : mySportsAtThisPlace.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + preferenceOrder;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mySportsAtThisPlace == null) {
			if (other.mySportsAtThisPlace != null)
				return false;
		} else if (!mySportsAtThisPlace.equals(other.mySportsAtThisPlace))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (preferenceOrder != other.preferenceOrder)
			return false;
		return true;
	}

}