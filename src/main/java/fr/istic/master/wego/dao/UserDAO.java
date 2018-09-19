package fr.istic.master.wego.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.User;

@Transactional
public interface UserDAO extends JpaRepository<User, Long> {

}
