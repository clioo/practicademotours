package org.softtek.locators;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookFlightContent {
    @FindBy(xpath="//input[starts-with(@name, 'passFirst')]")
    public List<WebElement> passengerFirstNameInputs;

    @FindBy(xpath="//input[starts-with(@name, 'passLast')]")
    public List<WebElement> passengerLastNameInputs;


    // Credit card
    @FindBy(xpath = "//select[@name='creditCard']")
    public WebElement selectCreditCardType;

    @FindBy(xpath = "//input[@name='creditnumber']")
    public WebElement creditCardNumber;

    @FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
    public WebElement selectCreditCardExpirationMonth;

    @FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
    public WebElement selectCreditCardExpirationYear;

    @FindBy(xpath = "//input[@name='cc_frst_name']")
    public WebElement creditCardFirstName;

    @FindBy(xpath = "//input[@name='cc_mid_name']")
    public WebElement creditCardMiddleName;

    @FindBy(xpath = "//input[@name='cc_last_name']")
    public WebElement creditCardLastName;


    //BillingAddress
    @FindBy(xpath = "//input[@name='billAddress1']")
    public WebElement billingAddress1;

    @FindBy(xpath = "//input[@name='billAddress2']")
    public WebElement billingAddress2;

    @FindBy(xpath = "//input[@name='billCity']")
    public WebElement billingCity;

    @FindBy(xpath = "//input[@name='billState']")
    public WebElement billingState;

    @FindBy(xpath = "//input[@name='billZip']")
    public WebElement billingZip;

    @FindBy(xpath = "//select[@name='billCountry']")
    public WebElement selectBillingCountry;

    //DeliveryAddress
    @FindBy(xpath = "//input[@name='delAddress1']")
    public WebElement deliveryAddress1;

    @FindBy(xpath = "//input[@name='delAddress2']")
    public WebElement deliveryAddress2;

    @FindBy(xpath = "//input[@name='delCity']")
    public WebElement deliveryCity;

    @FindBy(xpath = "//input[@name='delState']")
    public WebElement deliveryState;

    @FindBy(xpath = "//input[@name='delZip']")
    public WebElement deliveryZip;

    @FindBy(xpath = "//select[@name='delCountry']")
    public WebElement selectDeliveryCountry;

    @FindBy(xpath = "//input[@name='buyFlights']")
    public WebElement purchaseButton;







}
