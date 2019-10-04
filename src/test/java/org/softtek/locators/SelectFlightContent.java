package org.softtek.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SelectFlightContent {
	//Depart
	@FindAll({
		@FindBy(xpath="//input[@name='reserveFlights']")
	})
	public WebElement radioGroupDepart;
	
	@FindAll({
		@FindBy(xpath="//b[contains(text(), 'Price')]")
	})
	public WebElement prices;
	
	@FindBy(xpath= "//input[@value='roundtrip']")
	public WebElement flightDetails;
	
	@FindBy(xpath= "//input[@value='roundtrip']")
	public WebElement radioGroupReturn;

	@FindBy(xpath="//input[@name='reserveFlights']")
	public WebElement reserveFlightsButton;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]")
	public WebElement departDetails;
	
}
