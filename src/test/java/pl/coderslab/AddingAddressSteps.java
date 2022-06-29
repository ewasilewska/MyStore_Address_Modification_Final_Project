package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddingAddressSteps {
    private WebDriver driver;

    @Given("I'm logged in on MyStore page")
    public void openGoogleSearch() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=addresses");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ew.soroka@gmail.com", "!123!123");
    }

    @When("I click Create new address button")
    public void createNewAddress() {
        ChoseAddressPage choseAddressPage = new ChoseAddressPage(driver);
        choseAddressPage.checkIfAddressAdded();
        choseAddressPage.addAddress();
        }



    @And("^I provide firstname (.+) lastname (.+) alias (.+) address (.+) city (.+) postcode (.+) country (.+) phone (.+)$")
    public void iProvideCorrectDataToTheAddressForm(String firstname, String lastname, String alias,String address, String city, String postcode, String country, String phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.addNewAddress(firstname, lastname, alias, address, city, postcode, country, phone);
    }


    @Then("I can see success message with text {string}")
        public void iCanSeeSuccessMessageWithText(String message) {
            String alertMessage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
            Assertions.assertEquals(message, alertMessage);

        }


    @And("I can see correct firstname {string}")
    public void correctName(String name) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctFirstname(name));

    }

    @And("correct lastname {string}")
    public void correctLastname(String lastname) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctLastname(lastname));
    }

    @And("correct address {string}")
    public void correctAddress(String address) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctLastname(address));
    }


    @And("correct city {string}")
    public void correctCity(String city) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctLastname(city));
    }


    @And("correct postcode {string}")
    public void correctPostcode(String postcode) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctLastname(postcode));
    }


    @And("correct phone {string}")
    public void correctPhone(String phone) {
        ChoseAddressPage newAddressDetails = new ChoseAddressPage(driver);
        Assertions.assertTrue(newAddressDetails.correctLastname(phone));
    }
}


