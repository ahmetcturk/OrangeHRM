package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.page.LoginPage;
import com.qa.orangehrm.util.Credentials;
import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

public class LoginPageTest {

	// Fields : Webdriver, BasePage, Properties, LoginPage
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	Credentials cred;
	
	
	// @beforemethod Setup, @aftermethod tearDown, @test doLoginTest()....
	
	// Preconditions on @beforeMethod
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		cred = new Credentials(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		loginPage.doLoginWCorrectCred(cred.getUsername(),
				cred.getPassword());
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}











