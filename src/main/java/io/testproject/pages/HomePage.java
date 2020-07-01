package main.java.io.testproject.pages;

import io.testproject.java.sdk.v2.drivers.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

    private WebDriver driver;
    @FindBy(className = "login")
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return signIn.isDisplayed();
    }

    public LoginPage clickSignIn() {
        signIn.click();
        return new LoginPage(driver);
    }

    @Override
    public void verifyDisplayed() {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(signIn));
    }
}
