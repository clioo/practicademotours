package org.softtek.tests;

import org.softtek.config.Setup;
import org.softtek.objects.*;
import org.softtek.pageObjects.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

import java.util.Dictionary;


public class test extends Setup{
	Object[] testObjArray;
	SelectFlightPage selectFlightPage;
	BookFlightPage bookFlightPage;
	Flight flight;
	CreditCard creditCard;
	BillingAddress billingAddress;
	DeliveryAddress deliveryAddress;
	ConfirmationPage confirmationPage;
	
	@BeforeTest()
	private void setUp() throws Exception{
		String browser = sheet.getBrowser();
		setBrowser(browser);
	}
	
	@Test(dataProvider = "DataGoogleSheets", description="I want to login and load the data", priority=0)
    public void login(String ... data) {
		System.out.println(data.length);
		User user = new User(data[0], data[1]); // 0 = username | 1 = password
		HomePage homePage = new HomePage(driver);
		homePage.setUsername(user.getUsername());
		homePage.setPassword(user.getPassword());
		homePage.login();
		flight = new Flight(
				data[2],
				data[3],
				data[4],
				data[5],
				data[6],
				data[7],
				data[8],
				data[9],
				data[10],
				data[11]);

		creditCard = new CreditCard(
				data[12],
				data[13],
				data[14],
				data[15],
				data[16],
				data[17],
				data[18]
		);

		billingAddress = new BillingAddress(
				data[19],
				data[20],
				data[21],
				data[22],
				data[23],
				data[24]
		);
		deliveryAddress = new DeliveryAddress(
				data[25],
				data[26],
				data[27],
				data[28],
				data[29],
				data[30]
		);
	}

	@Test(dataProvider = "DataGoogleSheets", description="I want to find a flight", priority=1)
    public void findFlight(String ... data) {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.selectRadioTripType(flight.getType());
		findFlightPage.selectPassengers(flight.getNumberOfPassengers());
		findFlightPage.selectDpartingFrom(flight.getDepartingFrom());
		findFlightPage.selectOnMonth(flight.getOnDateMonth());
		findFlightPage.selectOnDay(flight.getOnDateDay());
		findFlightPage.selectArriving(flight.getArrivingIn());
		findFlightPage.selectReturningMonth(flight.getReturningDateMonth());
		findFlightPage.selectReturningDay(flight.getReturningDateDay());
		findFlightPage.selectAirline(flight.getAirLinePreference());
		findFlightPage.submit();
    }
	
	@Test(dataProvider = "DataGoogleSheets", description="depart destination and date match", priority=2)
    public void destinationsAndDatesMatch(String ... data) throws Exception {
		selectFlightPage = new SelectFlightPage(driver);
		Assert.assertTrue("Depart desination does not match", selectFlightPage.rightOriginDestiny(data[4], data[7]));
		Assert.assertTrue("Depart date doesn't match", selectFlightPage.rightDate(data[5], data[6]));
    }
    
	@Test(description="print in console the depart flight details", priority=3)
	public void printDepartFlightsDitailsInConsole() {
		selectFlightPage.printDepartDetails();
	}
	
	@Test(description="choose the lower depart airline price", priority=4)
	public void chooseLowerPrice() {
		Dictionary<String, String> flightDetails = selectFlightPage.chooseLowerDepartPrice();
		flight.setSelectedDepartAirline(flightDetails.get("airlineName"));
		flight.setSelectedDepartPrice(flightDetails.get("airlinePrice"));
	}
	
	@Test(dataProvider = "DataGoogleSheets", description="return destination and date match", priority=5)
    public void returnDateAndDestinationMatch(String ... data) throws Exception {
		Assert.assertTrue("Return destination does not match", selectFlightPage.rightOriginDestiny(data[7], data[4]));
		Assert.assertTrue("Return date doesn't match", selectFlightPage.rightDate(data[8], data[9]));
    }
	
	@Test(description="print in console the return flight details", priority=6)
	public void printReturnFlightsDitailsInConsole() {
		selectFlightPage.printReturnDetails();
	}
	
	@Test(description="choose the higher return airline price", priority=7)
	public void chooseHigherPrice() {
		Dictionary<String, String> flightDetails = selectFlightPage.chooseHigherReturnPrice();
		flight.setSelectedReturnAirline(flightDetails.get("airlineName"));
		flight.setSelectedReturnPrice(flightDetails.get("airlinePrice"));
	}
	
	@Test(description="reserve flights", priority=8)
	public void reserveFlights() {
		selectFlightPage.reserveFlights();
	}

	@Test(description="check if summary is correct", priority=9)
	public void summaryIsCorrect(){
		bookFlightPage = new BookFlightPage(driver);
		Assert.assertTrue(bookFlightPage.summaryIsCorrect(flight));
	}
	@Test(description="fill book a flight attributes", priority=10)
	public void fillBookFlightAttributes(){
		bookFlightPage.setAllPassengers(flight);
		bookFlightPage.setCreditCard(creditCard);
		bookFlightPage.setBillingAddress(billingAddress);
		bookFlightPage.setDeliveryAddress(deliveryAddress);
		bookFlightPage.securePurchase();
	}

	@Test(description="check if itinerary has been booked", priority=11)
	public void itineraryBooked(){
		confirmationPage = new ConfirmationPage(driver);
		Assert.assertEquals("Your itinerary has been booked!",confirmationPage.confirmationMessage(), "Flights not booked");
	}
	
	@DataProvider(name = "DataGoogleSheets")
	public Object[] userRegister() throws Exception{
		testObjArray = sheet.getData();
		return (testObjArray);
	}
}