package org.softtek.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLocator {
	@FindBy(xpath= "//input[@name='userName']")
	WebElement userName;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement password;
}
