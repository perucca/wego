package fr.istic.master.wego.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.dao.WeekendAdviceDao;
import fr.istic.master.wego.model.Place;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.User;
import fr.istic.master.wego.model.WeekendAdvice;

@Service
public class WeekEndAdviceService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private WeekendAdviceDao weekendAdviceDao;

	public WeekendAdvice create(User user, Place place, Sport sport) {
		Objects.requireNonNull(user);
		Objects.requireNonNull(place);
		Objects.requireNonNull(sport);

		WeekendAdvice weekendAdvice = new WeekendAdvice();
		weekendAdvice.setPlace(place);
		weekendAdvice.setSport(sport);
		weekendAdvice.setUser(user);

		weekendAdviceDao.save(weekendAdvice);

		return weekendAdvice;

	}

	public void deleteByUser(User user) {
		Objects.requireNonNull(user);

		WeekendAdvice wea = weekendAdviceDao.findByUser(user);
		if (wea != null) {
			weekendAdviceDao.delete(wea);
		}
	}

	public WeekendAdvice findByUser(Long id) {
		Objects.requireNonNull(id);

		User user = userDao.getOne(id);
		return weekendAdviceDao.findByUser(user);
	}

}
