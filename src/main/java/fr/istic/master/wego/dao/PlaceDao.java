package fr.istic.master.wego.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.Place;

/**
 * @author amontuwy Interface for CRUD on Place Entity To be done
 */

@Transactional
public interface PlaceDao extends JpaRepository<Place, Long> {

	@Query("select p from Place p where p.postCode =:postCode")
	public Set<Place> findAllByPostCode(@Param("postCode") String postCode);

	@Query("select p from Place p where p.name =:name")
	public Set<Place> findAllByName(@Param("name") String name);

}
