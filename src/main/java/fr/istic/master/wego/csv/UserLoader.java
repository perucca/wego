package fr.istic.master.wego.csv;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.User;

/**
 * @author Michel Perucca
 *
 *         Handle the csv file with users defined
 *
 */
@Component
public class UserLoader {

	@Autowired
	private CsvDataLoader csvDataLoader;

	@Autowired
	private UserDao userDao;

	@Value("users.csv")
	private ClassPathResource resource;

	public void load() {

		if (userDao.count() != 0)
			return;

		Logger.getGlobal().log(Level.INFO, "Loading Users...");
		List<UserCsvDto> users = csvDataLoader.loadObjectList(UserCsvDto.class, resource);
		Logger.getGlobal().log(Level.INFO, users.size() + " Users to create");

		users.forEach(userCsv -> {
			User user = new User();
			user.setFirstName(userCsv.getFirstname());
			user.setLastName(userCsv.getLastname());
			user.setMail(userCsv.getEmail());
			user.setPassword(User.PASSWORD_ENCODER.encode(userCsv.getPassword()));

			userDao.save(user);
		});

	}

}
