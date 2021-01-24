package com.qa.orange.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orange.base.BasePage;
import com.qa.orange.page.AddEmployee;
import com.qa.orange.page.HomePage;
import com.qa.orange.page.LoginPage;
import com.qa.orange.util.Credentials;
import com.qa.orange.util.ExcelUtil;

public class AddEmployeeTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	AddEmployee addEmployee;
	Credentials userCred;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred);
		addEmployee = new AddEmployee(driver);
	
	}
	
	@DataProvider
	public Object[][] getContactsTestData(){
		Object[][] data = ExcelUtil.getTestData("employee");
		return data;
	}
	
	@Test(dataProvider="getContactsTestData")
	public void addEmployeeTest(String firstName, String lastName) {
		addEmployee.doClick();
		addEmployee.addEmployee(firstName, lastName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
