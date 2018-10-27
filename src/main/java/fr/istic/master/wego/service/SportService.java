package fr.istic.master.wego.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.istic.master.wego.dao.SportDao;
import fr.istic.master.wego.dto.SportDto;
import fr.istic.master.wego.dto.TransformDtoSport;
import fr.istic.master.wego.model.Sport;

@Service
public class SportService {

	@Autowired
	private SportDao sportDao;

	public Collection<SportDto> getAllSports() {
		List<SportDto> listDto = new ArrayList<>();
		List<Sport> listDao = sportDao.findAll();

		for (Sport sport : listDao) {
			listDto.add(TransformDtoSport.transformToDto(sport));
		}

		return listDto;
	}

	public SportDto getSportById(Long id) {
		Objects.requireNonNull(id);
		Sport sport = sportDao.getOne(id);

		return TransformDtoSport.transformToDto(sport);
	}

}
