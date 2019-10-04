package org.softtek.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.SelectFlightContent;

public class SelectFlightPage {
	public WebDriver driver;
	WebDriverWait wait;
	public SelectFlightContent selectFlightContent;
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		selectFlightContent = PageFactory.initElements(driver, SelectFlightContent.class);
		wait = new WebDriverWait(this.driver, 35);
		wait.until(ExpectedConditions.elementToBeClickable(selectFlightContent.reserveFlightsButton));
	}
	
	public Boolean concuerdaOrigenDestino(String from, String to) {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+from+" to "+to+"')]"));
		 try {
			 Dimension dimensions = element.getSize();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
}
