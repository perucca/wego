package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Forecast;

public class PlaceDto {

	private Long id;
	private String name;
	private String postCode;
	private Forecast forecast;

	public PlaceDto() {
	}

	public PlaceDto(String name, String postCode) {
		this.name = name;
		this.postCode = postCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String i) {
		this.postCode = i;
	}

}
