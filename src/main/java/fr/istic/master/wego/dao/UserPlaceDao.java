package fr.istic.master.wego.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.UserPlace;

/**
 * @author amontuwy
 * Interface for CRUD on UserPlace Entity
 * To be done
 */
@Transactional
public interface UserPlaceDao extends JpaRepository<UserPlace, Long> {

}
