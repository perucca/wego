package fr.istic.master.wego.dao;

import java.util.List;

import fr.istic.master.wego.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.UserSport;

@Transactional
public interface UserSportDao extends JpaRepository<UserSport, Long> {
	public List<UserSport> findByUser(User user);

	public boolean existsByUserAndSport(User user, Sport sport);
}
