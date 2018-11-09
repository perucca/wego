package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.csv.SportLoader;
import fr.istic.master.wego.csv.UserLoader;

/**
 * Loading default configuration if no data in the database
 * @author Michel Perucca
 *
 */
@Component
public class DataBaseLoader {

	@Autowired
	private SportLoader sportLoader;
	
	@Autowired
	private UserLoader userLoader;
	

	public void loadData() {

		sportLoader.load();
		userLoader.load();
	}

}
