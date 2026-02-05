package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.base.DriverManager;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void dashboardSetup() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.doLogin(System.getProperty("username", "Admin"),
                System.getProperty("password", "admin123"));
    }

    @Test(priority = 1, description = "TC_DASH_001: Verify Dashboard Load")
    public void verifyDashboardLoad() {
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard header is not displayed");
        Assert.assertEquals(dashboardPage.getDashboardHeader(), "Dashboard", "Dashboard header text mismatch");
    }

    @Test(priority = 2, description = "TC_DASH_002: Verify Menu Visibility & Logout")
    public void verifyLogout() {
        dashboardPage.doLogout();
        Assert.assertTrue(
                loginPage.isRequiredMsgDisplayed() || DriverManager.getDriver().getCurrentUrl().contains("login"),
                "Logout failed or Login page not displayed");
    }
}
