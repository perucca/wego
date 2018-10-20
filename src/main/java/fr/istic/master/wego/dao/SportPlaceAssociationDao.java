package fr.istic.master.wego.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.SportPlaceAssociation;
import fr.istic.master.wego.model.User;

@Transactional
public interface SportPlaceAssociationDao extends JpaRepository<SportPlaceAssociation, Long> {

	@Query("SELECT spa FROM SportPlaceAssociation spa WHERE spa.userplace.user=:user ORDER BY spa.userplace.preferenceOrder, spa.usersport.preferenceOrder ASC")
	Collection<SportPlaceAssociation> findByUserOrderedByPlacePreferenceAndSportPreference(@Param("user") User user);

}
