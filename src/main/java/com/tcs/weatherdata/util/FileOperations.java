package com.tcs.weatherdata.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileOperations {

	static Properties properties = new Properties();

	public static Properties fetchDataForLocation(){
	
		InputStream input = FileReader.class.getClassLoader().getResourceAsStream(ApplicationConstants.PROPERTY_FILE);
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;

	}
	
}
