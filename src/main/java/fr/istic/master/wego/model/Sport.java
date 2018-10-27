package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private TypeSport type;
	private String sportName;
	private IdealWeather idealWeather = new IdealWeather();
	private Set<UserSport> userSports = new HashSet<UserSport>();

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	public TypeSport getType() {
		return type;
	}

	public void setType(TypeSport type) {
		this.type = type;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	@Embedded
	public IdealWeather getIdealWeather() {
		return idealWeather;
	}

	public void setIdealWeather(IdealWeather idealWeather) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Sport sport = (Sport) o;

		if (!id.equals(sport.id)) return false;
		if (type != sport.type) return false;
		if (!sportName.equals(sport.sportName)) return false;
		return idealWeather.equals(sport.idealWeather);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + type.hashCode();
		result = 31 * result + sportName.hashCode();
		result = 31 * result + idealWeather.hashCode();
		return result;
	}
}