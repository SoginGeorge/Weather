package com.tcs.weatherdata;

import java.io.IOException;

import com.tcs.weatherdata.WeatherDataAggregator;

public class WeatherDataEmitter 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("LATEST WEATHER DATA FOR STATIONS...");
		
	    emitData();	
    }

	private static void emitData() throws IOException {
		WeatherDataAggregator.writeData();
		
		
	}
}
