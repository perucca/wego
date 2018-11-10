package fr.istic.master.wego.csv;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author Michel Perucca
 *
 *         Load CsvFile Data
 *
 */
@Component
public class CsvDataLoader {

	public <T> List<T> loadObjectList(Class<T> type, ClassPathResource classPathRessource) {
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

			CsvMapper mapper = new CsvMapper();
			MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema)
					.readValues(classPathRessource.getInputStream());
			return readValues.readAll();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE,
					"Error occurred while loading object list from file " + classPathRessource.getFilename(), e);
			return Collections.emptyList();
		}
	}

}
