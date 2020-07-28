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

import main.java.io.testproject.actions.ClearFieldsAction;
import io.testproject.java.sdk.v2.Runner;
import io.testproject.java.sdk.v2.drivers.WebDriver;
import org.openqa.selenium.By;

public class Actions {

    public static void runAction(Runner runner) throws Exception {
        // Create Action
        ClearFieldsAction action = new ClearFieldsAction();

        // Prepare state
        WebDriver driver = runner.getDriver();

        driver.navigate().to("https://example.testproject.io/web/");
        driver.findElement(By.id("name")).sendKeys("John Smith");
        driver.findElement(By.id("password")).sendKeys("12345");

        // Run action
        runner.run(action);
    }

}