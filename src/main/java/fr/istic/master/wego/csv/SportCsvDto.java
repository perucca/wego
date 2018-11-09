package fr.istic.master.wego.csv;

/**
 * @author michel perucca
 *
 *	represents the class to read from CSV file
 *
 */
public class SportCsvDto {

	private String sport;
	private String type;
	private String allowedweather;
	private float tempmin;
	private float tempmax;
	private float windmin;
	private float windmax;
	
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAllowedweather() {
		return allowedweather;
	}
	public void setAllowedweather(String allowedweather) {
		this.allowedweather = allowedweather;
	}
	public float getTempmin() {
		return tempmin;
	}
	public void setTempmin(float tempmin) {
		this.tempmin = tempmin;
	}
	public float getTempmax() {
		return tempmax;
	}
	public void setTempmax(float tempmax) {
		this.tempmax = tempmax;
	}
	public float getWindmin() {
		return windmin;
	}
	public void setWindmin(float windmin) {
		this.windmin = windmin;
	}
	public float getWindmax() {
		return windmax;
	}
	public void setWindmax(float windmax) {
		this.windmax = windmax;
	}
	
}
