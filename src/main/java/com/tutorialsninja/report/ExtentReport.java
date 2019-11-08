package com.tutorialsninja.report;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tutorialsninja.utils.TestBase;

public class ExtentReport extends TestBase {

	ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;

	public void startReport() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		htmlReporter.config().setDocumentTitle("Automation Report-Atmecs.com");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("browser", "chrome");
	}

	public void tearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE FAILED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE SKIPPED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
			test.log(Status.INFO, "TEST CASE PASSED IS " + result.getThrowable());
			String screenshotPath = ExtentReport.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshot/" + screenshotName + ".png";
		File Destination = new File(destination);
		FileUtils.copyFile(source, Destination);
		return destination;
	}
}
