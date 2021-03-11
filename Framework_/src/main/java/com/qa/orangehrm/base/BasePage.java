package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	// Fields, driver,
	//WebDriver driver;
	Properties properties;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return driver.get();
	}

	// initialize driver
	public WebDriver initialize_driver(String browserName) {

		properties = initialize_properties();

		String browser = browserName;
		optionsManager = new OptionsManager(properties);
		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else {
			System.out.println("Undefined Browser");
		}
		//List all other predefined properties of driver
		//driver.manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// go to the base
		;

		getDriver().get(properties.getProperty("url"));
		// driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		return getDriver();
	}

	// initializing properties
	/**
	 * 
	 * @return
	 */

	public Properties initialize_properties() {

		properties = new Properties();

		try {
			FileInputStream ipFileInputStream = new FileInputStream(
					"/Users/ahmetcturk/git/OrangeHRM/Framework_/src/main/java/com/qa/orangehrm/config/config.properties");
			properties.load(ipFileInputStream);
		} catch (IOException e) {
			System.out.println("Problem occured");
		}
		return properties;

	}

}
