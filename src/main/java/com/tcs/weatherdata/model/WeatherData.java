package com.tcs.weatherdata.model;

import java.util.Date;

public class WeatherData {

	private String strStation;;
	private WeatherCondition enWeatherCondition;
	private String strLocation;
	private double dDewFactor;
	private double dTempreture;
	private double dPressure;
	private double dHumidity;
	public String getStrLocation() {
		return strLocation;
	}
	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
	}
	public WeatherCondition getEnWeatherCondition() {
		return enWeatherCondition;
	}
	public void setEnWeatherCondition(WeatherCondition enWeatherCondition) {
		this.enWeatherCondition = enWeatherCondition;
	}
	public double getdDewFactor() {
		return dDewFactor;
	}
	public void setdDewFactor(double dDewFactor) {
		this.dDewFactor = dDewFactor;
	}
	public double getdTempreture() {
		return dTempreture;
	}
	public void setdTempreture(double dTempreture) {
		this.dTempreture = dTempreture;
	}
	public double getdPressure() {
		return dPressure;
	}
	public void setdPressure(double dPressure) {
		this.dPressure = dPressure;
	}
	public double getdHumidity() {
		return dHumidity;
	}
	public void setdHumidity(double dHumidity) {
		this.dHumidity = dHumidity;
	}
	public Date getDaLocalTime() {
		return daLocalTime;
	}
	public void setDaLocalTime(Date daLocalTime) {
		this.daLocalTime = daLocalTime;
	}
	public String getStrStation() {
		return strStation;
	}
	public void setStrStation(String strStation) {
		this.strStation = strStation;
	}
	private Date   daLocalTime; 
	
}
