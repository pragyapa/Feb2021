package com.test.HW_AddCustomer;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

public class NewCustomer {

	WebDriver driver;

	@Before
	public void Login() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	
	@Test
	public void AddCustomer() {
		// Storing Web Element
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id ='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		// Using By class to store web elements
//	By USERNAME_FIELD_LOCATOR = (By.xpath("//input[@id ='username']"));
//	By PASSWORD_FIELD_LOCATOR = (By.xpath("//input[@id='password']"));
//	By SIGNIN_FIELD_LOCATOR = (By.xpath("/html/body/div/div/div/form/div[3]/button"));

		USERNAME_ELEMENT.clear();
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGNIN_ELEMENT.click();

		
		//using assert to make sure we are landing on the required page
		WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard')]"));
		Assert.assertEquals("Dashboard page not found!", "Dashboard", DASHBOARD_TITLE_ELEMENT.getText());

		WebElement CUSTOMER_ELEMENT = driver.findElement(By.linkText("Customers"));
		CUSTOMER_ELEMENT.click();
		WebElement ADDCUSTOMER_ELEMENT = driver.findElement(By.linkText("Add Customer"));
		ADDCUSTOMER_ELEMENT.click();

		WebElement FULLNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='account']"));
		FULLNAME_ELEMENT.sendKeys("Pragya Paudel");

		WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@id='cid']"));
		//creating an object of select class and using method "select by visible text" to pass the argument or selection we want
		Select sel = new Select(COMPANY_DROPDOWN_ELEMENT);
		sel.selectByVisibleText("Personal Company");

		WebElement EMAIL_ELEMENT = driver.findElement(By.xpath("//input[@id='email']"));
		EMAIL_ELEMENT.sendKeys("test@techfios.com");

		WebElement PHONE_ELEMENT = driver.findElement(By.xpath("//input[@id='phone']"));
		PHONE_ELEMENT.sendKeys("222-333-4444");

		WebElement ADDRESS_ELEMENT = driver.findElement(By.xpath("//input[@id='address']"));
		ADDRESS_ELEMENT.sendKeys("234 Morgan St");

		WebElement CITY_ELEMENT = driver.findElement(By.xpath("//input[@id='city']"));
		CITY_ELEMENT.sendKeys("Dallas");

		WebElement STATE_ELEMENT = driver.findElement(By.xpath("//input[@id='state']"));
		STATE_ELEMENT.sendKeys("Texas");

		WebElement ZIPCODE_ELEMENT = driver.findElement(By.xpath("//input[@id='zip']"));
		ZIPCODE_ELEMENT.sendKeys("45758");

		WebElement COUNTRY_ELEMENT = driver.findElement(By.xpath("//*[@id=\"select2-country-container\"]"));
		COUNTRY_ELEMENT.click();
			
		WebElement CURRENCY_ELEMENT = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		CURRENCY_ELEMENT.sendKeys("USD");

		WebElement GROUP_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//*[@id=\"group\"]"));
		Select sel2 = new Select(GROUP_DROPDOWN_ELEMENT);
		sel2.selectByVisibleText("January 2021");

		WebElement PASSWORD_ELEMENT1 = driver.findElement(By.xpath("//input[@id='password']"));
		PASSWORD_ELEMENT1.sendKeys("ABCDEGF");

		WebElement CONFIRM_PASSWORD_ELEMENT1 = driver.findElement(By.xpath("//input[@id='cpassword']"));
		CONFIRM_PASSWORD_ELEMENT1.sendKeys("ABCDEGF");

		WebElement SAVE_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@id='submit']"));
		SAVE_BUTTON_ELEMENT.click();

	}

//	@After
//	public void EndTest() {
//		
//	driver.close();
//	driver.quit();	

}
