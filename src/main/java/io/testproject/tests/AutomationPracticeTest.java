package main.java.io.testproject.tests;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.enums.TakeScreenshotConditionType;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.TestReporter;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import io.testproject.proxy.addon.io.testproject.addon.slack.actions.SendSlackMessageAction;
import main.java.io.testproject.model.Customer;
import main.java.io.testproject.pages.AccountPage;
import main.java.io.testproject.pages.LoginPage;
import main.java.io.testproject.pages.CreateAccountPage;
import main.java.io.testproject.pages.HomePage;
import main.utils.Faker;
import org.openqa.selenium.By;
import test.util.SystemUtil;

import java.util.Properties;

public class AutomationPracticeTest implements WebTest {

    public Customer customer;

    CreateAccountPage createAccountPage;

    @Parameter(description = "Contains the url of the search page")
    private String webhook;

    @Parameter(description = "Contains the submitted search term")
    private String text;

    public ExecutionResult execute(WebTestHelper helper) throws FailureException {
        // Get driver initialized by TestProject Agent
        // No need to specify browser type, it can be done later via UI
        WebDriver driver = helper.getDriver();
        TestReporter report = helper.getReporter();
        Properties properties = SystemUtil.loadPropertiesResources("/automationpractice.properties");
        webhook = properties.getProperty("webhook");
        text = "AutomationPractice Test ran successfully in " + driver.getCapabilities().getBrowserName();

        report.step("Test Started", true, TakeScreenshotConditionType.Always);

        // Navigate to TestProject Demo website
        driver.navigate().to("http://automationpractice.com/index.php");

        // Login using provided credentials
        HomePage homePage = new HomePage(driver);

        // Complete profile forms and save it
        LoginPage loginPage = homePage.clickSignIn();

        if(loginPage.isDisplayed()) {
            customer.setEmail(Faker.getRandomEmail());
            createAccountPage = loginPage.FillEmail(customer.getEmail());
        }
        AccountPage accountPage = createAccountPage.FillAccountData(customer);
        accountPage.AssertAccount();
        homePage = accountPage.logout();
        homePage.verifyDisplayed();
        report.result("Test completed successfully");
        SendSlackMessageAction slack = new SendSlackMessageAction(webhook, text, "#36a64f", "AutomationPracticeTest", "http://192.168.0.112:9000/index.html", "Raul Ortega", "This is an additional text you can add to the attachment");
        ExecutionResult result = helper.executeProxy(slack, new By.ByXPath("//"));

        return ExecutionResult.PASSED;
    }
}

