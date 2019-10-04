package org.softtek.tests;

import static org.testng.Assert.assertEquals;



import org.softtek.config.Setup;
import org.softtek.objects.User;
import org.softtek.pageObjects.FindFlightPage;
import org.softtek.pageObjects.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class test extends Setup{
	Object[] testObjArray;
	
	@BeforeTest
	private void setUp() throws Exception{
		String browser = sheet.getBrowser();
		setBrowser(browser);
	}
	
	@Test(dataProvider = "DataGoogleSheets", description="I want to login", priority=0)
    public void login(String ... data) {
		User user = new User(data[0],data[1]); // 0 = username | 1 = password
		HomePage homePage = new HomePage(driver);
		homePage.setUsername(user.getUsername());
		homePage.setPassword(user.getPassword());
		homePage.login();
    }
	
	
	@Test(dataProvider = "DataGoogleSheets", description="I want to find a flight", priority=1)
    public void findFlight(String ... data) {
		FindFlightPage findFlightPage = new FindFlightPage(driver);
		findFlightPage.selectRadioTripType(data[2]);
		findFlightPage.selectPassengers(data[3]);
		findFlightPage.selectDpartingFrom(data[4]);
		findFlightPage.selectOnMonth(data[5]);
		findFlightPage.selectOnDay(data[6]);
		findFlightPage.selectArriving(data[7]);
		findFlightPage.selectReturningMonth(data[8]);
		findFlightPage.selectReturningDay(data[9]);
		findFlightPage.selectAirline(data[10]);
		findFlightPage.submit();
    }
    
	@DataProvider(name = "DataGoogleSheets")
	public Object[] userRegister() throws Exception{
		testObjArray = sheet.getData();
		return (testObjArray);
	}
}