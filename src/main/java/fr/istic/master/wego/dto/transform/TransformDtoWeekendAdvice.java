package fr.istic.master.wego.dto.transform;

import java.util.Objects;

import fr.istic.master.wego.dto.WeekendAdviceDto;
import fr.istic.master.wego.model.WeekendAdvice;

public class TransformDtoWeekendAdvice {

	public static WeekendAdviceDto transformToDto(WeekendAdvice wea) {
		Objects.requireNonNull(wea);

		WeekendAdviceDto weaDto = new WeekendAdviceDto();
		weaDto.setId(wea.getId());
		weaDto.setIdPlace(wea.getPlace().getId());
		weaDto.setIdSport(wea.getSport().getId());
		weaDto.setIdUser(wea.getUser().getId());

		return weaDto;
	}

}
