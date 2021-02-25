package TestNG_1.TestNG_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	public WebDriver driver;
	By username = By.id("txtUsername");
	By password = By.id("txtPassword");
	By loginBtn = By.id("btnLogin");
	By header = By.xpath("//h1[contains(text(),'Dashboard')]");

	@BeforeTest
	public void launchBrowser(){
//		System.out.println("Launching the browser");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		System.out.println("BeforeTest");
	}
	@BeforeTest
	public void launchBrowser2(){
//		System.out.println("Launching the browser");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		System.out.println("BeforeMethod");
	}
	
	
	@Test//(groups = {"G1"})
	public void t1CheckLoginTitle(){
//		String expectedTitle = "OrangeHRM";
//		String actualTitle = driver.getTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Test1");
	}
	
	@Test//(groups = {"G1"})
	public void t2EnterCredential(){
//		driver.findElement(username).sendKeys("Admin");
//		driver.findElement(password).sendKeys("admin123");
//		driver.findElement(loginBtn).click();
		System.out.println("Test2");
	}
	
	@Test(priority = 1)
	public void t3VerifyLoggedInPage(){
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Assert.assertTrue(driver.findElement(header).isDisplayed());
		System.out.println("Test3");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void terminateBrowser1(){
//		System.out.println("Heyy");
//		driver.close();
		System.out.println("After Method");
	}
	@BeforeClass
	public void terminateBrowser2(){
//		System.out.println("Heyy");
//		driver.close();
		System.out.println("Before Class");
	}
	@AfterClass
	public void terminateBrowser3(){
		System.out.println("After Class");
	}
	
	@AfterTest
	public void terminateBrowser(){
//		System.out.println("Heyy");
//		driver.close();
		System.out.println("After Test");
	}
	
}
