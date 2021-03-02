package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.page.HomePage;
import com.qa.hotels.page.ResultPage;
import com.qa.hotels.util.AppConstants;

public class ResultPageTest {
	
WebDriver driver;
Properties prop;
BasePage basePage;
HomePage homePage;
ResultPage resultPage;

@BeforeMethod
public void setUp() {
	
	basePage = new BasePage();
	prop = basePage.init_properties();
	String browserName = prop.getProperty("browser");  
	driver = basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	homePage = new HomePage(driver);
	resultPage = homePage.clickSearch();

}
@Test
public void verifyHilton(){
	
	Assert.assertTrue(resultPage.getHotelsName("Hilton",3));
}
@Test
public void verifyHotelsWithinSpecifiedMile() {
	//String actual = resultPage.hotelsWithinSpecifiedMile(5, 10);
	//String actual = resultPage.hotelsWithinSpecifiedMile(3, 10);
	String actual = resultPage.hotelsWithinSpecifiedMile(4, 10);
	Assert.assertEquals(actual, AppConstants.resultPageHeader);
}
@AfterTest
public void tearDown() {
	driver.quit();
}

}
