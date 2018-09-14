package fr.istic.master.wego.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private String mail;
	private Collection<UserSport> mySports = new HashSet<UserSport>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	@OneToMany(mappedBy = "personne")
	public Collection<UserSport> getUserSport() {
		return mySports;
	}

	public void setSportFavoris(Collection<UserSport> userSport) {
		this.mySports = userSport;
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

}
