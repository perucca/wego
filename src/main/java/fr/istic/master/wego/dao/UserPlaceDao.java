package fr.istic.master.wego.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.UserPlace;

/**
 * @author amontuwy
 * Interface for CRUD on UserPlace Entity
 * 
 */
@Transactional
public interface UserPlaceDao extends JpaRepository<UserPlace, Long> {

    public List<UserPlace> findByUserId(Long id);
    public boolean existsByUserIdAndPlaceId(Long userId, Long placeId);
}
