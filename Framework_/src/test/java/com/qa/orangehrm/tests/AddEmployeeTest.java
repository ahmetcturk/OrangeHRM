package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.AddEmployee;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.Credentials;
import com.qa.orangehrm.util.ExcelUtil;

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
		prop = basePage.initialize_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCred.getAppUsername(),userCred.getAppPassword());
		addEmployee = new AddEmployee(driver);
		addEmployee.doClick();
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object[][] data = ExcelUtil.getTestData("Sheet1");
		return data;
	}

	@Test(dataProvider = "getContactsTestData")
	public void addEmployeeTest(String firstName, String lastName, String ts) {
		addEmployee.doClick();
		addEmployee.addEmployee(firstName, lastName, ts);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}