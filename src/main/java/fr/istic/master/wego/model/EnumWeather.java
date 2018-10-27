package fr.istic.master.wego.model;

import java.util.Arrays;

public enum EnumWeather {

	CLEAR("Clear"),
	RAIN("Rain"),
	MIST("Mist"),
	CLOUDS("Clouds");
	
	
	private String weather;

	private EnumWeather(String weather) {
		this.weather = weather;
		
	}
	
	public static EnumWeather from(String weather) {
		
		return Arrays.stream(values())
				.filter(a -> a.weather.equals(weather))
				.findAny()
				.orElseThrow(() -> new IllegalStateException("Weather: "+weather+" not found"));
	}
}


