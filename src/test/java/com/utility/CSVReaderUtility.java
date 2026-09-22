package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile(String string) {
		
		
		File csvFile = new File(System.getProperty("user.dir")+"//testData//" + string);
		FileReader fileReader=null;
		
		
		try {
			fileReader = new FileReader(csvFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		CSVReader csvReader = new CSVReader(fileReader);
		

		String[] line;
		List<User> userList = null;
		User userData;
		
		try {
			csvReader.readNext(); //want to skip the 1st line of the csv file because it is headding of the column 
			userList = new ArrayList<User>();
			
			while((line = csvReader.readNext()) != null) {
				userData = new User(line[0],line[1]);
				userList.add(userData);
			}
			
			/*
			 * //iterate the arraylist to print the info
				for (User userInfo : userList) {
					System.out.println(userInfo);
				}
			
			 * 
			 */
			
			
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
		
		
	}
	
	
	
}
