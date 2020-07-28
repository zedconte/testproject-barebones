/*
 * testproject-challenge
 * Copyright (C) 2020  Raul Ortega
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
