package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class MyInfoPage {
    private ElementUtil elementUtil;

    // Locators
    private By firstNameInput = By.name("firstName");
    private By saveButton = By.xpath("//button[@type='submit'][1]"); // First save button usually
    private By successMessage = By.xpath("//p[contains(@class, 'oxd-text--toast-message')]");

    public MyInfoPage() {
        this.elementUtil = new ElementUtil();
    }

    public void updateFirstName(String newName) {
        elementUtil.waitForLoaderToDisappear();
        elementUtil.sendKeys(firstNameInput, newName);
        elementUtil.click(saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return elementUtil.isDisplayed(successMessage);
    }
}
