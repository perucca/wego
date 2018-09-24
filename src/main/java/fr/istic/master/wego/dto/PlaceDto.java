package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Forecast;


public class PlaceDto {

	private Long id;
	private String name;
	private String postCode;

	public PlaceDto() {
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

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
