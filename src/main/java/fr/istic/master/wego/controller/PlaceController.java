package fr.istic.master.wego.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.service.PlaceService;

/**
 * @author amontuwy REST Services available for Place management
 */

@RestController
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@GetMapping("")
	public Collection<PlaceDto> getAllPlaces() {
		return placeService.getAllPlaces();
	}

    @GetMapping("/{id}")
    public PlaceDto getPlaceById(@PathVariable("id") Long id) {
        return placeService.getPlacesById(id);
    }
	
	@GetMapping("/bypostcode/{postcode}")
	public Collection<PlaceDto> getAllPlacesByPostCode(@PathVariable("postcode") String postcode) {
		return placeService.getAllPlacesByPostCode(postcode);
	}

	@GetMapping("/byname/{name}")
	public Collection<PlaceDto> getAllPlacesByName(@PathVariable("name") String name) {
		return placeService.getAllPlacesByName(name);
	}

}
