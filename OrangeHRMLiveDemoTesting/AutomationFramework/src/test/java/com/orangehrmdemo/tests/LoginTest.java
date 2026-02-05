package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void loginSetup() {
        loginPage = new LoginPage();
    }

    @Test(priority = 1, description = "TC_LOGIN_001: Verify valid login")
    public void validLoginTest() {
        dashboardPage = loginPage.doLogin(System.getProperty("username", "Admin"),
                System.getProperty("password", "admin123"));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard header not displayed after login");
        Assert.assertEquals(dashboardPage.getDashboardHeader(), "Dashboard", "Header text mismatch");
    }

    @Test(priority = 2, description = "TC_LOGIN_002: Verify invalid login")
    public void invalidLoginTest() {
        loginPage.doLogin("invalid", "invalid");
        Assert.assertTrue(loginPage.isInvalidCredsMsgDisplayed(), "Invalid credentials message not displayed");
    }

    @Test(priority = 3, description = "TC_LOGIN_003: Verify empty login")
    public void emptyLoginTest() {
        loginPage.doLogin("", "");
        Assert.assertTrue(loginPage.isRequiredMsgDisplayed(), "Required message not displayed for empty fields");
    }
}
