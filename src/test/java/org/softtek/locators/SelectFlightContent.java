package org.softtek.locators;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightContent {
	@FindBy(xpath="//input[@name='outFlight']")
	public List<WebElement> radioGroupDepart;
	
	@FindBy(xpath= "//input[@name='inFlight']")
	public List<WebElement> radioGroupReturn;

	@FindBy(xpath="//input[@name='reserveFlights']")
	public WebElement reserveFlightsButton;
	
	//Flight DEPART details
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr/td[@class='data_left']")
	public List<WebElement> departFlightAirlinesElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr/td[@class='data_verb_xcols']")
	public List<WebElement> departFlightPriceElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr/td[@class='data_center_mono']")
	public List<WebElement> departFlightTimesElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr/td[@class='data_center']")
	public List<WebElement> departFlightStopsElements;
	
	//Flight Return details
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr/td[@class='data_left']")
	public List<WebElement> returnFlightAirlinesElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr/td[@class='data_verb_xcols']")
	public List<WebElement> returnFlightPriceElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr/td[@class='data_center_mono']")
	public List<WebElement> returnFlightTimesElements;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr/td[@class='data_center']")
	public List<WebElement> returnFlightStopsElements;
	
}
