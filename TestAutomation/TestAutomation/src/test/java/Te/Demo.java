package Te;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public static void test() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauc");
		
		loginButton.click();
	
		String ProductsTitle = null;
		try {
		WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
		 ProductsTitle = title.getText();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			assertEquals(ProductsTitle, "Products", "Login is unsuccessfull");
		}
		
		driver.quit();
		
		
		
		
		
		
		
		
	}
	
}