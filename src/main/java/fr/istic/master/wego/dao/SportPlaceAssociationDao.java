package fr.istic.master.wego.dao;

import java.util.Collection;
import java.util.List;

import fr.istic.master.wego.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SportPlaceAssociationDao extends JpaRepository<SportPlaceAssociation, Long> {

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.user=:user ORDER BY spa.userplace.preferenceOrder, spa.usersport.preferenceOrder ASC")
	Collection<SportPlaceAssociation> findByUserOrderedByPlacePreferenceAndSportPreference(@Param("user") User user);

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.user=:user")
	List<SportPlaceAssociation> findByUser(@Param("user") User user);

	public boolean existsByUsersportAndUserplace(UserSport usersport, UserPlace superplace);

}
