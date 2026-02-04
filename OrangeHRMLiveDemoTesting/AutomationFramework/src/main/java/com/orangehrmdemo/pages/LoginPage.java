package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class LoginPage {
    private ElementUtil elementUtil;

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By invalidCredsMsg = By.xpath("//p[contains(@class, 'alert-content-text')]");
    private By usernameRequiredMsg = By.xpath(
            "//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-group__message')]");
    private By passwordRequiredMsg = By.xpath(
            "//input[@name='password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-group__message')]");

    public LoginPage() {
        this.elementUtil = new ElementUtil();
    }

    public DashboardPage doLogin(String username, String password) {
        elementUtil.sendKeys(usernameField, username);
        elementUtil.sendKeys(passwordField, password);
        elementUtil.click(loginButton);
        return new DashboardPage();
    }

    public boolean isInvalidCredsMsgDisplayed() {
        return elementUtil.isDisplayed(invalidCredsMsg);
    }

    public boolean isRequiredMsgDisplayed() {
        return elementUtil.isDisplayed(usernameRequiredMsg);
    }
}
