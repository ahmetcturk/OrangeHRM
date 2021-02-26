package com.qa.orangehrm.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPagePF;


public class LoginPageTestPF {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPagePF loginPagePF;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPagePF = new LoginPagePF(driver);
	}

	@Test
	public void loginTest() {
		loginPagePF.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}