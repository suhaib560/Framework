package com.automation.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigDataProvider;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() throws FileNotFoundException {
		Reporter.log("Setting up reports and Test is getting ready", true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentSparkReporter extent = new ExtentSparkReporter("D:\\Eclipse\\Framework\\Reports\\FreeCRM_" + Helper.getCurrentDateTime() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);

		Reporter.log("Setting done - Test can be started ", true);

	}

	@Parameters({"Browser","appTestURL"})
	@BeforeClass
	public void setUp(String browser, String URL) {
		Reporter.log("Trying to start Browser and Getting Application ready", true);

		//driver = BrowserFactory.startApplication(driver, config.getBroswer(), config.getStagingURL());
		driver = BrowserFactory.startApplication(driver, browser, URL);

		Reporter.log("Browser and application is up and ready ", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethd(ITestResult result) {
		
		Reporter.log("Test is about to end", true);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}

		report.flush();
		
		Reporter.log("Test completed >>> Reports are Generated", true);
		
	}

}
