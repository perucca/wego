package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author amontuwy
 * This class represents an entity of a place in the database
 */
@Entity
public class Place {


	private Long id;
	private String name;
	private int postCode;
	private Forecast forecast;

	private Set<UserPlace> userPlaces = new HashSet<UserPlace>();

	public Place() {
	}

	public Place(String name, int postCode) {
		this.name = name;
		this.postCode = postCode;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "town_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "post_code")
	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int i) {
		this.postCode = i;
	}

	@OneToMany(mappedBy="place")
	public Set<UserPlace> getUserPlaces() {
		return userPlaces;
	}

	public void setUserPlaces(Set<UserPlace> userPlaces) {
		this.userPlaces = userPlaces;
	}

	@Embedded
	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + postCode;
		result = prime * result + ((userPlaces == null) ? 0 : userPlaces.hashCode());
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
		Place other = (Place) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postCode != other.postCode)
			return false;
		if (userPlaces == null) {
			if (other.userPlaces != null)
				return false;
		} else if (!userPlaces.equals(other.userPlaces))
			return false;
		return true;
	}

}