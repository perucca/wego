package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Forecast;

//Permet de travailler avec des JSON qui ne contiennent que l'ID, le nom et le postcode de chaque place

public class PlaceDto {

	private Long id;
	private String name;
	private String postCode;

	public PlaceDto() {
	}

	public PlaceDto(Long id, String name, String postCode) {
		this.id=id;
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
