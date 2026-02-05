package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyInfoTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private MyInfoPage myInfoPage;

    @BeforeMethod
    public void myInfoSetup() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.doLogin(System.getProperty("username", "Admin"),
                System.getProperty("password", "admin123"));
        myInfoPage = dashboardPage.clickMyInfo();
    }

    @Test(priority = 1, description = "TC_INFO_001: Update Personal Details")
    public void updatePersonalDetailsTest() {
        Assert.assertTrue(myInfoPage.isPersonalDetailsHeaderDisplayed(), "Personal Details header not displayed");
        myInfoPage.updateFirstName("Paul");
        // Verify success message
        Assert.assertTrue(myInfoPage.isSuccessMessageDisplayed(), "Success message not displayed after update");
    }
}
