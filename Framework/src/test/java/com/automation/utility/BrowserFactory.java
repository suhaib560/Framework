package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	@SuppressWarnings("deprecation")
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Eclipse\\Framework\\Drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox"))
		{
			System.out.println("browser not available");
		}
		else if(browserName.equals("IE"))
		{
			System.out.println("browser not available");
		}
		else
		{
			System.out.println("we do not support this browser");
		}
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
