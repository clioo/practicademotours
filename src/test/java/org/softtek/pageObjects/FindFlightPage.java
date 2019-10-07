package org.softtek.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.FlightFinderContent;

public class FindFlightPage extends BasePage {
	public WebDriver driver;
	WebDriverWait wait;
	public FlightFinderContent flightFinderContent;
	public FindFlightPage(WebDriver driver) {
		this.driver = driver;
		flightFinderContent = PageFactory.initElements(driver, FlightFinderContent.class);
		wait = new WebDriverWait(this.driver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(flightFinderContent.selectAirline));
	}
	public void selectRadioTripType(String type){
		if(type.equals("Round Trip")) {
			flightFinderContent.radioTripTypeRound.click();
		}else if(type.equals("One Way")) {
			flightFinderContent.radioTripTypeOneWay.click();
		}
	}
	
	public void selectPassengers(String value) {
		selectByVisible(flightFinderContent.selectPassengers, value);
	}
	
	public void selectDpartingFrom(String value) {
		selectByVisible(flightFinderContent.selectDepartingFrom, value);
	}
	
	public void selectOnMonth(String value) {
		selectByVisible(flightFinderContent.selectOnMonth, value);
	}
	
	public void selectOnDay(String value) {
		selectByVisible(flightFinderContent.selectOnDay, value);
	}
	
	public void selectArriving(String value) {
		selectByVisible(flightFinderContent.selectArriving, value);
	}
	
	public void selectReturningMonth(String value) {
		selectByVisible(flightFinderContent.selectReturningMonth, value);
	}
	
	public void selectReturningDay(String value) {
		selectByVisible(flightFinderContent.selectReturningDay, value);
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
	
	public void selectAirline(String value) {
		selectByVisible(flightFinderContent.selectAirline, value);
	}
	
	public void submit() {
		flightFinderContent.findFlightsButton.click();
	}
	
	
	
}
