package com.productStore.pages;

import com.productStore.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

    public static WebElement selectProduct(String productName){
        WebElement product = Driver.get().findElement(By.xpath("//a[contains(text(),'"+productName+"')]"));

        return product;
    }
    

    public static WebElement selectCategory(String categoryName){

        WebElement category = null;
        switch (categoryName.toLowerCase()){

            case "phone": case "monitor":
                category = Driver.get().findElement(By.xpath("//a[contains(@onclick,'"+categoryName+"')]"));
                break;
            case "laptop":
                category = Driver.get().findElement(By.xpath("//a[contains(@onclick,'notebook')]"));
                break;
        }
        return category;

    }


}

