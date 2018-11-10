package fr.istic.master.wego.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.master.wego.dto.WeekendAdviceDto;
import fr.istic.master.wego.dto.transform.TransformDtoWeekendAdvice;
import fr.istic.master.wego.model.WeekendAdvice;
import fr.istic.master.wego.service.WeekEndAdviceService;

@RestController
@RequestMapping("/weekendadvice")
public class WeekendAdviceController {

	@Autowired
	private WeekEndAdviceService weaService;
	
	@GetMapping("/byuser/{id}")
	public WeekendAdviceDto getWeekEndAdviceByUser(@PathVariable("id") Long id) {
		WeekendAdvice wea = weaService.findByUser(id);
		if (wea != null)
			return TransformDtoWeekendAdvice.transformToDto(wea);
		else
			return null;
	}
	

}
