package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		
		XSSFWorkbook xssfWorkbook = null;
		
		Row row;
		Cell emailAddressCell, passwordCell;
		User user;
		Iterator<Row> rowIteratow;
		XSSFSheet xssfSheet;
		List<User> userList = null;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();
			xssfSheet = xssfWorkbook.getSheet("loginTestData");
			
			rowIteratow = xssfSheet.iterator(); 
			rowIteratow.next(); //skip the heading/ 1st row because it is heading
			
			while (rowIteratow.hasNext()) {
			    row = rowIteratow.next();
				
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
//				System.out.println(firstCell.toString());
//				System.out.println(secondCell.toString());
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				
				
				xssfWorkbook.close();
			}
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
