package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name= "firstname")
    private WebElement nameInput;
    @FindBy(name= "lastname")
    private WebElement lastnameInput;
    @FindBy(name="alias")
    private WebElement aliasInput;
    @FindBy(name="address1")
    private WebElement addressInput;
    @FindBy(name="city")
    private WebElement cityInput;
    @FindBy(name="postcode")
    private WebElement postcodeInput;
    @FindBy(name="id_country")
    private WebElement countryInput;
    @FindBy(xpath = "//footer/button[@type='submit']")
    private WebElement submitAddressBtn;
    @FindBy(name="phone")
    private WebElement phoneInput;



    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String firstname, String lastname, String alias, String address, String city, String postcode, String country, String phone) {

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(firstname);

        lastnameInput.click();
        lastnameInput.clear();
        lastnameInput.sendKeys(lastname);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        countryInput.click();
        countryInput.sendKeys(country);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(submitAddressBtn));
        submitAddressBtn.click();
    }

}