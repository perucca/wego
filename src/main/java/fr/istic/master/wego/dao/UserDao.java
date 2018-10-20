package fr.istic.master.wego.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.User;

/**
 * @author amontuwy Interface for CRUD on UserEntity To do done
 */
@Transactional
public interface UserDao extends JpaRepository<User, Long> {

	@Query("select u from User u where u.mail =:mail")
	public Optional<User> findByEmail(@Param("mail") String mail);

}
