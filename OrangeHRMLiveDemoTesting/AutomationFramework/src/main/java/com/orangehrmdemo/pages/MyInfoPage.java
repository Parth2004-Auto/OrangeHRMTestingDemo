package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MyInfoPage {
    private ElementUtil elementUtil;

    // Locators
    private By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");
    private By firstNameField = By.name("firstName");
    private By savePersonalDetailsButton = By
            .xpath("//h6[text()='Personal Details']/parent::div/following-sibling::div//button[@type='submit']"); // Generic
                                                                                                                  // locator,
                                                                                                                  // might
                                                                                                                  // need
                                                                                                                  // specific
    private By successMessage = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']");

    public MyInfoPage() {
        this.elementUtil = new ElementUtil();
    }

    public boolean isPersonalDetailsHeaderDisplayed() {
        return elementUtil.isDisplayed(personalDetailsHeader);
    }

    public void updateFirstName(String newName) {
        elementUtil.waitForLoaderToDisappear();
        // Clear might be tricky with React fields sometimes, using Keys.chord
        // elementUtil.sendKeys(firstNameField, Keys.chord(Keys.CONTROL, "a",
        // Keys.DELETE));
        // Keeping it simple for now as ElementUtil has clear
        elementUtil.sendKeys(firstNameField, newName);

        // Find the specific save button for personal details.
        // Often there are multiple save buttons. The first one is usually Personal
        // Details.
        elementUtil.click(By.xpath("(//button[@type='submit'])[1]"));
    }

    public boolean isSuccessMessageDisplayed() {
        return elementUtil.isDisplayed(successMessage);
    }
}
