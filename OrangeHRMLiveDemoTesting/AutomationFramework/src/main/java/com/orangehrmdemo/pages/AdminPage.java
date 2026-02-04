package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class AdminPage {
    private ElementUtil elementUtil;

    // Locators
    private By usernameInput = By.xpath("//label[text()='Username']/parent::div/following-sibling::div//input");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By userRow = By.xpath("//div[@class='oxd-table-card']");

    public AdminPage() {
        this.elementUtil = new ElementUtil();
    }

    public void searchUser(String username) {
        elementUtil.sendKeys(usernameInput, username);
        elementUtil.click(searchButton);
    }

    public int getNumberOfUserRows() {
        // Wait for table to load/update. In real usage, might need explicit wait for
        // loading spinner to disappear.
        try {
            Thread.sleep(2000); // Replacing with explicit wait in production code ideally
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return elementUtil.getElements(userRow).size();
    }
}
