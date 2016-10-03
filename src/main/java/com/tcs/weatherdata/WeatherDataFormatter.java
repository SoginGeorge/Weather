package com.tcs.weatherdata;

import com.tcs.weatherdata.model.WeatherData;

public class WeatherDataFormatter {

	static String getDataInFormat(WeatherData weatherData) {
		
		String strWeatherData = weatherData.getStrStation()+" | "+weatherData.getStrLocation()+" |  "
				                +" | "+weatherData.getdTempreture()+" | "+weatherData.getdPressure()+" | "
				                +" | "+weatherData.getEnWeatherCondition()+" | "+weatherData.getdHumidity();
	
	return strWeatherData;
	}

}
