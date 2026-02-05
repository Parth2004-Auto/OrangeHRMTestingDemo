package com.orangehrmdemo.pages;

import com.orangehrmdemo.utils.ElementUtil;
import org.openqa.selenium.By;

public class LeavePage {
    private ElementUtil elementUtil;

    // Locators
    private By applyLink = By.xpath("//a[normalize-space()='Apply']");
    private By myLeaveLink = By.xpath("//a[normalize-space()='My Leave']");
    private By leaveListHeader = By.xpath("//h5[normalize-space()='Leave List']");

    public LeavePage() {
        this.elementUtil = new ElementUtil();
    }

    public void clickApply() {
        elementUtil.click(applyLink);
    }

    public void clickMyLeave() {
        elementUtil.click(myLeaveLink);
    }

    public boolean isLeaveListDisplayed() {
        return elementUtil.isDisplayed(leaveListHeader);
    }
}
