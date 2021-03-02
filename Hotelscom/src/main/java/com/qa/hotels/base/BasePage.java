package com.qa.hotels.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.qa.hotels.util.AppConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	public static boolean highlightElement;

	
public WebDriver init_driver(String browserName) {
   highlightElement = prop.get("highlight").equals("yes")? true : false ;
	
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if (browserName.equalsIgnoreCase("opera")) {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
	}else {
		System.out.println("Browser name "+ browserName + " is not found, please pass the correct browser");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(AppConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	
return driver;

	}

public Properties init_properties() {
	 prop = new Properties();
	 String path = "/Users/ahmetcturk/Desktop/Hotelscom_Sinem/src/main/java/com/qa/hotels/config/config.properties";
	 try {
		FileInputStream ip = new FileInputStream(path);
		 prop.load(ip);
	} catch (FileNotFoundException e) {
		System.out.println("some issue with config properties... Please correct your config...!");
	} catch (IOException e) {
		e.printStackTrace();
	}
	 return prop;
	
}
}
