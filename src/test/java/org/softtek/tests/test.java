package org.softtek.tests;

import static org.testng.Assert.assertEquals;



import org.softtek.config.Setup;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class test extends Setup{
	Object[] testObjArray;
	
	@BeforeTest
	private void setUp() throws Exception{
		setBrowser("Internet explorer");
	}
	
	@Test(dataProvider = "DataGoogleSheets", description="Test Case for Register an user")
    public void prueba1(String ... data) {
		System.out.println(data[0]);
    }
    
	@DataProvider(name = "DataGoogleSheets")
	public Object[] userRegister() throws Exception{
		testObjArray = sheet.getData();
		return (testObjArray);
	}
}