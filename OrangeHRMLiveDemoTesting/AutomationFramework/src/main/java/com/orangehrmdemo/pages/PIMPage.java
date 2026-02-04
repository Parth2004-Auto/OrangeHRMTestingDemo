package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class PIMPage {
    private ElementUtil elementUtil;

    // Locators
    private By addEmployeeButton = By.xpath("//button[normalize-space()='Add']");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit']");
    private By successMessage = By.xpath("//p[contains(@class, 'oxd-text--toast-message')]");

    // Search Locators
    private By employeeNameInput = By
            .xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By employeeRow = By.xpath("//div[@class='oxd-table-card']");

    public PIMPage() {
        this.elementUtil = new ElementUtil();
    }

    public void addEmployee(String firstName, String lastName) {
        elementUtil.click(addEmployeeButton);
        elementUtil.sendKeys(firstNameInput, firstName);
        elementUtil.sendKeys(lastNameInput, lastName);
        elementUtil.click(saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return elementUtil.isDisplayed(successMessage);
    }

    public void searchEmployee(String name) {
        elementUtil.sendKeys(employeeNameInput, name);
        // Autocomplete selection might be needed here, keeping it simple for now
        elementUtil.click(searchButton);
    }
}
