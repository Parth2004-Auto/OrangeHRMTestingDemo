package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.AdminPage;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class AdminTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void adminSetup() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.doLogin(System.getProperty("username", "Admin"),
                System.getProperty("password", "admin123"));
        adminPage = dashboardPage.clickAdmin();
    }

    @Test(priority = 1, description = "TC_ADMIN_001: Search System User")
    public void searchSystemUserTest() {
        String searchUser = "Admin";
        adminPage.searchSystemUser(searchUser);

        // Assert at least one user found
        Assert.assertTrue(adminPage.getSystemUserCount() > 0, "No users found for search: " + searchUser);

        // Validate the specific user is in the list
        List<String> usernames = adminPage.getSystemUsernames();
        boolean found = usernames.stream().anyMatch(u -> u.equals(searchUser));
        Assert.assertTrue(found, "User " + searchUser + " not found in search results");
    }
}
