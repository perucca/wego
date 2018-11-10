package fr.istic.master.wego.dto;

public class UserSportDtoRead {
	private Long idUserSport;
	private SportDto sportDto;
	private int preferenceOrder;

	public UserSportDtoRead() {
	}

	public Long getIdUserSport() {
		return idUserSport;
	}

	public void setIdUserSport(Long idUserSport) {
		this.idUserSport = idUserSport;
	}

	public SportDto getSportDto() {
		return sportDto;
	}

	public void setSportDto(SportDto sportDto) {
		this.sportDto = sportDto;
	}

	public int getPreferenceOrder() {
		return preferenceOrder;
	}

	public void setPreferenceOrder(int preferenceOrder) {
		this.preferenceOrder = preferenceOrder;
	}
}
