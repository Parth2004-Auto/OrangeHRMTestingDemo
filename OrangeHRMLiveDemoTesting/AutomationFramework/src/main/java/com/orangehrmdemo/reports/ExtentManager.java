package com.orangehrmdemo.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports createInstance() {
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory + fileName;

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("OrangeHRMDemo Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("OrangeHRMDemo Functional Testing");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Organization", "OrangeHRMDemo");
        extent.setSystemInfo("Browser", "Chrome/Edge");
        return extent;
    }

    private static String getReportName() {
        Date d = new Date();
        String fileName = "TestReport_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(d) + ".html";
        return fileName;
    }

    public static ExtentReports getExtent() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }
}
