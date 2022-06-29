package pl.coderslab;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeletingAddressSteps {
    private WebDriver driver;

    @Given("I'm logged in MyStore page and I'm in address section")
    public void openGoogleSearchAnLoggiIn() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=addresses");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("ew.soroka@gmail.com", "!123!123");
    }

    @When("I click Delete button under chosen address")
    public void iClickDeleteButton() {
        ChoseAddressPage choseAddressPage = new ChoseAddressPage(driver);
        choseAddressPage.deleteAddress();
    }

    @Then("I remove the address and I see success message with text {string}")
    public void iCanSeeSuccessMessageWithText(String message) {
        String alertMessage = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assertions.assertEquals(message, alertMessage);

    }


}


