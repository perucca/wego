package fr.istic.master.wego.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SportPlaceAssociation {

	Long id;
	
	UserPlace userplace;
	UserSport usersport;
	
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
	
	
	

}
