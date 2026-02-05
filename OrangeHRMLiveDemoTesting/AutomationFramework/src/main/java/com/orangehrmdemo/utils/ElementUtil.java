package com.orangehrmdemo.utils;

import com.orangehrmdemo.base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 15;

    public ElementUtil() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void waitForLoaderToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        } catch (Exception e) {
            // Loader might not be present or already disappeared
        }
    }
}
