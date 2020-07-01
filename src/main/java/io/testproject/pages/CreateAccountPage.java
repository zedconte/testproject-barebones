package main.java.io.testproject.pages;

import io.testproject.java.sdk.v2.drivers.WebDriver;
import main.java.io.testproject.model.Customer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends Page {

    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement gender;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "submitAccount")
    private WebElement submit;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "phone_mobile")
    private WebElement phone;

    @FindBy(id = "postcode")
    private WebElement zip;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage FillAccountData(Customer customer) {
        gender.click();
        firstName.sendKeys(customer.getFirstName());
        lastName.sendKeys(customer.getLastName());
        password.sendKeys(customer.getPassword());
        address.sendKeys(customer.getAddress());
        city.sendKeys(customer.getCity());
        phone.sendKeys(customer.getPhone());
        alias.clear();
        alias.sendKeys(customer.getEmail().split("@")[0]);
        Select selectObject = new Select(state);
        selectObject.selectByVisibleText(customer.getState());
        zip.sendKeys(customer.getZip());
        submit.click();
        return new AccountPage(driver);

    }

    @Override
    public void verifyDisplayed() {

    }
}
