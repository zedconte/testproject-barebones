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
    private WebElement header;

    @FindBy(className = "icon-chevron-left")
    private WebElement homeButton;

    @FindBy(className = "logout")
    private WebElement signOut;

    @FindBy(className = "myaccount-link-list")
    private List<WebElement> sections;

    @FindBy(className = "account")
    private WebElement accountName;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AssertAccount(String name) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(header));
        wait.until(ExpectedConditions.visibilityOf(accountName));
        wait.until(ExpectedConditions.elementToBeClickable(signOut));
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "My account - My Store";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
        Assert.assertEquals(accountName.getText(), name);
        Assert.assertEquals(sections.size(), 2);
    }

    public HomePage logout() {
        signOut.click();
        return new HomePage(driver);
    }

    @Override
    public void verifyDisplayed() {

    }
}
