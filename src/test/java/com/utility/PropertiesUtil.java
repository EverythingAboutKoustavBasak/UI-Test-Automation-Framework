package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	
	//to read the properties file and return the value of the key
	public static String readProperty(Env env, String propertyName){
		File propertiesFile = new File(System.getProperty("user.dir") + "\\config\\"+env+".properties");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//to load the properties file
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//read the value of the key
		String value =  properties.getProperty(propertyName.toUpperCase());
		
		return value;
	}

}
