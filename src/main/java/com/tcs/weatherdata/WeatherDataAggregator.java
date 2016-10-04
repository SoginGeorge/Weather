package com.tcs.weatherdata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.tcs.weatherdata.calculator.WeatherDataCalculator;
import com.tcs.weatherdata.model.WeatherData;
import com.tcs.weatherdata.util.ApplicationConstants;
import com.tcs.weatherdata.util.FileOperations;

public class WeatherDataAggregator {

	private WeatherDataAggregator(){}


	public static List<WeatherData> generateData()
	{


		Properties properties =	FileOperations.fetchDataForLocation();
		Set<String> baseLocations = getBaseStations(properties);
		List<WeatherData> lisGeneratedData = new ArrayList<WeatherData>();

		for(String baseLocation : baseLocations)
		{   
            Double tempreture = WeatherDataCalculator.calculateTempreture(baseLocation, properties);
			WeatherData weatherData = new WeatherData();

			weatherData.setStrStation(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.IATA));
			weatherData.setDaLocalTime(new Date());
			weatherData.setStrLocation(WeatherDataFormatter.processLocation(baseLocation,properties));
			weatherData.setdTempreture(tempreture);
			weatherData.setdPressure(WeatherDataCalculator.calculatePressure(baseLocation,properties,tempreture));
			weatherData.setdHumidity(WeatherDataCalculator.calculateHumidity(baseLocation,properties,tempreture));
			weatherData.setEnWeatherCondition(WeatherDataCalculator.deriveWeatherCondition(baseLocation,properties));
			lisGeneratedData.add(weatherData);

		}

		return lisGeneratedData;
	}

	public static Set<String> getBaseStations(Properties properties) {

		String baseLocation = properties.getProperty(ApplicationConstants.BASE_LOCATIONS);

		String[] baseLocations = properties.getProperty(ApplicationConstants.BASE_LOCATIONS).split(ApplicationConstants.SEPARATOR);
		Set<String> uniqueBaseLocations = new LinkedHashSet<String>();
		for(int i=0;i<baseLocations.length;i++){
			uniqueBaseLocations.add(baseLocations[i]);
		}
		return uniqueBaseLocations;	
	}


	public static void writeData() throws IOException {

		List<WeatherData> lisGeneratedData = generateData();
		FileWriter fileWriter = new FileWriter("WeatherData.txt");

		String newLine = System.getProperty("line.separator");
		for(WeatherData weatherData : lisGeneratedData)
		{

			fileWriter.write(WeatherDataFormatter.getDataInFormat(weatherData)+ newLine);

		}
		fileWriter.close();

	}

}
