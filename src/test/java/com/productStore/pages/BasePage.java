package com.productStore.pages;

import com.productStore.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public static WebElement getModule(String moduleName){
        WebElement module = null;

        if (moduleName.toLowerCase() == "home"){
            module = Driver.get().findElement(By.cssSelector("li.nav-item.active"));
        }else {
            module = Driver.get().findElement(By.xpath("//a[text()='" + moduleName + "']"));
        }

        return module;
    }


}
