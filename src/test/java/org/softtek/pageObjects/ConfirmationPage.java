package org.softtek.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.ConfirmationContent;
import org.testng.Assert;

public class ConfirmationPage {
    public WebDriver driver;
    WebDriverWait wait;
    public ConfirmationContent confirmationContent;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        confirmationContent = PageFactory.initElements(driver, ConfirmationContent.class);
        wait = new WebDriverWait(this.driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(confirmationContent.bookConfirmation));
    }

    public String confirmationMessage(){
        return confirmationContent.bookConfirmation.getText();
    }

}
