package com.qa.orangehrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployee {
	// fields, 
	
	WebDriver driver;
	By pimBtn = By.xpath("//b[text()='PIM']");
	By addEmployee = By.xpath("//a[contains(@id,'addEmployee')]");
	By firstName = By.xpath("//input[contains(@id,'firstName')]");
	By lastName = By.xpath("//input[contains(@id,'lastName')]");
	By btnSave = By.xpath("//input[contains(@id,'btnSave')]");
	

	// constructor
	
	public AddEmployee(WebDriver driver) {
		this.driver = driver;
	}
	
	// Page Actions
	
	public void goToAddEmployee(){
		driver.findElement(pimBtn).click();
		driver.findElement(addEmployee).click();
	}
	
	public void addEmployee(String name, String lastname){
		driver.findElement(firstName).sendKeys(name);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(btnSave).click();
	}
	
	
	
}
