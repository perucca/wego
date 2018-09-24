package fr.istic.master.wego.dto;

import fr.istic.master.wego.model.RequiredWeather;
import fr.istic.master.wego.model.TypeSport;
import fr.istic.master.wego.model.UserSport;

import java.util.HashSet;
import java.util.Set;

public class SportDto {

    private TypeSport type;
    private String sportName;
    private RequiredWeather idealWeather = new RequiredWeather();

    public SportDto() {
    }

    public TypeSport getType() {
        return type;
    }

    public void setType(TypeSport type) {
        this.type = type;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public RequiredWeather getIdealWeather() {
        return idealWeather;
    }

    public void setIdealWeather(RequiredWeather idealWeather) {
        this.idealWeather = idealWeather;
    }
}
