package fr.istic.master.wego;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import fr.istic.master.wego.config.DefaultConfigurationLoader;

/**
 * @author Michel, Angélique, Dorian
 *
 * Main class of the Spring Application Wego
 *
 */
@SpringBootApplication
@EnableScheduling
public class WegoApplication {

	@Autowired
	DefaultConfigurationLoader defaultConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(WegoApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	final void doSomethingAfterStartup() {
		defaultConfiguration.load();

	}
}
