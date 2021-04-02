package org.example.tests;

import org.example.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;

public class ExitTest implements SeleniumTest {
    @Override
    public void executeTest(WebDriver driver) throws NotFoundException, AssertionError {
        driver.findElement(By.id("exit-button")).click();
        assert driver.manage().getCookieNamed("jwt") == null;
    }
}
