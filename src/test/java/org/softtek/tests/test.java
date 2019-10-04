package org.softtek.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.softtek.utils.SheetsUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class test {
	Object[] testObjArray;
	
	
	@Test(dataProvider = "DataGoogleSheets", description="Test Case for Register an user")
    public void prueba1(String ... data) {
		System.out.println(data[0]);
    }
    
	@DataProvider(name = "DataGoogleSheets")
	public Object[] userRegister() throws Exception{
		testObjArray = SheetsUtil.getData();
		return (testObjArray);
	}
}
