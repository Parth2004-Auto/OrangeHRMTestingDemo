package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LeavePage;
import com.orangehrmdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeaveTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeavePage leavePage;

    @BeforeMethod
    public void leaveSetup() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.doLogin(System.getProperty("username", "Admin"),
                System.getProperty("password", "admin123"));
        leavePage = dashboardPage.clickLeave();
    }

    @Test(priority = 1, description = "TM_LEAVE_001: Verify Leave List")
    public void verifyLeaveListTest() {
        Assert.assertTrue(leavePage.isLeaveListDisplayed(), "Leave list header not displayed");
    }
}
