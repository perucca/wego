package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.Forecast;


public class PlaceDto {

	private String name;
	private String postCode;

	public PlaceDto() {
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
