# testproject-barebones

This repository contains code examples for creating a [TestProject](https://testproject.io/) automation framework targeting Automation Practice site http://automationpractice.com/index.php

# TestProject Java SDK

This repository contains code examples based on TestProject Java SDK.

## Briefing

This document includes a basic automation suite created with TestProject Java SDK.

## Preparations

To kick-off automation development with TestProject, it is necessary to have an active TestProject account and the TestProject Agent installed.\
TestProject's Agent is a cross-platform desktop application, allowing you to create, debug and execute your test automation locally.
TestProject Agent can be downloaded from [Agents](https://app.testproject.io/#/agents) page.

### Getting Java SDK

You can download TestProject SDK for Java from the [Developers](https://app.testproject.io/#/developers) page and reference it in your project.

#### Installing SDK

To use TestProject SDK you have to add it as a reference to your project.\
Here are some examples for how it should be done using Maven.

Maven:

```xml
<dependency>
    <groupId>io.testproject</groupId>
    <artifactId>java-sdk</artifactId>
    <version>1.0</version>
    <systemPath>/path/to/sdk/io.testproject.sdk.java.jar</systemPath>
    <scope>system</scope>
</dependency>
```

#### Install Docker Desktop

To run the project you need to install and run Docker Desktop from [Docker](https://www.docker.com/products/docker-desktop).

## IDE Test Development

In IntelliJ or your favorite IDE create a new JUnit configuration with Package **test.io.testproject.tests.desktop** and classpath of module **automation-practice-test**.

![ScreenShot](/screenshots/intellij-debug-config.png)

### Slack Webhooks

For reference please check how to create a [Incoming Webhook](https://api.slack.com/messaging/webhooks). When the url is created substitute in testdata/automationpractice.properties

### Setup SDK API key

Navigate to [TestProject Integrations](https://app.testproject.io/#/integrations/sdk) and copy or generate a new developer token. Copy the value and substitute in Project Root's **docker-compose.yaml** TP_API_KEY.

## Test Scenarios

## Feature

For implementation details review on **src/main/tests/AutomationPracticeTest.java**

```gherkin
Feature: AutomationPracticeTest
    Scenario: Register to Automation Practice website
        Given I am on Home Page
        When I click Sign In
        Then I see Create Account Page
        And I fill in "Email" with "<random_email>" for new account
        And I press "Create an account"
        Then I should be on the Create Account Page
        When I fill account details and submit
        Then I should be on Account Page
        And Account name should be "Mark Whalberg"
        And Title should be "My account - My Store"
        When I click Sign Out
        Then I should see Create Account Page
```

### Home
![ScreenShot](/screenshots/home.png)

### Sign up
![ScreenShot](/screenshots/sign-up.png)

### Fill in details
![ScreenShot](/screenshots/create-account.png)

### Fill in details (2)
![ScreenShot](/screenshots/create-account-submit.png)

### Assert Account Page
![ScreenShot](/screenshots/assert-account-and-signout.png)

### Logout confirmation
![ScreenShot](/screenshots/logout-confirmation.png)

### Slack Notification
![ScreenShot](/screenshots/slack-notification.png)

### Slack Mobile
![ScreenShot](/screenshots/slack-mobile.png)

## Execution

### TestProject Agent

Run TestProject Agent locally.

### Docker

Open a terminal, cd into Project Root and run:

```docker rm -f $(docker ps -a -q)```

```docker-compose up```

### Run tests in local agent/Docker

```mvn clean test allure:report```

### Create Report

```mvn allure:serve```

### Test Class

In order to build a Test that can be executed by TestProject, the class has to implement on of the interfaces that the SDK provides.\
Interface implementation requires an implementation of the *execute()* method, that will be be invoked by the platform to run the Test.\
The *execute()* method returns *ExecutionResult* enum which can be **PASSED** or **FAILED**.

## Packaging

In order to upload your Addons or Tests to TestProject, you have to package it as JAR file.\
Export your code as an uber JAR file with dependencies, excluding TestProject SDK.

See *pom.xml* files in code examples for details.

## Support

For any further inquiries, please use TestProject support channels:

* [Forum](https://forum.testproject.io/index.php/board,11.0.html)
* [Help Desk](https://support.testproject.io/)
