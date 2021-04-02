package org.example;

import org.example.tests.CreateModalTest;
import org.example.tests.ExitTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.LinkedList;
import java.util.List;

public class TestExecutor {
    private List<SeleniumTest> seleniumTests = new LinkedList<>();
    private WebDriver webDriver = new FirefoxDriver();

    private final String url;
    private final String login;
    private final String password;

    public TestExecutor(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
        login();

        seleniumTests.add(new CreateModalTest());
        seleniumTests.add(new ExitTest());

        try {
            executeTests();
        } catch (NotFoundException | AssertionError e) {
            e.printStackTrace();
            webDriver.close();
            System.exit(-1);
        }
        webDriver.close();
    }

    private void login() {
        webDriver.get(url);
        assert webDriver.getCurrentUrl().endsWith("login");
        webDriver.findElement(By.id("username")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("login-button")).click();
        assert webDriver.getCurrentUrl().equals(url);
    }

    private void executeTests() throws NotFoundException, AssertionError {
        for (SeleniumTest test: seleniumTests) {
            test.executeTest(webDriver);
            webDriver.get(webDriver.getCurrentUrl());
        }
    }
}
