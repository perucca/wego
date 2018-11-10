package fr.istic.master.wego.csv;

import java.io.File;
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
 *	Load CsvFile Data
 *
 */
@Component
public class CsvDataLoader {

	public <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        
	        File file = new ClassPathResource(fileName).getFile();
	        CsvMapper mapper = new CsvMapper();
	        MappingIterator<T> readValues = 
	          mapper.readerFor(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	        Logger.getGlobal().log(Level.SEVERE,"Error occurred while loading object list from file " + fileName, e);
	        return Collections.emptyList();
	    }
	}

}
