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
		String monthNumber = "";
		if (month.equals("January")) {
			monthNumber = "1";
		}else if(month.equals("February")) {
			monthNumber = "2";
		}else if(month.equals("March")) {
			monthNumber = "3";
		}else if(month.equals("April")) {
			monthNumber = "4";
		}else if(month.equals("May")) {
			monthNumber = "5";
		}else if(month.equals("June")) {
			monthNumber = "6";
		}else if(month.equals("July")) {
			monthNumber = "7";
		}else if(month.equals("August")) {
			monthNumber = "8";
		}else if(month.equals("September")) {
			monthNumber = "9";
		}else if(month.equals("October")) {
			monthNumber = "10";
		}else if(month.equals("November")) {
			monthNumber = "11";
		}else if(month.equals("December")) {
			monthNumber = "12";
		}

		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+monthNumber+"/"
				+day+"/2019')]"));
		 try {
			 Dimension dimensions = element.getSize();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void printChoicesFromDepart() {
		
	}
}
