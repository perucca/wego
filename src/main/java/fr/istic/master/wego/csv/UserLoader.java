package fr.istic.master.wego.csv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.UserDao;
import fr.istic.master.wego.model.User;

/**
 * @author Michel Perucca 
 *
 *	Handle the csv file with sports defined
 *
 */
@Component
public class UserLoader {

	@Autowired
	private CsvDataLoader csvDataLoader;
	
	@Autowired
	private UserDao userDao;
	
	
	public void load() {
		
		if(userDao.count() != 0) {
			return;
		}
		
		List<UserCsvDto> users = csvDataLoader.loadObjectList(UserCsvDto.class, "users.csv");
		
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
