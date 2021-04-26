package com.productStore.stepDefinitions;

import com.productStore.pages.BasePage;
import com.productStore.pages.DashboardPage;
import com.productStore.pages.ProductPage;
import static com.productStore.pages.ProductPurchasePage.*;

import com.productStore.pages.ProductPurchasePage;
import com.productStore.utilities.BrowserUtils;
import com.productStore.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class ProductStepDefs {


    ProductPage productPage = new ProductPage();


    @Given("the user clicks on {string} category")
    public void the_user_clicks_on_category(String category) {

        BrowserUtils.waitForVisibility(DashboardPage.selectCategory(category), 5);
        DashboardPage.selectCategory(category).click();
    }

    @Given("the user clicks on {string} product")
    public void the_user_clicks_on_product(String product) {

        DashboardPage.selectProduct(product).click();
    }

    @Given("the user clicks on Add to cart")
    public void the_user_clicks_on_Add_to_cart() {
        productPage.addToCartButton.click();
        BrowserUtils.waitForAlert(4);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
        BasePage.getModule("home").click();
    }

    @When("the user clicks on {string} module")
    public void the_user_clicks_on_module(String moduleName) {

        BasePage.getModule(moduleName).click();
    }

    @When("the user deletes {string} product from cart")
    public void the_user_deletes_product_from_cart(String product) {

        deleteProduct(product).click();
        BrowserUtils.waitForInvisibilityOf(deleteProduct(product),5);
    }

    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String button) {

        BrowserUtils.waitForVisibility(selectButton(button),4);
        selectButton(button).click();
    }

    @Then("the user fills all web form fields")
    public void the_user_fills_all_web_form_fields() {
        selectInput("Name").sendKeys("Aitana");
        selectInput("country").sendKeys("Spain");
        selectInput("city").sendKeys("Huesca");
        selectInput("card").sendKeys("4485750102200421");
        selectInput("month").sendKeys("03/26");
        selectInput("year").sendKeys("2000");
    }

    @Then("the user should expect {string} amount")
    public void the_user_should_expect_amount(String amount) {

        String actualAmount = new ProductPurchasePage().purchaseInformation.getText();

        Assert.assertTrue(actualAmount.contains(amount));
    }

}
