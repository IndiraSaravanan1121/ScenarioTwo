package com.tutorialsninja.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.tutorialsninja.config.Constants;
import com.tutorialsninja.helper.Helper;
import com.tutorialsninja.pages.UserOnRespectivePage;
import com.tutorialsninja.report.LogReport;

public class TestBase {

	public WebDriver driver;
	public LogReport log = new LogReport();
	public WebElement element;
	public ReadProperties property = new ReadProperties();
	public static Helper helper=new Helper();
	public Validation validate;
	public UserOnRespectivePage page;

	@BeforeTest
	public void openBrowser() throws IOException {

		switch (property.properties("browsername", Constants.CONFIG_PATH)) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver = new ChromeDriver(); // create new instance for chrome driver
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
			driver = new FirefoxDriver(); // create new instance for firefox driver
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", Constants.IE_PATH);
			driver = new InternetExplorerDriver(); // create new instance for ie driver
			break;
		}

		// pass application URL
		driver.get(property.properties("url", Constants.CONFIG_PATH));

		log.info("Browser Opened");
		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

}
