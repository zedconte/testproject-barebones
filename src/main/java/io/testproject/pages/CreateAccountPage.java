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
