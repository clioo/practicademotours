package org.softtek.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.FlightFinderContent;

public class FindFlightPage {
	public WebDriver driver;
	WebDriverWait wait;
	public FlightFinderContent flightFinderContent;
	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
		flightFinderContent = PageFactory.initElements(driver, FlightFinderContent.class);
		wait = new WebDriverWait(this.driver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(flightFinderContent.imageFlightFinder));
	}
	public void selectRadioTripType(String type){
		if(type.equals("Round Trip")) {
			flightFinderContent.radioTripTypeRound.click();
		}else if(type.equals("One Way")) {
			flightFinderContent.radioTripTypeOneWay.click();
		}
	}
	
	public void selectPassengers(String value) {
		Select select = new Select(flightFinderContent.selectPassengers);
		select.selectByVisibleText(value);
	}
	
	
	
}
