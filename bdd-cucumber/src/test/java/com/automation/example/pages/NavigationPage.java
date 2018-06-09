package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends AbstractPage {

    @FindBy(id = "tab-products")
    WebElement productsTab;

    @FindBy(id = "tab-customers")
    WebElement customersTab;

    @FindBy(id = "tab-orders")
    WebElement ordersTab;

    private String E_COMMERCE_URL = "http://localhost:8080";

    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void navigateToEcommerce() {
        getDriver().navigate().to(E_COMMERCE_URL);
    }

    public void navigateToOrders() {
        ordersTab.click();
    }

    public void navigateToCustomers() {
        customersTab.click();
    }

    public void navigateToProducts() {
        productsTab.click();
    }
}
