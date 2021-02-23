package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.orangehrm.*;
import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.Constants;

@Listeners(com.qa.orangehrm.listeners.TestAllureListener.class)
public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	
	
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		
	}
	@Test
	public void loginTest(){
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	@Test
	public void loginTest1(){
		loginPage.doLogin(properties.getProperty("incorrectusername"), properties.getProperty("incorrectpassword"));
	}
	@Test
	public void loginTest2(){
		loginPage.doLogin(properties.getProperty("incorrectusername"), properties.getProperty("password"));
	}
	@Test
	public void loginTest3(){
		loginPage.doLogin(properties.getProperty("username"), properties.getProperty("incorrectpassword"));
	}
	
	@Test
	public void getTitle(){
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"title is incorrect");
	}
	
	@AfterMethod
	public void tearUp(){
		driver.close();
	}
	
}
