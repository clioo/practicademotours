package org.softtek.tests;

import static org.testng.Assert.assertEquals;



import org.softtek.config.Setup;
import org.softtek.objects.User;
import org.softtek.pageObjects.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class test extends Setup{
	Object[] testObjArray;
	
	@BeforeTest
	private void setUp() throws Exception{
		setBrowser("Internet explorer");
	}
	
	@Test(dataProvider = "DataGoogleSheets", description="I want to login")
    public void prueba1(String ... data) {
		User user = new User(data[0],data[1]); // 0 = username | 1 = password
		HomePage homePage = new HomePage(driver);
		homePage.setUsername(user.getUsername());
		homePage.setPassword(user.getPassword());
		homePage.login();
    }
    
	@DataProvider(name = "DataGoogleSheets")
	public Object[] userRegister() throws Exception{
		testObjArray = sheet.getData();
		return (testObjArray);
	}
}