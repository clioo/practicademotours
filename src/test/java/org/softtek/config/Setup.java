package org.softtek.config;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.softtek.utils.SheetsUtil;
import org.testng.annotations.BeforeSuite;

public class Setup {
	public static WebDriver driver;
	public static SheetsUtil sheet;
	private static String baseDir = System.getProperty("user.dir");
	private static String chromePath = baseDir + "/drivers/chromedriver77.exe";
	private static String fireFoxPath = baseDir + "/drivers/geckodriver.exe";
	private static String iePath = baseDir + "/drivers/IEDriverServer.exe";
	@BeforeSuite
	public static void setGoogleSheet() throws GeneralSecurityException, IOException {
		sheet = new SheetsUtil();
	}
	
	/*
	 * Browser options available: "Chrome", "Internet explorer"  and "Firefox"
	 */
	public static void setBrowser(String browserOption) throws Exception {
		if (browserOption == "Chrome") {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}else if(browserOption == "Firefox") {
			System.setProperty("webdriver.gecko.driver", fireFoxPath);
			driver = new FirefoxDriver();
		}else if(browserOption == "Internet explorer") {
			System.setProperty("webdriver.ie.driver", iePath);
			driver = new InternetExplorerDriver();
		}else {
			throw new Exception("Not a valid browser option");
		}
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	

	
}
