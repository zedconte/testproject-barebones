package main.java.io.testproject.pages;

import io.testproject.java.sdk.v2.drivers.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement emailElement;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccount;

    @FindBy(css = "#login")
    private WebElement loginElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return emailElement.isDisplayed();
    }

    public CreateAccountPage FillEmail(String email) {
        emailElement.sendKeys(email);
        createAccount.click();
        return new CreateAccountPage(driver);
    }

    @Override
    public void verifyDisplayed() {

    }
}
