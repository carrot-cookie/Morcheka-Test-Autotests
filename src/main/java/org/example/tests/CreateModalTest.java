package org.example.tests;

import org.example.SeleniumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateModalTest implements SeleniumTest {
    @Override
    public void executeTest(WebDriver driver) throws NotFoundException, AssertionError {
        driver.findElement(By.id("create-button")).click();
        assert driver.findElement(By.tagName("body")).getAttribute("class").equals("modal-open");
        WebElement createModalBody = driver.findElement(By.id("create-modal-body"));
        createModalBody.findElement(By.id("login")).sendKeys("test");
        createModalBody.findElement(By.id("password")).sendKeys("12345");
        createModalBody.findElement(By.id("name")).sendKeys("Vasya");
        createModalBody.findElement(By.id("lastName")).sendKeys("Pupkin");
        createModalBody.findElement(By.id("lastName")).sendKeys("Pupkin");
        createModalBody.findElement(By.id("calendar-button")).click();
        WebElement calendar = driver.findElement(By.className("ngb-dp-content"));
        calendar.findElement(By.className("btn-light")).click();
        createModalBody.findElement(By.id("email")).sendKeys("mail@mail.com");
        assert createModalBody.findElement(By.id("save-button")).getTagName().equals("button");
        WebElement createModalHeader = driver.findElement(By.id("create-modal-header"));
        createModalHeader.findElement(By.id("close-button")).click();
        assert driver.findElement(By.tagName("body")).getAttribute("class").equals("");
    }
}
