package fr.istic.master.wego.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Represents the user logged in the application.
 *
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

	public static final PasswordEncoder PASSWORD_ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	@Column(name = "lastname", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mail", nullable = false, unique = true)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(mappedBy = "sport")
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