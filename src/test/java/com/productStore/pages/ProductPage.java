package com.productStore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

   @FindBy(css = ".btn.btn-success")
    public WebElement addToCartButton;

}
