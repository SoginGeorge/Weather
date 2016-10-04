package com.tcs.weatherdata;

import java.util.Properties;

import com.tcs.weatherdata.model.WeatherData;
import com.tcs.weatherdata.util.ApplicationConstants;

public class WeatherDataFormatter {

	static String getDataInFormat(WeatherData weatherData) {
		
		String strWeatherData = weatherData.getStrStation()+ApplicationConstants.PIPE+weatherData.getStrLocation()+ApplicationConstants.PIPE
				                +weatherData.getdTempreture()+ApplicationConstants.PIPE+weatherData.getdPressure()+ApplicationConstants.PIPE+
				                weatherData.getEnWeatherCondition()+ApplicationConstants.PIPE+weatherData.getdHumidity();
	
	return strWeatherData;
	}
	
	
	
	public static String processLocation(String baseLocation, Properties properties) {

		String strLocation =properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.LATITUDE).concat(ApplicationConstants.SEPARATOR);
		strLocation =strLocation.concat(properties.getProperty(ApplicationConstants.LONGITUDE)).concat(ApplicationConstants.SEPARATOR);
		strLocation =strLocation.concat(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.ALTITUDE));

		return strLocation;
	}

}
