package org.softtek.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.SelectFlightContent;

import java.util.Dictionary;
import java.util.Hashtable;

public class SelectFlightPage extends BasePage{
	public WebDriver driver;
	WebDriverWait wait;
	public SelectFlightContent selectFlightContent;
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		selectFlightContent = PageFactory.initElements(driver, SelectFlightContent.class);
		wait = new WebDriverWait(this.driver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(selectFlightContent.reserveFlightsButton));
	}
	
	public Boolean rightOriginDestiny(String from, String to) {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+from+" to "+to+"')]"));
		return elementExists(element);
	}
	
	  /**
	   * month name in MMMM format, only months in english.
	   */
	public Boolean rightDate(String monthName, String day) throws Exception{
		String monthNumber = getMonthNameNumber(monthName);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+monthNumber+"/"
				+day+"/2019')]"));	
		return elementExists(element);
	}

	public void printDepartDetails() {
		for (int i = 0; i < selectFlightContent.departFlightAirlinesElements.size(); i++) {
			WebElement flightElement = selectFlightContent.departFlightAirlinesElements.get(i);
			WebElement flightPriceElement = selectFlightContent.departFlightPriceElements.get(i);
			WebElement departTimeElement = selectFlightContent.departFlightTimesElements.get(i);
			WebElement stopsElement = selectFlightContent.departFlightStopsElements.get(i);
			System.out.println(flightElement.getText());
			System.out.println(flightPriceElement.getText());
			System.out.println(departTimeElement.getText());
			System.out.println(stopsElement.getText());
		}
	}
	
	public void printReturnDetails() {
		for (int i = 0; i < selectFlightContent.departFlightAirlinesElements.size(); i++) {
			WebElement flightElement = selectFlightContent.returnFlightAirlinesElements.get(i);
			WebElement flightPriceElement = selectFlightContent.returnFlightPriceElements.get(i);
			WebElement departTimeElement = selectFlightContent.returnFlightTimesElements.get(i);
			WebElement stopsElement = selectFlightContent.returnFlightStopsElements.get(i);
			System.out.println(flightElement.getText());
			System.out.println(flightPriceElement.getText());
			System.out.println(departTimeElement.getText());
			System.out.println(stopsElement.getText());
		}
	}
	
	  /**
	   * Returns the selected airline.
	   */
	public Dictionary<String, String> chooseLowerDepartPrice() {
		Integer lower = 0;
		Integer lowerIndex = 0;
		for (int i = 0; i < selectFlightContent.radioGroupDepart.size(); i++) {
			Integer price = getPriceFromString(selectFlightContent.departFlightPriceElements.get(i).getText());
			if (i == 0) {
				lower = price;
			}
			if (price < lower) {
				lower = price;
				lowerIndex = i;
			}
		}
		selectFlightContent.radioGroupDepart.get(lowerIndex).click();
		// Initializing a Dictionary
		Dictionary<String, String> flightDetails = new Hashtable();
		flightDetails.put("airlineName", selectFlightContent.departFlightAirlinesElements.get(lowerIndex).getText());
		flightDetails.put("airlinePrice",lower.toString());
		return flightDetails;
	}
	
	  /**
	   * Returns the selected airline.
	   */
	public Dictionary<String, String> chooseHigherReturnPrice() {
		Integer higher = 0;
		Integer higherIndex = 0;
		for (int i = 0; i < selectFlightContent.radioGroupReturn.size(); i++) {
			Integer price = getPriceFromString(selectFlightContent.returnFlightPriceElements.get(i).getText());
			if (i == 0) {
				higher = price;
			}
			if (price > higher) {
				higher = price;
				higherIndex = i;
			}
		}

		// Initializing a Dictionary
		Dictionary<String, String> flightDetails = new Hashtable();
		flightDetails.put("airlineName", selectFlightContent.returnFlightAirlinesElements.get(higherIndex).getText());
		flightDetails.put("airlinePrice",higher.toString());
		selectFlightContent.radioGroupReturn.get(higherIndex).click();
		return flightDetails;
	}
	
	public void reserveFlights() {
		selectFlightContent.reserveFlightsButton.click();
	}
}
