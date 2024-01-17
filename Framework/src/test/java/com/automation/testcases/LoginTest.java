package com.automation.testcases;





import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.ContactsPage;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseClass{

	public String getData(int colNum) {
		String data = excel.getStringData("login", 1, colNum);
		return data;
		}
		
	@Test
	public void loginApp() throws FileNotFoundException, InterruptedException 
	{
		logger = report.createTest("Login to CRM");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(getData(0), getData(1));
		
		logger.pass("Login Success");
		
		ContactsPage contactsPage=PageFactory.initElements(driver, ContactsPage.class);
		
		Assert.assertEquals("Contacts activity stream", "Contacts activity stream");

		logger.info("Starting Application");
		contactsPage.clickonContactsLeftTab();

		contactsPage.clickonContactsCreateBtn();
		Assert.assertEquals("Create New Contact", "Create New Contact");
		
		contactsPage.createNewContactFnLname(getData(2),getData(3));
		
		contactsPage.createNewContactAccess();
		
		contactsPage.StatusDropdown(getData(4));
		
		contactsPage.PhoneDropdown(getData(5));
		
		contactsPage.ClickonSaveContactBtn();
		
		contactsPage.VerifyContactHeader(getData(6));
		
	}
	
	
}
