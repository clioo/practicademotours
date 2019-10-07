package org.softtek.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	public void selectByVisible(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	public String getMonthNameNumber(String monthName) throws Exception {
		if (monthName.equals("January")) {
			return "1";
		}else if(monthName.equals("February")) {
			return "2";
		}else if(monthName.equals("March")) {
			return "3";
		}else if(monthName.equals("April")) {
			return "4";
		}else if(monthName.equals("May")) {
			return "5";
		}else if(monthName.equals("June")) {
			return "6";
		}else if(monthName.equals("July")) {
			return "7";
		}else if(monthName.equals("August")) {
			return "8";
		}else if(monthName.equals("September")) {
			return "9";
		}else if(monthName.equals("October")) {
			return "10";
		}else if(monthName.equals("November")) {
			return "11";
		}else if(monthName.equals("December")) {
			return "12";
		}else {
			throw new Exception("Not recognized month, example of valid month: November");
		}
	}
	
	/*
	 * Get the price from string (it has to start with '$', else will return 0
	 */
	public Integer getPriceFromString(String price) {
		String value = "";
		for (char character : price.toCharArray()) {
			if (Character.isDigit(character)) {
				value = value + character;
			}else if (character == '.' || character == ',') {
				value = value + character;
			}
		}
		return Integer.parseInt(value);
	}

	/*
	 * this method will return true if the element exists
	 */
	public Boolean elementExists(WebElement element) {
		 try {
			 Dimension dimensions = element.getSize();
			 return true;
		} catch (Exception e) {
			return false;
		}
	}
}
