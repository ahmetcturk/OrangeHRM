package com.qa.orangehrm.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.orangehrm.*;
import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.Constants;
import com.qa.orangehrm.util.Credentials;

//@Listeners(com.qa.orangehrm.listeners.TestAllureListener.class)
public class LoginPageTest {
	Logger logger = Logger.getLogger("LoginPageTest");
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	Credentials userCred;
	
	
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		logger.info("Browser is launching...");
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		userCred = new Credentials(properties.getProperty("username"), properties.getProperty("password"));
		
	}
	@Test
	public void loginTest(){
		logger.info("Login Test correct credentials");
		loginPage.doLogin(userCred.getAppUsername(),userCred.getAppPassword());
		logger.info("Ending..");
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
		AssertJUnit.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearUp(){
		driver.close();
	}
	
}
