package org.softtek.pageObjects;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
	
	public Boolean rightOriginDestiny(String from, String to) {
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+from+" to "+to+"')]"));
		 try {
			 Dimension dimensions = element.getSize();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean rightDate(String month, String day) throws ParseException {
		////*[contains(text(),'10/4/2019')]
		Date date = (Date) new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(month);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer monthNumber = Calendar.MONTH;
		System.out.println(month);
		System.out.println(monthNumber.toString());
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+monthNumber.toString()+"/"
				+day+"/2019')]"));
		 try {
			 Dimension dimensions = element.getSize();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
}
