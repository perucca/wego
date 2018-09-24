package fr.istic.master.wego.dao;

import fr.istic.master.wego.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SportDao extends JpaRepository<Sport,Long> {
}
