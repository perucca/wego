package fr.istic.master.wego.csv;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.model.EnumWeather;
import fr.istic.master.wego.model.IdealWeather;
import fr.istic.master.wego.model.Sport;
import fr.istic.master.wego.model.TypeSport;

/**
 * @author Michel Perucca 
 *
 *	Handle the csv file with sports defined
 *
 */
@Component
public class SportLoader {

	@Autowired
	private CsvDataLoader csvDataLoader;
	
	@Autowired
	private SportDao sportDao;
	
	
	public void load() {
		
		if(sportDao.count() != 0) {
			return;
		}
		
		List<SportCsvDto> sports = csvDataLoader.loadObjectList(SportCsvDto.class, "sports.csv");
		
		sports.forEach(sportCsv -> {
			Sport sport = new Sport();
			sport.setSportName(sportCsv.getSport());
			sport.setType(TypeSport.valueOf(sportCsv.getType().toUpperCase()));
			sport.setIdealWeather(buildIdealWeather(sportCsv));
			
			sportDao.save(sport);
		});
		
	}


	/**
	 * Handle the String & between allowed weather in the sportcsv string
	 * @param sportCsv
	 * @return
	 */
	private IdealWeather buildIdealWeather(SportCsvDto sportCsv) {
		IdealWeather idealWeather = new IdealWeather();
		
		try(Scanner allowedweather = new Scanner(sportCsv.getAllowedweather())){
			allowedweather.useDelimiter("&");
			while(allowedweather.hasNext()) {
				idealWeather.getAllowedWeather().add(EnumWeather.valueOf(allowedweather.next().toUpperCase()));
			}
		}
		
		idealWeather.setMinTemperature(sportCsv.getTempmin());
		idealWeather.setMaxTemperature(sportCsv.getTempmax());
		idealWeather.setMinWind(sportCsv.getWindmin());
		idealWeather.setMaxWind(sportCsv.getWindmax());
		
		return idealWeather;
	}
	
	
	
}
