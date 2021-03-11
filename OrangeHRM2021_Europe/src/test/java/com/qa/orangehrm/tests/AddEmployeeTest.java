package com.qa.orangehrm.tests;

import java.util.Properties;import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.page.AddEmployee;
import com.qa.orangehrm.page.HomePage;
import com.qa.orangehrm.page.LoginPage;
import com.qa.orangehrm.util.ExcelUtil;

public class AddEmployeeTest {
	
	
	// fields
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	AddEmployee addEmployee;
	
	// setup : We need to go to addemployee page
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver();
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(properties.getProperty("username"),
				properties.getProperty("password"));
		addEmployee = new AddEmployee(driver);
		addEmployee.goToAddEmployee();
	}
	
	
	@DataProvider//(name = "Employee_List")
	public Object [][] getEmployees(){
		Object[][] data = ExcelUtil.getTestData("Sheet1");
		return data;
	}
	

	@Test(dataProvider="getEmployees")
	public void addEmployee_2(String firstname, String lastName){
		addEmployee.addEmployee(firstname, lastName);
	}
	
	
	
	
	
	// tests
	@Test
	public void testUrl(){
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@Test
	public void addEmployee(){
		addEmployee.addEmployee("Can", "Turk2");
	}
	
	// tearDown
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
}
