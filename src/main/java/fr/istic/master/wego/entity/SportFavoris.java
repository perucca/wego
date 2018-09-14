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
	private Personne personne;
	private float ordre;

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
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name="name")
	public float getOrdre() {
		return ordre;
	}

	public void setOrdre(float ordre) {
		this.ordre = ordre;
	}

}
