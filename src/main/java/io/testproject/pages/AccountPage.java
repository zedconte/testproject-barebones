package main.java.io.testproject.pages;

import io.testproject.java.sdk.v2.drivers.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccountPage extends Page {

    private WebDriver driver;

    @FindBy(className = "page-heading")
    private WebElement Header;

    @FindBy(className = "icon-chevron-left")
    private WebElement HomeButton;

    @FindBy(className = "logout")
    private WebElement SignOut;

    @FindBy(className = "myaccount-link-list")
    private List<WebElement> Sections;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AssertAccount() {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(Header));
        //wait.until(ExpectedConditions.visibilityOf(HomeButton));
        wait.until(ExpectedConditions.elementToBeClickable(SignOut));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "My account - My Store";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        Assert.assertEquals(Sections.size(), 2);
    }

    public HomePage logout() {
        SignOut.click();
        return new HomePage(driver);
    }

    @Override
    public void verifyDisplayed() {

    }
}
