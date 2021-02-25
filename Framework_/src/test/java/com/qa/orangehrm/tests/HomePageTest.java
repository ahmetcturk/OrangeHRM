package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	public void setUp(){
		System.out.println(1);
		basePage = new BasePage();
		System.out.println(2);
		properties = basePage.initialize_properties();
		System.out.println(3);
		driver = basePage.initialize_driver();
		System.out.println(4);
		loginPage = new LoginPage(driver);
		System.out.println(5);
		homePage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
		System.out.println(6);
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
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER.concat("!"));
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
