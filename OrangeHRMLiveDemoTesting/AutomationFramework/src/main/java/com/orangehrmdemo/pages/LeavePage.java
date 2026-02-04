package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class LeavePage {
    private ElementUtil elementUtil;

    // Locators
    private By applyLink = By.xpath("//a[normalize-space()='Apply']");
    private By leaveTypeDropdown = By.xpath("//div[@class='oxd-select-text-input']");
    private By fromDateInput = By.xpath("//label[text()='From Date']/parent::div/following-sibling::div//input");
    private By applyButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//p[contains(@class, 'oxd-text--toast-message')]");

    public LeavePage() {
        this.elementUtil = new ElementUtil();
    }

    public void applyLeave(String leaveType, String fromDate) {
        elementUtil.click(applyLink);
        // Dropdown handling in OrangeHRM is non-standard select, might need complex
        // logic.
        // For this task, we will just simulate basic interactions.
        elementUtil.click(leaveTypeDropdown);
        // Logic to select item would go here

        elementUtil.sendKeys(fromDateInput, fromDate);
        elementUtil.click(applyButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return elementUtil.isDisplayed(successMessage);
    }
}
