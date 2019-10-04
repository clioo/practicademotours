package org.softtek.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.HomeContent;

public class HomePage {
	public WebDriver driver;
	WebDriverWait wait;
	public HomeContent homeContent;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		homeContent = PageFactory.initElements(driver, HomeContent.class);
		wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(homeContent.userName));
	}
	public void setUsername(String value) {
		homeContent.userName.sendKeys(value);
	}
	public void setPassword(String value) {
		homeContent.password.sendKeys(value);
	}
	public void login() {
		homeContent.loginButton.click();
		
	}
}
