package com.automation.example.business;

import com.automation.example.framework.AbstractPage;
import com.automation.example.pages.CustomerPage;
import com.automation.example.pages.NavigationPage;
import com.automation.example.pages.OrderPage;
import com.automation.example.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class Ecommerce extends AbstractPage {
    private ProductPage productPage;
    private CustomerPage customerPage;
    private OrderPage orderPage;
    private NavigationPage navigationPage;


    public Ecommerce(WebDriver driver) {
        super(driver);
        productPage = new ProductPage(this.getDriver());
        customerPage = new CustomerPage(this.getDriver());
        orderPage = new OrderPage(this.getDriver());
        navigationPage = new NavigationPage(this.getDriver());
    }

    public void aWebBrowserIsOnEcommercePage() throws Throwable {
        navigationPage.navigateToEcommerce();
    }

    public void navigateToOrdersPage() throws Throwable {
        navigationPage.navigateToOrders();
    }

    public void navigateToProductsPage() throws Throwable {
        navigationPage.navigateToProducts();
    }

    public void navigateToCustomersPage() throws Throwable {
        navigationPage.navigateToCustomers();
    }

    public void addANewCustomer(String firstName, String lastName, String email, String street, String city) throws Throwable {
        customerPage.addCustomer(firstName, lastName, email, street, city);
    }

    public void addANewProduct() throws Throwable {
        productPage.addItem("testProduct", "20");
    }

    public void addANewOrder() throws Throwable {
        orderPage.addOrderForCustomer("Vlastos Manolis");
        orderPage.addProductToOrder("testProdu", "10");
        orderPage.placeOrder();
    }
}
