package fr.istic.master.wego.entity;

import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entité représentant le sport
 * @author michel
 *
 */
@Entity
public class Sport {

  private long id;
  private String sportName;
  private Weather ideal;
  private SortedSet<UserSport> userSports;
  
  
  @Id
  @GeneratedValue
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }

public String getSportName() {
	return sportName;
}

public void setSportName(String sportName) {
	this.sportName = sportName;
}

public Weather getIdeal() {
	return ideal;
}

public void setIdeal(Weather ideal) {
	this.ideal = ideal;
}

@OneToMany
public SortedSet<UserSport> getUserSports() {
	return userSports;
}

public void setUserSports(SortedSet<UserSport> userSports) {
	this.userSports = userSports;
}
  
  
  
  
}
