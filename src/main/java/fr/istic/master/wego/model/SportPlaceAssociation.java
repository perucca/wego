package fr.istic.master.wego.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SportPlaceAssociation {

	Long id;

	UserPlace userplace;
	UserSport usersport;

	public SportPlaceAssociation() {

	}

	public SportPlaceAssociation(UserPlace userplace, UserSport usersport) {
		this.userplace = userplace;
		this.usersport = usersport;
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
	public UserPlace getUserplace() {
		return userplace;
	}

	public void setUserplace(UserPlace userplace) {
		this.userplace = userplace;
	}

	@ManyToOne
	public UserSport getUsersport() {
		return usersport;
	}

	public void setUsersport(UserSport usersport) {
		this.usersport = usersport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userplace == null) ? 0 : userplace.hashCode());
		result = prime * result + ((usersport == null) ? 0 : usersport.hashCode());
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
		SportPlaceAssociation other = (SportPlaceAssociation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userplace == null) {
			if (other.userplace != null)
				return false;
		} else if (!userplace.equals(other.userplace))
			return false;
		if (usersport == null) {
			if (other.usersport != null)
				return false;
		} else if (!usersport.equals(other.usersport))
			return false;
		return true;
	}

}
