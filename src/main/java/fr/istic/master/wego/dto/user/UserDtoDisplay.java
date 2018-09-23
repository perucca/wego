package fr.istic.master.wego.dto.user;

import java.util.HashSet;
import java.util.Set;

public class UserDtoDisplay {

	private Long id;
	private String firstName;
	private String lastName;
	private String mail;
	//AJOUTER LE BOOLEEN "SORTED BY"
	
	private Set<UserSportDto> mySports = new HashSet<UserSportDto>();
	private Set<UserPlaceDtoDisplay> myPlaces = new HashSet<UserPlaceDtoDisplay>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<UserSportDto> getMySports() {
		return mySports;
	}
	public void setMySports(Set<UserSportDto> mySports) {
		this.mySports = mySports;
	}
	public Set<UserPlaceDtoDisplay> getMyPlaces() {
		return myPlaces;
	}
	public void setMyPlaces(Set<UserPlaceDtoDisplay> myPlaces) {
		this.myPlaces = myPlaces;
	}
	
	

}
