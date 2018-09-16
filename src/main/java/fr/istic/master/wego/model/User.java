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

	@Column(name = "name")
	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mail")
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