package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public WebDriver getDriver() {
		//return driver;
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
//		this.driver = driver; //initializing the instance variable driver.
		this.driver.set(driver); //initializing the instance variable driver.
	}
	
	public BrowserUtility(String browerName) {
		
		super();
		
		logger.info("Lanching browser for "+browerName);
		if (browerName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();	
			driver.set(new ChromeDriver());	
		}
		else if (browerName.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();		
			driver.set(new EdgeDriver());		
		}
		else if (browerName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();		
			driver.set(new FirefoxDriver());		
		}
		else {
			logger.error("Invalid browser name "+browerName+" Please provide a valid browser name (chrome, edge, firefox).");
			System.err.println("Invalid browser name. Please provide a valid browser name (chrome, edge, firefox).");
		}
	}
	
	
	public BrowserUtility(Browser browerName) {
		super();
		
		logger.info("Lanching browser for "+browerName);
		if (browerName == Browser.CHROME) {
//			driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if (browerName == Browser.EDGE) {
//			driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		else if (browerName == Browser.FIREFOX) {
//			driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
	}
	
	//this constructor is for headless feature
	public BrowserUtility(Browser browerName, boolean isHeadless) {
		super();
		
		logger.info("Lanching browser for "+browerName);
		
		if (browerName == Browser.CHROME) {
			if(isHeadless) {
				logger.info("Lanching browser in headless mode");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new ChromeDriver(options));
				
			}
			else {
				driver.set(new ChromeDriver());
			}
//			
		}
		else if (browerName == Browser.EDGE) {
			if(isHeadless){
				logger.info("Lanching browser in headless mode");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new EdgeDriver(options));
				
			}else {
//				driver = new EdgeDriver();
				driver.set(new EdgeDriver());
			}
//			
		}
		
		
		else if (browerName == Browser.FIREFOX) {
			
			if(isHeadless){
				logger.info("Lanching browser in headless mode");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new FirefoxDriver(options));
			}else {
//				driver = new FirefoxDriver();
				driver.set(new FirefoxDriver());
			}

		}
	}
	
	
	//got to the given URL - open the website
	public void goToWebsite(String url) {
		logger.info("Visiting the website "+url);
//		driver.get(url);
		driver.get().get(url);
	}
	
	
	//maximize browser window
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
//		driver.manage().window().maximize();
		driver.get().manage().window().maximize();
	}
	
	
	//perform click action
	public void clickOn(By locator) {
		logger.info("Finding element with the locator "+locator);
//		driver.findElement(locator).click();
		driver.get().findElement(locator).click();
		logger.info("Successfully clicked element with locator: " + locator);
	}
	
	//perform sendKeys action
	public void sendKeys(By locator, String textToEnter) {
		logger.info("Entering text into: " + locator);
//		driver.findElement(locator).sendKeys(textToEnter);
		driver.get().findElement(locator).sendKeys(textToEnter);
		logger.info("Text entered successfully into: " + locator);
	}
	
	//get visible text of the element
	public String getVisibleText(By locator) {
		logger.info("Visible text of element " + locator + ": " +driver.get().findElement(locator).getText());
//		return driver.findElement(locator).getText();
		return driver.get().findElement(locator).getText();
		
	}
	
	//to take the ss
	public String takeScreenshot(String fileName) {
		TakesScreenshot screenshot =(TakesScreenshot)driver.get();
		
		//To distinguish the ss name we will use date time format
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		
		
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"//screenshots//"+fileName+" - "+timeStamp+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destFile.getAbsolutePath(); 
	}
	
	//to close the browser session
	public void quit() {
		if(driver.get()!=null) {
			driver.get().quit();
		}
	}
	
}
