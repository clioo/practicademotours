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
	
	public void selectDpartingFrom(String value) {
		Select select = new Select(flightFinderContent.selectDepartingFrom);
		select.selectByVisibleText(value);
	}
	
	public void selectOnMonth(String value) {
		Select select = new Select(flightFinderContent.selectOnMonth);
		select.selectByVisibleText(value);
	}
	
	public void selectOnDay(String value) {
		Select select = new Select(flightFinderContent.selectOnMonth);
		select.selectByVisibleText(value);
	}
	
	public void selectArriving(String value) {
		Select select = new Select(flightFinderContent.selectArriving);
		select.selectByVisibleText(value);
	}
	
	public void selectReturningMonth(String value) {
		Select select = new Select(flightFinderContent.selectReturningMonth);
		select.selectByVisibleText(value);
	}
	
	public void selectReturningDay(String value) {
		Select select = new Select(flightFinderContent.selectReturningDay);
		select.selectByVisibleText(value);
	}
	
	
	public void selectRadioService(String type){
		if(type.equals("Economy class")) {
			flightFinderContent.radioServiceEconomy.click();
		}else if(type.equals("Business class")) {
			flightFinderContent.radioServiceBusiness.click();
		}else if(type.equals("First class")) {
			flightFinderContent.radioServiceFirstClass.click();
		}
	}
	
	public void submit(String value) {
		flightFinderContent.findFlightsButton.click();
	}
	
	
	
}
