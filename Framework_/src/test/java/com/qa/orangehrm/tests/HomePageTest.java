package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.Constants;
import com.qa.orangehrm.util.Credentials;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setUp(String browser){
		String browserName = null;
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		browserName = browser;
		driver = basePage.initialize_driver(browserName);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority=1, description="verify home page title")
 
	public void verifyHomePageTitle() {
		String title = homePage.getHomePagetitle();
		System.out.println("home page title is "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2, description="verify home page header")
 
	public void verifyHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is "+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3, description="verify account name method")
 
	public void verifyLoggedInUserTest() {
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println("logged in account is "+ accountName);
		//Assert.assertEquals(accountName, prop.getProperty("accountname"));
		Assert.assertTrue(accountName.contains(properties.getProperty("accountname")));
	}
	
	@Test(priority=4, description="verify page URL")
 
	public void verifyAuthentication() {
		String url = homePage.getHomeUrl();
		System.out.println("page url is "+ url);
		Assert.assertTrue(url.endsWith("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
 

}
