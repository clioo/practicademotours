package org.softtek.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.BookFlightContent;
import org.softtek.locators.FlightFinderContent;
import org.softtek.objects.Flight;

public class BookFlightPage extends BasePage {
    public WebDriver driver;
    WebDriverWait wait;
    public BookFlightContent bookFlightContent;

    public BookFlightPage(WebDriver driver){
        this.driver = driver;
        bookFlightContent = PageFactory.initElements(driver, BookFlightContent.class);
        wait = new WebDriverWait(this.driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(bookFlightContent.selectCreditCardType));
    }

    public Boolean summaryIsCorrect(Flight flight){
        return False;
    }
}
