package com.orangehrmdemo.utils;

import com.orangehrmdemo.base.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String getScreenshot(String testName) {
        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            return null;
        }

        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/reports/screenshots/" + testName + "_" + dateName
                + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String getBase64Screenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
