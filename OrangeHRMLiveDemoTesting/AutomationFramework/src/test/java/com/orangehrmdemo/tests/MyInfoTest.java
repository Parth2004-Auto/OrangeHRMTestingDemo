package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends BaseTest {

    @Test(description = "Update Personal Info")
    public void updateMyInfoTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        MyInfoPage myInfoPage = dashboardPage.navigateToMyInfo();
        myInfoPage.updateFirstName("Paul");

        Assert.assertTrue(myInfoPage.isSuccessMessageDisplayed(), "Success message should be displayed after saving");

        // Revert change to keep data clean (optional, keeping it simple)
        myInfoPage.updateFirstName("Paul");

        dashboardPage.logout();
    }
}
