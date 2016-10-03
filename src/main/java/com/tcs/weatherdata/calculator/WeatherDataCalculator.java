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
        Double dMaxTempreture= Double.parseDouble(properties.getProperty(baseLocation+"."+ApplicationConstants.MAX_TEMPRETURE));
        Double dMinTempreture= Double.parseDouble(properties.getProperty(baseLocation+"."+ApplicationConstants.MIN_TEMPRETURE));
        Double dHourlyTempVariance = (dMaxTempreture-dMinTempreture)/12;
        Double dCurrentempreture = (iHour-12) >0 ? (dMaxTempreture-(iHour-12)*dHourlyTempVariance) : (dMinTempreture+(iHour*dHourlyTempVariance));
		return dCurrentempreture;
	}

	public static double calculatePressure(String baseLocation, Properties properties) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static double calculateHumidity(String baseLocation, Properties properties) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static WeatherCondition deriveWeatherCondition(String baseLocation, Properties properties) {
		// TODO Auto-generated method stub
		return null;
	}

}
