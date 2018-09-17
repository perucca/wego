package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entité représentant le sport
 * @author michel
 *
 */
@Entity
public class Sport {

	private Long id;
	private String sportName;
	private RequiredWeather idealWeather = new RequiredWeather();

	private Set<UserSport> userSports = new HashSet<UserSport>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	@Embedded
	public RequiredWeather getIdealWeather() {
		return idealWeather;
	}

	public void setIdealWeather(RequiredWeather idealWeather) {
		this.idealWeather = idealWeather;
	}

	@OneToMany(mappedBy = "sport")
	public Set<UserSport> getUserSports() {
		return userSports;
	}

	public void setUserSports(Set<UserSport> userSports) {
		this.userSports = userSports;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sportName == null) ? 0 : sportName.hashCode());
		result = prime * result + ((userSports == null) ? 0 : userSports.hashCode());
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
		Sport other = (Sport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sportName == null) {
			if (other.sportName != null)
				return false;
		} else if (!sportName.equals(other.sportName))
			return false;
		if (userSports == null) {
			if (other.userSports != null)
				return false;
		} else if (!userSports.equals(other.userSports))
			return false;
		return true;
	}

}