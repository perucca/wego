package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Represents the user logged in the application.
 * @author michel
 *
 */
@Entity
public class User {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String password;
	private String mail;
	//AJOUTER LE BOOLEEN "SORTED BY"
	
	private Set<UserSport> mySports = new HashSet<UserSport>();
	private Set<UserPlace> myPlaces = new HashSet<UserPlace>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "firstname", nullable=false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	@Column(name = "lastname", nullable=false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "password", nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mail", nullable=false)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(mappedBy = "user")
	public Set<UserSport> getMySports() {
		return mySports;
	}

	public void setMySports(Set<UserSport> mySports) {
		this.mySports = mySports;
	}

	@OneToMany(mappedBy = "place")
	public Set<UserPlace> getMyPlaces() {
		return myPlaces;
	}

	public void setMyPlaces(Set<UserPlace> myPlaces) {
		this.myPlaces = myPlaces;
	}

}