package com.productStore.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserUtils {


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitForAlert(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForInvisibilityOf(WebElement element,int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }






}
