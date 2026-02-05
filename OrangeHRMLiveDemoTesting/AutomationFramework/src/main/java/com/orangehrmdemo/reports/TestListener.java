package com.orangehrmdemo.reports;

import com.orangehrmdemo.base.DriverManager;
import com.orangehrmdemo.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getDescription());
        test.set(extentTest);
        ExtentManager.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
        test.get().fail(result.getThrowable());

        // Capture screenshot
        if (DriverManager.getDriver() != null) {
            String screenshotPath = ScreenshotUtil.getBase64Screenshot();
            test.get().addScreenCaptureFromBase64String(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
