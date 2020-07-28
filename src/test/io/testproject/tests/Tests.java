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

package test.io.testproject.tests;

import main.java.io.testproject.model.Customer;
import main.java.io.testproject.tests.AutomationPracticeTest;
import io.testproject.java.sdk.v2.Runner;
import main.java.io.testproject.tests.ProxyTest;
import test.util.SystemUtil;

import java.util.Properties;

public class Tests {

    public static void automationPracticeSignIn(Runner runner) throws Exception {
        // Create test

        AutomationPracticeTest test = new AutomationPracticeTest();
        Properties properties = SystemUtil.loadPropertiesResources("/automationpractice.properties");
        Customer customer = new Customer();
        customer.setFirstName(properties.getProperty("firstName"));
        customer.setLastName(properties.getProperty("lastName"));
        customer.setPassword(properties.getProperty("password"));
        customer.setCity(properties.getProperty("city"));
        customer.setAddress(properties.getProperty("address"));
        customer.setPhone(properties.getProperty("phone"));
        customer.setDobDay(properties.getProperty("dobDay"));
        customer.setDobMonth(properties.getProperty("dobMonth"));
        customer.setDobYear(properties.getProperty("dobYear"));
        customer.setState(properties.getProperty("state"));
        customer.setZip(properties.getProperty("zip"));
        test.customer = customer;
        // Run test
        runner.run(test);
    }

    public static void proxyTest(Runner runner) throws Exception {
        // Create test

        ProxyTest test = new ProxyTest();
        // Run test
        runner.run(test);
    }
}
