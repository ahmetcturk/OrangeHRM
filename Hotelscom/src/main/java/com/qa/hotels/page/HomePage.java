package com.qa.hotels.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

import okio.Timeout;




public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	Select select;
	WebDriverWait wait;
	Properties prop;
	BasePage basePage;
	
	By location = By.name("q-destination");
	By checkIn = By.id("qf-0q-localised-check-in");
	By checkOut = By.id("qf-0q-localised-check-out");
	By rooms = By.id("qf-0q-rooms");
	By adults = By.id("qf-0q-room-0-adults");
	By children = By.id("qf-0q-room-0-children");
	By searchBtn = By.xpath("//button[text() = 'Search']");
	By firstChild = By.id("qf-0q-room-0-child-0-age");
	By secondChild = By.id("qf-0q-room-0-child-1-age");
	
	public HomePage(WebDriver driver) {
    this.driver = driver;
    js= new JavaScriptUtil(driver);
    elementUtil= new ElementUtil(driver);
    basePage = new BasePage();
    prop = basePage.init_properties();
    
    
   }
	
	public String getHomePageTitle() {
		String title = elementUtil.doGetPageTitle();
		return title;
	}
	public boolean Destination(String destination) {
		elementUtil.doSendKeys(location, destination);
		return elementUtil.getElement(location).isEnabled();
	}
	public void nightNumber(String firstDay, String lastDay) {
		elementUtil.doSendKeys(checkIn, firstDay);
		elementUtil.doSendKeys(checkOut, lastDay);
	}
	public boolean selectRequirements(String room, String adult, String child, String firstAge, String secondAge) {
		select = new Select(elementUtil.getElement(rooms));
		select.selectByValue(room);
		select = new Select(elementUtil.getElement(adults));
		select.selectByValue(adult);
		select = new Select(elementUtil.getElement(children));
		select.selectByValue(child);
		select = new Select(elementUtil.getElement(firstChild));
		select.selectByValue(firstAge);
		select = new Select(elementUtil.getElement(secondChild));
		select.selectByValue(secondAge);
		return elementUtil.getElement(searchBtn).isDisplayed();
	}
	public ResultPage clickSearch() {
		Destination(prop.getProperty("destination"));
		nightNumber(prop.getProperty("firstDay"), prop.getProperty("lastDay"));
		selectRequirements(prop.getProperty("room"),
				prop.getProperty("adult"), prop.getProperty("children"),
				prop.getProperty("firstAge"), prop.getProperty("secondAge"));
		elementUtil.doClick(searchBtn);
		return new ResultPage(driver);
	}
	
	
}
