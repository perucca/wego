package fr.istic.master.wego.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.User;

/**
 * @author amontuwy Interface for CRUD on UserEntity To do done
 */
@Transactional
public interface UserDao extends JpaRepository<User, Long> {

}
