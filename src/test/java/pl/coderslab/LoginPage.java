package pl.coderslab;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwdInput;
    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwdInput.click();
        passwdInput.clear();
        passwdInput.sendKeys(password);

        signInBtn.click();
    }



}