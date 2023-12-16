package com.automation.testcases;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseClass{

	@Test
	public void loginApp() throws FileNotFoundException 
	{
		logger = report.createTest("Login to CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		
		logger.pass("Login Success");

	}
	
}
