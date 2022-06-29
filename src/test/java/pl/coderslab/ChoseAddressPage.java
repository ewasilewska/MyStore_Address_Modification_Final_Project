package pl.coderslab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChoseAddressPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement newAddressBtn;

    @FindBy(xpath = "//a[@data-link-action='delete-address']")
    private WebElement deleteAddressBtn;


    @FindAll(@FindBy(className ="address-body"))
    private List<WebElement> addressBoxes;

    @FindBy(className ="address-body")
    private WebElement addressBox;


    public ChoseAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean correctFirstname(String firstname) {
        String text = addressBox.getText();
        return text.contains(firstname);
    }

    public boolean correctLastname(String lastname) {
        String text = addressBox.getText();
        return text.contains(lastname);
    }

    public void checkIfAddressAdded() {
            while (addressBoxes.size()>0) {
            deleteAddressBtn.click();
        }
    }

    public void addAddress() {
        newAddressBtn.click();
    }

    public void deleteAddress() {
        deleteAddressBtn.click();
    }


    public String gettingAddressDetails() {
        String addressDetails = addressBox.getText();
        addressDetails = addressDetails.replaceAll(System.lineSeparator(), " ");
        return addressDetails;
    }


}