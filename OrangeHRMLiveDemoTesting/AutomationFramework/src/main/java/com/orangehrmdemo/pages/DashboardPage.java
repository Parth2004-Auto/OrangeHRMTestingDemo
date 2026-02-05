package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class DashboardPage {
    private ElementUtil elementUtil;

    // Locators
    private By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutLink = By.xpath("//a[normalize-space()='Logout']");

    // Menu Items
    private By adminMenu = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private By pimMenu = By.xpath("//a[@href='/web/index.php/pim/viewPimModule']");
    private By leaveMenu = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");
    private By myInfoMenu = By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']");
    private By directoryMenu = By.xpath("//a[@href='/web/index.php/directory/viewDirectory']");

    public DashboardPage() {
        this.elementUtil = new ElementUtil();
    }

    public String getDashboardHeader() {
        return elementUtil.getText(dashboardHeader);
    }

    public boolean isDashboardDisplayed() {
        return elementUtil.isDisplayed(dashboardHeader);
    }

    public AdminPage clickAdmin() {
        elementUtil.click(adminMenu);
        return new AdminPage();
    }

    public PIMPage clickPIM() {
        elementUtil.click(pimMenu);
        return new PIMPage();
    }

    public LeavePage clickLeave() {
        elementUtil.click(leaveMenu);
        return new LeavePage();
    }

    public MyInfoPage clickMyInfo() {
        elementUtil.click(myInfoMenu);
        return new MyInfoPage();
    }

    public DirectoryPage clickDirectory() {
        elementUtil.click(directoryMenu);
        return new DirectoryPage();
    }

    public void doLogout() {
        elementUtil.click(userDropdown);
        elementUtil.click(logoutLink);
    }
}
