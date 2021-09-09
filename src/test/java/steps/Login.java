package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Login {

    ChromeDriver driver = null;


    @Given("user on login page")
    public void user_on_login_page() throws MalformedURLException {
        System.out.println("I am inside GIVEN");
        driver  = new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withRemoteAddress(new URL("http://localhost:8585"))
                .withToken("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
                .build(ChromeDriver.class);
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("I am inside WHEN");
        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("I am inside WHEN");
        driver.findElement(By.cssSelector("#login")).click();
    }

    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() {
        System.out.println("I am inside THEN");
        boolean passed = driver.findElement(By.cssSelector("#logout")).isDisplayed();
        if (passed) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
