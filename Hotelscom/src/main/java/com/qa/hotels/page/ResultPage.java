package com.qa.hotels.page;


import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class ResultPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil js;
	
	By header = By.xpath("//h1[text() = 'Boston, Massachusetts, United States of America']");
	By threeStar = By.id("f-star-rating-3");
	By fiveStar = By.id("f-star-rating-5");
	By hotels = By.xpath("//ol//li//article//section//div//h3//a");
	By hotels1 = By.xpath("//ol//li//article//section//div//h3//span//a");
	By soldOut = By.className("sold-out-message");
	By distance = By.xpath("//a[@class = 'menu-trigger' and @data-menu = 'sort-submenu-distance']");
	By bostonHarbor = By.xpath("//a[text() = 'Boston Harbor']");
	By text = By.xpath("//ul[@class = 'property-landmarks']//li");
	By text1 = By.xpath("//ul[@class = 'property-landmarks']");
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		js = new JavaScriptUtil(driver);
	}
	public String getResultPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	public void starRating(int a) {
		if (a==3) {
			elementUtil.doClick(threeStar);
		} else if(a==5){
            elementUtil.doClick(fiveStar);
		}
	}
	public void scrollDown() {
		Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
		while (true) {
			js.scrollPageDown();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            if (newHeight.equals(lastHeight)) {
                break;
            }
            lastHeight = newHeight;
        }
	}
    public boolean getHotelsName(String specificHotelName, int starRating){
	
    	boolean b = false;
	    starRating(starRating);
	    scrollDown();
	    List<WebElement> list = new LinkedList<WebElement>();	
	    list.addAll(driver.findElements(hotels));
	    list.addAll(driver.findElements(hotels1));
	    //list.removeAll(driver.findElements(soldOut));
	    System.out.println("**********************");
		System.out.println(list.size() + " hotels are found in " + starRating + " star hotel list. ");

		int a=0;
	    for(int i=0; i<list.size(); i++) {
        String text = list.get(i).getText();
	    System.out.println(text);
 
	      if(text.contains(specificHotelName)) {
  	 	    a++;  
          }   
	    }
	    if(a!=0) {
	  	  System.out.println("**********************");
	      System.out.println(specificHotelName+ " is in the " + starRating + " star hotel list.");
          b=true;
	    }else {
		  System.out.println("**********************");
	      System.out.println(specificHotelName+ " is NOT in the " + starRating + " star hotel list.");
          b=false;
	    }
   return b;
   }
   public void selectDistance(By location) {
	elementUtil.doClick(distance);
	elementUtil.doClick(location);
   }
   public String hotelsWithinSpecifiedMile(int star, int miles) {
	selectDistance(bostonHarbor);
	starRating(star);
	scrollDown();
	int hotelsNumber = 0;
	List<WebElement> list = new LinkedList<WebElement>();	
	list.addAll(driver.findElements(hotels));
	list.addAll(driver.findElements(hotels1));
	//list.removeAll(driver.findElements(soldOut));
	
	List <WebElement> list2 = new LinkedList<WebElement>();
	list2.addAll(driver.findElements(text1));
	System.out.println("**********************");
	for(int i=0; i<list2.size(); i++) {
		String text = list2.get(i).getText();
		String [] mile = text.split(" ");
		double distance = Double.parseDouble(mile[0]);
		if(distance<=miles && mile[3].equals("Boston")) {
			System.out.println(list.get(i).getText());
			hotelsNumber++;
		}
	}
	System.out.println("**********************");
	System.out.println(hotelsNumber +" hotels are found " + "within " + miles + " miles radius of " + elementUtil.doGetText(bostonHarbor));  
    return elementUtil.doGetText(header);
   }
}
