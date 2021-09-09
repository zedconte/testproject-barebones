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
