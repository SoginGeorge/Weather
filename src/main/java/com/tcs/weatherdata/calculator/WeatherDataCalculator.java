package com.tcs.weatherdata.calculator;

import java.util.Date;
import java.util.Properties;

import com.tcs.weatherdata.model.WeatherCondition;
import com.tcs.weatherdata.util.ApplicationConstants;

public class WeatherDataCalculator {

	public static double calculateTempreture(String baseLocation, Properties properties) {
		Date currentDate = new Date();
		int iMonth = currentDate.getMonth();
		int iHour  = currentDate.getHours();
		Double dMaxTempreture= Double.parseDouble(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.MAX_TEMPRETURE));
		Double dMinTempreture= Double.parseDouble(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.MIN_TEMPRETURE));
		Double dHourlyTempVariance = (dMaxTempreture-dMinTempreture)/12;
		Double dCurrentempreture = (iHour-12) >0 ? (dMaxTempreture-(iHour-12)*dHourlyTempVariance) : (dMinTempreture+(iHour*dHourlyTempVariance));
		return dCurrentempreture;
	}

	public static double calculatePressure(String baseLocation, Properties properties,Double tempreture) {
		Double tempGradient =ApplicationConstants.TEMPRETURE_GRADIENT ;
		Double altitude=Double.parseDouble(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.ALTITUDE));
		Double v3 = tempreture + tempGradient * altitude;
		Double pressure = (Double) (ApplicationConstants.SEA_LEVEL_PRESSURE / Math.pow((1 - tempGradient * altitude / v3), .03416f / tempGradient));
		//dzpressure = (Double) Math.round(pressure * 100) / 100;
		return pressure;
	}

	public static double calculateHumidity(String baseLocation, Properties properties,Double tempreture) {
		Double dDewPoint = Double.parseDouble(properties.getProperty(baseLocation+ApplicationConstants.DOT+ApplicationConstants.DEW_POINT));
		Double dHumidity = (100-(3.6*tempreture)) + (3.6*dDewPoint);
		return dHumidity;
	}

	public static WeatherCondition deriveWeatherCondition(String baseLocation, Properties properties) {
		
		

	}

}
