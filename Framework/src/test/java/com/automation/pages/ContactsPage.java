package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class ContactsPage extends BaseClass {

	WebDriver driver;
	
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy(xpath="//a[@href='/contacts']") WebElement ContactsLeftTab;
	@FindBy(xpath="//button[text()='Create']") WebElement ContactsCreateBtn;
	
	@FindBy(xpath="//input[@name='first_name']") WebElement ContactsFirstName;
	@FindBy(xpath="//input[@name='last_name']") WebElement ContactsLastName;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']") WebElement ContactsAccess;
	@FindBy(xpath="//i[@class='unlock icon']") WebElement AccessPublic;
	@FindBy(xpath="//div[@class='ui disabled fluid multiple selection dropdown']") WebElement AccessPublicTxt;
	@FindBy(xpath="//i[@class='lock icon']") WebElement AccessPrivate;
	@FindBy(xpath="//div[@class='ui fluid multiple selection dropdown']") WebElement AccessPrivateTxt;
	@FindBy(xpath="//div[@role='option']//span[.='suhaib uk']") WebElement AccessTextfield;
	@FindBy(xpath="//div[.='Select users allowed access.']") WebElement AccessTfield;

	@FindBy(xpath="//div[@name='status'][@role='listbox']") WebElement StatusDropdown;
	
	@FindBy(xpath="//div[@class='ui field']//label[.='Phone']/..//input[@aria-autocomplete='list']") WebElement PhoneDropdown;
	
	@FindBy(xpath="//button[@class='ui linkedin button'][.='Save']") WebElement SaveContactBtn;
	
	@FindBy(xpath="//div[@class='ui label'][.='Middle name(s)']") WebElement ContactHeader;
	
	
	public void clickonContactsLeftTab()
	{
		ContactsLeftTab.click();		
	}
	
	public void clickonContactsCreateBtn()
	{
		ContactsCreateBtn.click();		
	}
	
	public void createNewContactFnLname(String fname, String lname)
	{
		ContactsFirstName.click();
		ContactsFirstName.sendKeys(fname);	
		ContactsLastName.sendKeys(lname);
	}
	public void createNewContactAccess() throws InterruptedException
	{
		boolean isButtonEnabled = AccessPublic.isEnabled();
		if (isButtonEnabled) {
		    System.out.println("The Public button is enabled.");
		} else {
		    System.out.println("The Public button is disabled.");
		}
		
		boolean isButtonDisabled = !AccessPublicTxt.isEnabled();

		if (isButtonDisabled) {
		    System.out.println("The Text field is disabled.");
		} else {
		    System.out.println("The Text field is enabled.");
		}
		
		ContactsAccess.click();
		
		boolean isPrivateButtonEnabled = AccessPrivate.isEnabled();
		if (isPrivateButtonEnabled) {
		    System.out.println("The Private button is enabled.");
		} else {
		    System.out.println("The Private button is disabled.");
		}
		
		boolean isPrivateTxtEnabled = AccessPrivateTxt.isEnabled();
		if (isPrivateTxtEnabled) {
		    System.out.println("The Text field is enabled.");
		} else {
		    System.out.println("The Text field is disabled.");
		}
		
		AccessTfield.click();
		Thread.sleep(2000);
		AccessTextfield.click();
	
	}
	
	public void StatusDropdown(String status) {
		
		StatusDropdown.click();
		WebElement DropdownList = driver.findElement(By.xpath("//div[@name='status']//span[.='"+status+"']"));
		DropdownList.click();		
	}
	
	public static void clickElementWithJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	public void PhoneDropdown(String country) throws InterruptedException {
		
		clickElementWithJavaScript(driver, PhoneDropdown);
		WebElement DropdownList = driver.findElement(By.xpath("//div[@class='ui field']//label[.='Phone']/..//input[@aria-autocomplete='list']/..//span[.='"+country+"']"));
		DropdownList.click();
	}
	
	public void ClickonSaveContactBtn()
	{
		SaveContactBtn.click();		
	}
	
	public void VerifyContactHeader(String Header)
	{
		String header= ContactHeader.getText();	
		System.out.println(header);
		Assert.assertEquals(header,Header);
		}
	
	} 

