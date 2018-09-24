package fr.istic.master.wego.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.istic.master.wego.model.Sport;

@Transactional
public interface SportDao extends JpaRepository<Sport,Long> {
}
