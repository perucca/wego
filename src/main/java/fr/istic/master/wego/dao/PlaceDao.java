package fr.istic.master.wego.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.Place;

/**
 * @author amontuwy
 * Interface for CRUD on Place Entity
 * To be done 
 */
@Transactional
public interface PlaceDao extends JpaRepository<Place, Long> {

	// read
	public Optional<Place> findById(Long id);

	public Place save(Place p);

	public long count();

}
