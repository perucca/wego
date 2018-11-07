package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import fr.istic.master.wego.service.geoapi.FetchPlaces;

@SpringBootApplication
@EnableScheduling
public class WegoApplication {

	@Autowired
	DataBaseLoader dbl;
	@Autowired
	FetchPlaces fp;

	public static void main(String[] args) {
		SpringApplication.run(WegoApplication.class, args);

	}

	// Define what to do after the spring project started
	@EventListener(ApplicationReadyEvent.class)
	final void doSomethingAfterStartup() {
		dbl.loadData();
		fp.fetchPlaces();
	}
}
