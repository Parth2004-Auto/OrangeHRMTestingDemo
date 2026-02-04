package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "Verify Dashboard Menu Visibility")
    public void verifyDashboardMenu() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        Assert.assertEquals(dashboardPage.getHeader(), "Dashboard", "Dashboard header should be visible");
        // Additional menu verification could go here if we exposed isDisplayed methods
        // for each menu item in DashboardPage

        dashboardPage.logout();
    }
}
