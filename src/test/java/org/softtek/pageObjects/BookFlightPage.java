package org.softtek.pageObjects;

import jdk.internal.cmm.SystemResourcePressureImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.softtek.locators.BookFlightContent;
import org.softtek.locators.FlightFinderContent;
import org.softtek.objects.*;
import org.testng.Assert;

import java.util.List;

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
        String departAirline = bookFlightContent.sumaryRows.get(2)
                .findElement(By.className("data_left")).getText().trim();
        String returnAirline = bookFlightContent.sumaryRows.get(5)
                .findElement(By.className("data_left")).getText().trim();
        String departingFromTo = bookFlightContent.sumaryRows.get(0)
                .findElement(By.className("frame_header_info")).getText().trim();
        String returningFromTo = bookFlightContent.sumaryRows.get(3)
                .findElement(By.className("data_left")).getText().trim();
        String numberOfPassengers = bookFlightContent.sumaryRows.get(6)
                .findElement(By.xpath("//td[@class='data_left' and @align='center']")).getText().trim();
        String totalPrice = bookFlightContent.sumaryRows.get(8)
                .findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b"))
                .getText().trim();
        String taxes = bookFlightContent.sumaryRows.get(7)
                .findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]"))
                .getText().trim();
        Assert.assertEquals(flight.getNumberOfPassengers(),numberOfPassengers);
        Assert.assertEquals(flight.getDepartingFrom() + " to " + flight.getArrivingIn(), departingFromTo);
        Assert.assertEquals(flight.getArrivingIn() + " to " + flight.getDepartingFrom(), returningFromTo);
        Assert.assertEquals(flight.getTotalPrice(getPriceFromString(taxes)).toString() , getPriceFromString(totalPrice).toString());
        return true;
    }

    public void setAllPassengers(Flight flight){
        Integer numberOfPassengers = Integer.parseInt(flight.getNumberOfPassengers());
        System.out.println(numberOfPassengers);
        for (int i = 0; i < numberOfPassengers; i++) {
            setPassenger(bookFlightContent.passengerFirstNameInputs.get(i),
                    bookFlightContent.passengerLastNameInputs.get(i));
        }
    }

    public void setCreditCard(CreditCard creditCard){
        selectByVisible(bookFlightContent.selectCreditCardType, creditCard.getCreditCardType());
        selectByVisible(bookFlightContent.selectCreditCardExpirationMonth, creditCard.getExpirationMonth());
        selectByVisible(bookFlightContent.selectCreditCardExpirationYear, creditCard.getExpirationYear());
        bookFlightContent.creditCardNumber.sendKeys(creditCard.getCreditCardNumber());
        bookFlightContent.creditCardFirstName.sendKeys(creditCard.getFirstName());
        bookFlightContent.creditCardMiddleName.sendKeys(creditCard.getMiddleName());
        bookFlightContent.creditCardLastName.sendKeys(creditCard.getLastName());
    }

    private void setPassenger(WebElement firstName, WebElement lastName){
        Passenger passenger = new Passenger();
        firstName.sendKeys(passenger.getFirstName());
        lastName.sendKeys(passenger.getLastName());
    }

    public void setBillingAddress(BillingAddress billingAddres){
        bookFlightContent.billingAddress1.sendKeys(billingAddres.getAddress1());
        bookFlightContent.billingAddress2.sendKeys(billingAddres.getAddress2());
        bookFlightContent.billingCity.sendKeys(billingAddres.getCity());
        bookFlightContent.billingState.sendKeys(billingAddres.getState());
        bookFlightContent.billingZip.sendKeys(billingAddres.getZipCode());
        selectByVisible(bookFlightContent.selectBillingCountry,billingAddres.getCountry());
    }
    public void setDeliveryAddress(DeliveryAddress deliveryAddress){
        bookFlightContent.deliveryAddress1.sendKeys(deliveryAddress.getAddress1());
        bookFlightContent.deliveryAddress2.sendKeys(deliveryAddress.getAddress2());
        bookFlightContent.deliveryCity.sendKeys(deliveryAddress.getCity());
        bookFlightContent.deliveryState.sendKeys(deliveryAddress.getState());
        bookFlightContent.deliveryZip.sendKeys(deliveryAddress.getZipCode());
        selectByVisible(bookFlightContent.selectDeliveryCountry,deliveryAddress.getCountry());
    }

    public void securePurchase(){
        bookFlightContent.purchaseButton.click();
    }

}
