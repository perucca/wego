package fr.istic.master.wego.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.WeekendAdvice;

@Transactional
public interface WeekendAdviceDao extends CrudRepository<WeekendAdvice, Long> {

	WeekendAdvice findByUser(User user);

}
