package com.utility;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable driver..
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));

	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for " + " " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			logger.error("Invalid browser Name. Please do Select Edge or Chrome");

		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + " " + browserName);
		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + " " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

			else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else

				driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

	}

	public void goToWebsite(String url) {
		logger.info("Visiting the Website" + " " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();

	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator" + " " + locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found and now performing click");
		element.click();
	}

	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator" + " " + locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now performing click");
		element.click();
	}
	
	public void clickOn(WebElement element) {
		logger.info("Element found and now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator" + " " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now EnterText" + " " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator" + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
		logger.info("Selecting the option " + " " + optionToSelect);
	}

	public void clearText(By textBoxLocator) {
		logger.info("Finding element with the locator" + " " + textBoxLocator);
		//WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element found and now clearing the field");
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keysToEnter) {
		logger.info("Finding element with the locator" + " " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter special key" + " " + keysToEnter);
		element.sendKeys(keysToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Find All elements with the locator" + " " + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));

		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Find All elements with the locator" + " " + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements");

		return elementList;
	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator" + " " + locator);

		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text" + " " + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {
		logger.info("returning the visible text" + " " + element.getText());
		return element.getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);

		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}

	public static void quitBrowser() {
		WebDriver drv = driver.get();
		if (drv != null) {
			drv.quit();
			driver.remove();
		}
	}

}
