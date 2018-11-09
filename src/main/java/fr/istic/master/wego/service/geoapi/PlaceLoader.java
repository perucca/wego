package fr.istic.master.wego.service.geoapi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.istic.master.wego.dao.PlaceDao;
import fr.istic.master.wego.model.Place;

@Component
public class PlaceLoader {

	@Autowired
	PlaceDao placedao;

	public void load() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Departement>> response = restTemplate.exchange(
				"https://geo.api.gouv.fr/departements?fields=code", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Departement>>() {
				});

		List<Ville> villes = response.getBody().stream()
				.map(d -> restTemplate.exchange(
						"https://geo.api.gouv.fr/departements/" + d.getCode() + "/communes?fields=nom,codesPostaux",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<Ville>>() {
						}).getBody())
				.flatMap(x -> x.stream()).distinct().collect(Collectors.toList());

		villes.forEach(v -> convertVille(v));
	}

	public void convertVille(Ville ville) {
		ville.getCodesPostaux().forEach(p -> placedao.save(new Place(ville.getNom(), p)));
	}
}
