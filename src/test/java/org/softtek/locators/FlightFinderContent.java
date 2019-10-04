package org.softtek.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class FlightFinderContent {
	@FindBy(xpath= "//img[@src='/images/masts/mast_flightfinder.gif']")
	public WebElement imageFlightFinder; //used to validate the page is shown
	
	@FindBy(xpath= "//input[@value='roundtrip']")
	public WebElement radioTripTypeRound;
	
	@FindBy(xpath= "//input[@value='oneway']")
	public WebElement radioTripTypeOneWay;
	
	@FindBy(xpath= "//select[@name='passCount']")
	public WebElement selectPassengers;
	
	@FindBy(xpath= "//select[@name='fromPort']")
	public WebElement selectDepartingFrom;

	@FindBy(xpath= "//select[@name='fromMonth']")
	public WebElement selectOnMonth;
	
	@FindBy(xpath= "//select[@name='fromDay']")
	public WebElement selectOnDay;
	
	@FindBy(xpath= "//select[@name='toPort']")
	public WebElement selectArriving;
	
	@FindBy(xpath= "//select[@name='toMonth']")
	public WebElement selectReturningMonth;
	
	@FindBy(xpath= "//select[@name='toDay']")
	public WebElement selectReturningDay;
	
	@FindBy(xpath= "//input[@value='Coach']")
	public WebElement radioServiceEconomy;

	@FindBy(xpath= "//input[@value='Business']")
	public WebElement radioServiceBusiness;
	
	@FindBy(xpath= "//input[@value='First']")
	public WebElement radioServiceFirstClass;
	
	@FindBy(xpath= "//select[@name='airline']")
	public WebElement selectAirline;
	
	@FindBy(xpath= "//input[@name='findFlights']")
	public WebElement findFlightsButton;
	
}
