package com.utility;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;
	
	
	public WebDriver getDriver() {
		// return driver;
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
//		this.driver = driver; //initializing the instance variable driver.
		this.driver.set(driver); // initializing the instance variable driver.
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public BrowserUtility(String browerName) {

		super();
		

		logger.info("Lanching browser for " + browerName);
		if (browerName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();	
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();		
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();		
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else {
			logger.error("Invalid browser name " + browerName
					+ " Please provide a valid browser name (chrome, edge, firefox).");
			System.err.println("Invalid browser name. Please provide a valid browser name (chrome, edge, firefox).");
		}
	}

	public BrowserUtility(Browser browerName) {
		super();

		logger.info("Lanching browser for " + browerName);
		if (browerName == Browser.CHROME) {
//			driver = new ChromeDriver();
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName == Browser.EDGE) {
//			driver = new EdgeDriver();
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		} else if (browerName == Browser.FIREFOX) {
//			driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		}
	}

	// this constructor is for headless feature
	public BrowserUtility(Browser browerName, boolean isHeadless) {
		super();

		logger.info("Lanching browser for " + browerName);

		if (browerName == Browser.CHROME) {
			if (isHeadless) {
				logger.info("Lanching browser in headless mode");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}
//			
		} else if (browerName == Browser.EDGE) {
			if (isHeadless) {
				logger.info("Lanching browser in headless mode");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

			} else {
//				driver = new EdgeDriver();
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}
//			
		}

		else if (browerName == Browser.FIREFOX) {

			if (isHeadless) {
				logger.info("Lanching browser in headless mode");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080"); // Force full desktop resolution
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			} else {
//				driver = new FirefoxDriver();
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}

		}
	}

	// got to the given URL - open the website
	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
//		driver.get(url);
		driver.get().get(url);
	}

	// maximize browser window
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
//		driver.manage().window().maximize();
		driver.get().manage().window().maximize();
	}

	// perform click action
	public void clickOn(By locator) {
		logger.info("Finding element with the locator " + locator);
//		driver.findElement(locator).click();
//		driver.get().findElement(locator).click();
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		logger.info("Successfully clicked element with locator: " + locator);
	}
	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator " + locator);
//		driver.findElement(locator).click();
//		driver.get().findElement(locator).click();
		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		logger.info("Successfully clicked element with locator: " + locator);
	}

	// Overloaded click on method - clicking on the web elements
	public void clickOn(WebElement element) {
		logger.info("Finding web element");
		element.click();
		logger.info("Successfully clicked web element");
	}

	// perform sendKeys action
	public void sendKeys(By locator, String textToEnter) {
		logger.info("Entering text into: " + locator);
//		driver.findElement(locator).sendKeys(textToEnter);
		driver.get().findElement(locator).sendKeys(textToEnter);
		logger.info("Text entered successfully into: " + locator);
	}

	// perform sendKeys action
	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);

//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);

		logger.info("Text entered successfully into: " + locator);
	}

	// sends special keys
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding Element with the locator" + locator);

//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Locator found - " + locator);
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and now enter Special text " + keyToEnter);
		element.sendKeys(keyToEnter);

		logger.info("Spcial Key entered successfully into: " + locator);
	}

	// get visible text of the element
	public String getVisibleText(By locator) {
		logger.info("Visible text of element " + locator + ": " + driver.get().findElement(locator).getText());
//		return driver.findElement(locator).getText();
		return driver.get().findElement(locator).getText();

	}

	// overloaded method
	public String getVisibleText(WebElement element) {

		logger.info("Returning the visibile Text: " + element.getText());

		return element.getText();
	}

	// get All visible text of the element
	public List<String> getAllVisibleText(By locator) {
		logger.info("Find All Elements with the locator: " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found & Printing the List of Element: ");

		List<String> visibleTextList = new ArrayList<>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));

		}

		return visibleTextList;
	}

	// get All the web element
	public List<WebElement> getAllWebElements(By locator) {
		logger.info("Find All Web Elements with the locator: " + locator);
		List<WebElement> webElementsList = driver.get().findElements(locator);
		logger.info("All Web Elements found ");

		return webElementsList;
	}

	// to take the ss
	public String takeScreenshot(String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		// To distinguish the ss name we will use date time format
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timeStamp = format.format(date);

		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "//screenshots//" + fileName + "_" + timeStamp + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		return destFile.getAbsolutePath();
		// Relative path
		return "../screenshots/" + destFile.getName();
	}

	// Handle the select drop-down by value
	public void selectFromDropdown(By dropDownLocator, String dropdownValueToSelect) {
		logger.info("Locating dropdown element: " + dropDownLocator);
		WebElement dropDownElement = driver.get().findElement(dropDownLocator);
		logger.info("Dropdown element found successfully.");

		Select select = new Select(dropDownElement);
		logger.info("Selecting dropdown option: " + dropdownValueToSelect);
		select.selectByValue(dropdownValueToSelect);
		logger.info("Dropdown option selected successfully: " + dropdownValueToSelect);

	}

	// select drop down by visible text
	public void selectFromDropdownByVisibleText(By dropdownLocator, String optionToSelect) {

		logger.info("Locating dropdown element: " + dropdownLocator);

		WebElement dropdownElement = driver.get().findElement(dropdownLocator);

		logger.info("Dropdown element found successfully.");

		Select select = new Select(dropdownElement);

		logger.info("Selecting dropdown option by visible text: " + optionToSelect);

		select.selectByVisibleText(optionToSelect);

		logger.info("Dropdown option selected successfully: " + optionToSelect);
	}

	// clearing the text which is present in the text box/text area
	public void clearText(By locator) {
		logger.info("Locating Element with the locator" + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found successfully.");

		logger.info("Clearing the previous text");
		element.clear();
		logger.info("Text Cleared successfully from locator: " + locator);
	}

	// to close the browser session
	public void quit() {
		if (driver.get() != null) {
			driver.get().quit();
		}
	}

}
