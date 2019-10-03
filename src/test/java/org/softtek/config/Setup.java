package org.softtek.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
	public static WebDriver driver;
	static String chromePath = System.getProperty("user.dir") + 
			"/drivers/chromedriver77.exe";
	
	public static void setBrowser() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
}
