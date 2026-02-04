package com.orangehrmdemo.tests;

import com.orangehrmdemo.base.BaseTest;
import com.orangehrmdemo.pages.DashboardPage;
import com.orangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMTest extends BaseTest {

    @Test(priority = 1, description = "Add New Employee")
    public void addNewEmployeeTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        PIMPage pimPage = dashboardPage.navigateToPIM();
        pimPage.addEmployee("John", "Doe");

        Assert.assertTrue(pimPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after adding employee");

        dashboardPage.logout();
    }

    @Test(priority = 2, description = "Search Employee")
    public void searchEmployeeTest() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.doLogin("Admin", "admin123");

        PIMPage pimPage = dashboardPage.navigateToPIM();
        pimPage.searchEmployee("John Doe");
        // Verify results if we added method to count rows or verify name

        dashboardPage.logout();
    }
}
