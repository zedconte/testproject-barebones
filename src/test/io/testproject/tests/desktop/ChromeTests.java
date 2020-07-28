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

package test.io.testproject.tests.desktop;

import io.testproject.java.enums.AutomatedBrowserType;
import io.testproject.java.sdk.v2.Runner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import test.io.testproject.tests.Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.BrowserWebDriverContainer;
import test.util.AfterEachExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import static main.java.io.testproject.Configuration.DEV_TOKEN;

@Testcontainers
public class ChromeTests {

    private static Runner runner;
    protected static WebDriver driver;

    @Container
    private static final BrowserWebDriverContainer BROWSER_CONTAINER = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions());

    @RegisterExtension
    private static AfterEachExtension afterEachExtension = new AfterEachExtension();

    @BeforeAll
    private static void setup() throws InstantiationException {
        runner = Runner.createWeb(DEV_TOKEN, AutomatedBrowserType.Chrome);
        driver = BROWSER_CONTAINER.getWebDriver();
    }

    @BeforeEach
    private void beforeEach() throws InstantiationException {
        driver = BROWSER_CONTAINER.getWebDriver();
        afterEachExtension.setDriver(driver);
    }

    @AfterAll
    private static void tearDown() throws IOException {
        runner.close();
        driver.quit();
    }

    @Test
    public void automationPracticeTest() throws Exception {
        Tests.automationPracticeSignIn(runner);
    }

    @Disabled("Disabled - bug 1234")
    @Test
    public void proxyTest() throws Exception {
        Tests.proxyTest(runner);
    }

    @Disabled("Disabled - bug 1234")
    @Test
    @DisplayName("The testproject.io web site should have the correct title")
    void projectWebSiteShouldHaveCorrectTitleTest() {
        driver.get("https://www.testproject.io");
        assertThat(driver.getTitle())
                .contains("Free Test Automation For All");
    }

    @Disabled("Disabled - bug 1234")
    @Test
    @DisplayName("The testproject.io blog should have the correct title")
    void projectBlogShouldHaveCorrectTitleTest() {
        driver.get("https://blog.testproject.io/");
        assertThat(driver.getTitle())
                .isEqualTo("Test Automation Blog | TestProject");
    }
    }