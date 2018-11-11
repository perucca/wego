package fr.istic.master.wego.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;

@Transactional
public interface SportPlaceAssociationDao extends JpaRepository<SportPlaceAssociation, Long> {

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.user=:user ORDER BY spa.userplace.preferenceOrder, spa.usersport.preferenceOrder ASC")
	Collection<SportPlaceAssociation> findByUserOrderedByPlacePreferenceAndSportPreference(@Param("user") User user);

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.user=:user")
	List<SportPlaceAssociation> findByUser(@Param("user") User user);

	public boolean existsByUsersportAndUserplace(UserSport usersport, UserPlace superplace);

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.usersport.id=:idUserSport")
	List<SportPlaceAssociation> findAllByUserSportId(@Param("idUserSport") Long id);

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.id=:idUserPlace")
	List<SportPlaceAssociation> findAllByUserPlaceId(@Param("idUserPlace") Long id);
}
