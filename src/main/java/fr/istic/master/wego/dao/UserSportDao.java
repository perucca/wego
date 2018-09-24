package fr.istic.master.wego.dao;


import fr.istic.master.wego.model.UserPlace;
import fr.istic.master.wego.model.UserSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserSportDao extends JpaRepository<UserSport,Long> {
    public List<UserSport> findByUserId(Long id);
}
