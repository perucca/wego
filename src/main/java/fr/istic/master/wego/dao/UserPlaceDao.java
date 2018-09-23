package fr.istic.master.wego.dao;

import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.UserPlace;

import java.util.List;
import java.util.Set;

/**
 * @author amontuwy
 * Interface for CRUD on UserPlace Entity
 * To be done
 */
@Transactional
public interface UserPlaceDao extends JpaRepository<UserPlace, Long> {

    public List<UserPlace> findByUserId(Long id);

}
