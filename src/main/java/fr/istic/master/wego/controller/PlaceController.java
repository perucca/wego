package fr.istic.master.wego.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.dto.PlaceDto;
import fr.istic.master.wego.model.Place;

/**
 * @author amontuwy REST Services available for Place management
 */

@RestController
@RequestMapping("/places")
public class PlaceController {

	@Autowired
	private PlaceDao placeDao;
	
	//Methodes pour get une liste de place
	
	@GetMapping("/bypostcode/{postcode}")
	public Set<PlaceDto> getAllPlacesByPostCode(@PathVariable("postcode") String postcode) {
		return placeDao.findAllByPostCode(postcode).stream().map(p->new PlaceDto(p.getId(), p.getName(), p.getPostCode())).collect(Collectors.toSet());
	}

	@GetMapping("/byname/{name}")
	public Set<PlaceDto> getAllPlacesByName(@PathVariable("name") String name) {
		return placeDao.findAllByName(name).stream().map(p->new PlaceDto(p.getId(), p.getName(), p.getPostCode())).collect(Collectors.toSet());
	}
	
	@GetMapping("")
	public List<PlaceDto> getAllPlaces() {
		return placeDao.findAll().stream().map(p->new PlaceDto(p.getId(), p.getName(), p.getPostCode())).collect(Collectors.toList());
	}

	// Methode pour get une ville by ID
	
	@GetMapping("/{id}")
	public PlaceDto getPlaceById(@PathVariable("id") Long id) {
		Place p = placeDao.getOne(id);
		return new PlaceDto(p.getId(), p.getName(), p.getPostCode());			
	}
	

	
//	@GetMapping("/places")
//	public Page<Place> getAllPlaces(Pageable pageable) {
//		return placeDao.findAll(pageable);
//	}

}
