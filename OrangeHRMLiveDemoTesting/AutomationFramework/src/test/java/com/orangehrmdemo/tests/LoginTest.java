package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify Valid Login")
    public void verifyValidLogin() {
        LoginPage loginPage = new LoginPage();
        // Default credentials for OrangeHRM Opensource
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        Assert.assertTrue(dashboardPage.isUserDropdownDisplayed(), "User dropdown should be displayed after login");
        Assert.assertEquals(dashboardPage.getHeader(), "Dashboard", "Header should be Dashboard");

        dashboardPage.logout();
    }

    @Test(priority = 2, description = "Verify Invalid Login")
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin("InvalidUser", "InvalidPass");
        Assert.assertTrue(loginPage.isInvalidCredsMsgDisplayed(), "Invalid credentials message should be displayed");
    }

    @Test(priority = 3, description = "Verify Empty Credentials")
    public void verifyEmptyCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin("", "");
        Assert.assertTrue(loginPage.isRequiredMsgDisplayed(), "Required message should be displayed");
    }
}
