package fr.istic.master.wego.dto.transform;

import java.util.Objects;

import fr.istic.master.wego.dto.WeekendAdviceDto;
import fr.istic.master.wego.model.WeekendAdvice;

public class TransformDtoWeekendAdvice {

	public static WeekendAdviceDto transformToDto(WeekendAdvice wea) {
		Objects.requireNonNull(wea);

		WeekendAdviceDto weaDto = new WeekendAdviceDto();
		weaDto.setId(wea.getId());
		weaDto.setSport(wea.getSport().getSportName());
		weaDto.setPlace(wea.getPlace().getName());
		weaDto.setWeather(wea.getPlace().getForecast().getWeather().toString());
		weaDto.setTemperature(wea.getPlace().getForecast().getTemperature());
		weaDto.setWind(wea.getPlace().getForecast().getWind());
		
		return weaDto;
	}

}
