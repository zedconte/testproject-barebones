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
