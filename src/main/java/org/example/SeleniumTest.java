package org.example;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

public interface SeleniumTest {
    public void executeTest(WebDriver driver) throws NotFoundException, AssertionError;
}
