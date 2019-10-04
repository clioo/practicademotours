package org.softtek.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeContent {
	@FindBy(xpath= "//input[@name='userName']")
	public WebElement userName;
	
	@FindBy(xpath= "//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath= "//input[@name='login']")
	public WebElement loginButton;
}