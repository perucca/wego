package fr.istic.master.wego.entity;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	private long id;
	private String name;
	private Collection<SportFavoris> sportFavoris = new HashSet<SportFavoris>();

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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "personne")
	public Collection<SportFavoris> getSportFavoris() {
		return sportFavoris;
	}

	public void setSportFavoris(Collection<SportFavoris> sportFavoris) {
		this.sportFavoris = sportFavoris;
	}

}
