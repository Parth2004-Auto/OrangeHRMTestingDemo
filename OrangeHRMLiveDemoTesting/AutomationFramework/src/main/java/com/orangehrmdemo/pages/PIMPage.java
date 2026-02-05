package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class PIMPage {
    private ElementUtil elementUtil;

    // Locators
    private By addEmployeeButton = By.xpath("//button[normalize-space()='Add']");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//div[@class='oxd-toast-content oxd-toast-content--success']");
    private By employeeListHeader = By.xpath("//h5[normalize-space()='Employee Information']");
    private By employeeNameSearchField = By
            .xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By firstRowId = By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]/div[2]");

    public PIMPage() {
        this.elementUtil = new ElementUtil();
    }

    public void addEmployee(String firstName, String lastName) {
        elementUtil.click(addEmployeeButton);
        elementUtil.sendKeys(firstNameField, firstName);
        elementUtil.sendKeys(lastNameField, lastName);
        elementUtil.click(saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return elementUtil.isDisplayed(successMessage);
    }

    public void searchEmployee(String name) {
        elementUtil.click(By.xpath("//a[contains(text(),'Employee List')]")); // Ensure we are on list
        elementUtil.waitForLoaderToDisappear();
        elementUtil.sendKeys(employeeNameSearchField, name);
        // Note: Specific dropdown selection logic might be needed for auto-complete
        // For simple text entry:
        elementUtil.click(searchButton);
        elementUtil.waitForLoaderToDisappear();
    }

    public String getFirstEmployeeId() {
        return elementUtil.getText(firstRowId);
    }
}
