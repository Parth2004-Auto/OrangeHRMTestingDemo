package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.AdminPage;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @Test(description = "Search User in Admin Module")
    public void searchUserTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        AdminPage adminPage = dashboardPage.navigateToAdmin();
        adminPage.searchUser("Admin");

        // Verify at least one user found
        Assert.assertTrue(adminPage.getNumberOfUserRows() > 0, "Should find users with username Admin");

        dashboardPage.logout();
    }
}
