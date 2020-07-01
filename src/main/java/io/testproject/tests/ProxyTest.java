package main.java.io.testproject.tests;

import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.tests.WebTest;
import io.testproject.java.sdk.v2.tests.helpers.WebTestHelper;
import io.testproject.proxy.addon.io.testproject.addon.slack.actions.SendSlackMessageAction;
import main.java.io.testproject.tests.ActionRunner;
import org.openqa.selenium.By;

@Test(
        name = "The search result page must have the expected title",
        description = "Verify that the search result page has the expected title"
)
public class ProxyTest implements WebTest {

    @Parameter(description = "Contains the url of the search page")
    private String webhook;

    @Parameter(description = "Contains the submitted search term")
    private String text;

    //@Parameter(description = "Contains the expected title of the search result page")
    //private String expectedSearchResultPageTitle;

    @Override
    public ExecutionResult execute(WebTestHelper helper) throws FailureException {

            WebDriver browser = helper.getDriver();
            browser.get("http://automationpractice.com/index.php");

            ActionRunner actionRunner = new ActionRunner(helper);

            webhook = "https://hooks.slack.com/services/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";
            text = "Proxy Test ran successfully";
/*            ClearBlogSearchFieldAction clearSearchField = BlogSearchAddon
                    .getClearBlogSearchFieldAction();
            actionRunner.runAction(clearSearchField);

            BlogSearchAction blogSearch = BlogSearchAddon.blogSearchAction(searchTerm);
            actionRunner.runAction(blogSearch);*/

        SendSlackMessageAction slack = new SendSlackMessageAction(webhook, text, "#36a64f", "Proxy Test", "https://api.slack.com/", "Raul Ortega", "This is an additional text you can add to the attachment");
        ExecutionResult result = helper.executeProxy(slack, new By.ByXPath("//"));

        return result;
    }
}
