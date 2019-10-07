package org.softtek.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationContent {
    @FindBy(xpath = "//*[contains(text(), 'itinerary has been booked!')]")
    public WebElement bookConfirmation;
}
