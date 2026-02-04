package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class DashboardPage {
    private ElementUtil elementUtil;

    // Locators
    private By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By headerTitle = By.xpath("//h6[contains(@class, 'oxd-text--h6')]");
    private By logoutLink = By.xpath("//a[contains(text(), 'Logout')]");

    // Menu Items
    private By adminMenu = By.xpath("//a[contains(@href, 'viewAdminModule')]");
    private By pimMenu = By.xpath("//a[contains(@href, 'viewPimModule')]");
    private By leaveMenu = By.xpath("//a[contains(@href, 'viewLeaveModule')]");
    private By myInfoMenu = By.xpath("//a[contains(@href, 'viewMyDetails')]");
    private By directoryMenu = By.xpath("//a[contains(@href, 'viewDirectoryModule')]");

    public DashboardPage() {
        this.elementUtil = new ElementUtil();
    }

    public boolean isUserDropdownDisplayed() {
        return elementUtil.isDisplayed(userDropdown);
    }

    public String getHeader() {
        return elementUtil.getText(headerTitle);
    }

    public void logout() {
        elementUtil.click(userDropdown);
        elementUtil.click(logoutLink);
    }

    public AdminPage navigateToAdmin() {
        elementUtil.click(adminMenu);
        return new AdminPage();
    }

    public PIMPage navigateToPIM() {
        elementUtil.click(pimMenu);
        return new PIMPage();
    }

    public LeavePage navigateToLeave() {
        elementUtil.click(leaveMenu);
        return new LeavePage();
    }

    public MyInfoPage navigateToMyInfo() {
        elementUtil.click(myInfoMenu);
        return new MyInfoPage();
    }
}
