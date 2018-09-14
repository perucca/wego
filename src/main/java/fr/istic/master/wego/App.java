package fr.istic.master.wego;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.master.wego.entity.Personne;

/**
 * Hello world!
 *
 */
public class App 
{
  /**
   * @param args
   */
  public static void main(String[] args) {
      EntityManagerFactory factory = Persistence
              .createEntityManagerFactory("dev");
      EntityManager manager = factory.createEntityManager();

      EntityTransaction tx = manager.getTransaction();
      tx.begin();
      try {
          
        Personne personne = new Personne();
        personne.setName("titi");
        manager.persist(personne);
      } catch (Exception e) {
          e.printStackTrace();
      }
      tx.commit();
      
      manager.close();
      factory.close();
  }

}
