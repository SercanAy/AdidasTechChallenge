package com.productStore.pages;

import com.productStore.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPurchasePage extends BasePage {

    @FindBy(xpath = "(//p[@class='lead text-muted '])")
    public WebElement purchaseInformation;


    public static WebElement selectButton(String buttonName) {
        WebElement button = Driver.get().findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
        return button;
    }

    public static WebElement deleteProduct(String productName) {
        WebElement product = Driver.get().findElement(By.xpath("(//td[contains(text(),'" + productName + "')]//..)//a"));
        return product;
    }

    public static WebElement selectInput(String inputName) {
        WebElement input = Driver.get().findElement(By.xpath("//input[@id='" + inputName.toLowerCase() + "']"));
        return input;
    }

}
