package org.softtek.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightContent {
	//Depart
	@FindBy(xpath= "//input[@value='roundtrip']")
	public WebElement radioGroupDepart;
	
	@FindBy(xpath= "//input[@value='roundtrip']")
	public WebElement radioGroupReturn;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	public WebElement reserveFlightsButton;
}
