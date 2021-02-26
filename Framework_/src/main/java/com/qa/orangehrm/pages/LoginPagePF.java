package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.util.ElementUtilPF;

public class LoginPagePF extends BasePage{
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	//Page Factory Concept == @FindBy
	@FindBy(how=How.ID, using = "txtUsername")
	@CacheLookup
	WebElement emailID;
	@FindBy(how=How.ID, using="txtPassword")
	@CacheLookup
	WebElement password;
	@FindBy(how=How.ID, using="btnLogin")
	@CacheLookup
	WebElement loginbutton;
	public LoginPagePF(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtilPF = new ElementUtilPF(driver);
	}
	public void doLogin(String username, String pwd){
		elementUtilPF.waitForElementPresent(emailID);
		emailID.sendKeys(username);
		password.sendKeys(pwd);
		loginbutton.click();
	}
}
