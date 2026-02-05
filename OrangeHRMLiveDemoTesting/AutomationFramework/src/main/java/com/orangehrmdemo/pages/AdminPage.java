package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AdminPage {
    private ElementUtil elementUtil;

    // Locators
    private By usernameSearchField = By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By resetButton = By.xpath("//button[normalize-space()='Reset']");
    private By userListRows = By.xpath("//div[@class='oxd-table-card']");
    private By userListUsernameCells = By.xpath("//div[@class='oxd-table-body']//div[@role='row']/div[2]");
    private By userRoleDropdown = By.xpath(
            "//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']");
    private By addUserButton = By.xpath("//button[normalize-space()='Add']");

    public AdminPage() {
        this.elementUtil = new ElementUtil();
    }

    public void searchSystemUser(String username) {
        try {
            // Wait for potential previous search or page load
            // Thread.sleep(1000); // Ideally use explicit wait for loader
            elementUtil.waitForLoaderToDisappear();
        } catch (Exception e) {
        }

        elementUtil.sendKeys(usernameSearchField, username);
        elementUtil.click(searchButton);
        elementUtil.waitForLoaderToDisappear();
    }

    public int getSystemUserCount() {
        return elementUtil.getElements(userListRows).size();
    }

    public List<String> getSystemUsernames() {
        // Implementation to generic get list of texts could be added to ElementUtil,
        // but doing specific here
        List<WebElement> userCells = elementUtil.getElements(userListUsernameCells);
        return userCells.stream().map(WebElement::getText).toList();
    }

    public void clickAddUser() {
        elementUtil.click(addUserButton);
    }
}
