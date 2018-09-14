package fr.istic.master.wego.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entité représentant le sport
 * @author michel
 *
 */
@Entity
public class Sport {

  private long id;
  private String name;
  
  @Id
  @GeneratedValue
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  @Column(name="name")
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
}
