package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ResultPage;
import com.qa.hotels.util.AppConstants;

public class HomePageTest {
	BasePage basePage;
    WebDriver driver;
    Properties prop;
    HomePage homePage;

@BeforeMethod
public void setUp() throws InterruptedException {
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");
	driver = basePage.init_driver(browserName);
	String url = prop.getProperty("url");
	driver.get(url);
	homePage = new HomePage(driver);
	Thread.sleep(5000);
	
}
@Test(priority = 1)
public void verifyGetHomePageTitle() {
	String actual = homePage.getHomePageTitle();
	System.out.println("Title is " + actual);
	Assert.assertEquals(actual, AppConstants.homePageTitle);
}
@Test(priority = 2)
public void verifyDestination() {
	Assert.assertTrue(homePage.Destination(prop.getProperty("destination")));
}
@Test(priority = 3)
public void verifySelectRequirements() {
	Assert.assertTrue(homePage.selectRequirements(prop.getProperty("room"),
			prop.getProperty("adult"), prop.getProperty("children"),
			prop.getProperty("firstAge"), prop.getProperty("secondAge")));
}
@Test(priority = 4)
public void verifyClickSearch() {
//	homePage.Destination(prop.getProperty("destination"));
//	homePage.nightNumber(prop.getProperty("firstDay"), prop.getProperty("lastDay"));
//	homePage.selectRequirements(prop.getProperty("room"),
//			prop.getProperty("adult"), prop.getProperty("children"),
//			prop.getProperty("firstAge"), prop.getProperty("secondAge"));
	ResultPage resultPage = homePage.clickSearch();
	Assert.assertEquals(resultPage.getResultPageTitle(), AppConstants.resultPageTitle);

}
}
