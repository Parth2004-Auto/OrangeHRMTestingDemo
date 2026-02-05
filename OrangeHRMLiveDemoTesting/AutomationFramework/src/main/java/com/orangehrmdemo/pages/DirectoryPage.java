package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class DirectoryPage {
    private ElementUtil elementUtil;

    // Locators
    private By directoryHeader = By.xpath("//h6[normalize-space()='Directory']");
    private By searchNameField = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resultCard = By.className("oxd-sheet");

    public DirectoryPage() {
        this.elementUtil = new ElementUtil();
    }

    public boolean isDirectoryHeaderDisplayed() {
        return elementUtil.isDisplayed(directoryHeader);
    }

    public void searchUser(String name) {
        elementUtil.sendKeys(searchNameField, name);
        // autocomplete might appear
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        } // Wait for autocomplete
        // Select first option if needed, or just search
        elementUtil.click(By.xpath("//div[@role='listbox']//span")); // Click first suggestion
        elementUtil.click(searchButton);
    }

    public int getResultCount() {
        return elementUtil.getElements(resultCard).size();
    }
}
