package orange.qa.hrm.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

@Listeners(com.qa.orangehrm.listeners.ExtentReportListener.class)
public class HomePageTest {
	Logger logger = Logger.getLogger("HomePageTest");
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		logger.info("Browser is launching...");
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		//homePage = loginPage.doLogin("Admin","admin123");
		
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle(){
		logger.info("Verifying home page title starting...");
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		logger.info("Verifying home page title ending...");
	}
	
	@Test
	public void verifyHeader(){
		Assert.assertEquals(homePage.getPageHeader(), "Dashboard");
	}
	
	@Test
	public void verifyAccountName(){
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println(accountName);
		Assert.assertTrue(accountName.contains("Welcome"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
