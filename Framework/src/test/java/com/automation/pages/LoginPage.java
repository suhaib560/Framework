package com.automation.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="email") WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginButton;
	
	public void loginToCRM(String usernameApp, String passwordApp)
	{
		username.sendKeys(usernameApp);
		password.sendKeys(passwordApp);
		loginButton.click();
		
	}

} 
