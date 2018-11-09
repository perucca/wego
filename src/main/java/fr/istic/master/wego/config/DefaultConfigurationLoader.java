package fr.istic.master.wego.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.csv.SportLoader;
import fr.istic.master.wego.csv.UserLoader;
import fr.istic.master.wego.service.geoapi.PlaceLoader;

/**
 * Loading default configuration if no data in the database
 * @author Michel Perucca
 *
 */
@Component
public class DefaultConfigurationLoader {

	@Autowired
	private SportLoader sportLoader;
	
	@Autowired
	private UserLoader userLoader;
	
	@Autowired
	PlaceLoader placeLoader;

	public void load() {

		placeLoader.load();
		sportLoader.load();
		userLoader.load();
	}

}
