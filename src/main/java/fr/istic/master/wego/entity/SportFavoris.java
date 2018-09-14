package fr.istic.master.wego.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SportFavoris {

	private long id;
	private Sport sport;
	private Person person;
	private float order;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@ManyToOne
	public Person getPersonne() {
		return person;
	}

	public void setPersonne(Person personne) {
		this.person = personne;
	}

	@Column(name="name")
	public float getOrdre() {
		return order;
	}

	public void setOrdre(float ordre) {
		this.order = ordre;
	}

}
