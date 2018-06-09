//package com.automation.example.stepdefs;
//
//import com.automation.example.pages.*;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class EcommerceSteps {
//
//    private WebDriver driver;
//    private ProductPage productPage;
//    private CustomerPage customerPage;
//    private OrderPage orderPage;
//    private NavigationPage navigationPage;
//
//
//    @Before(value = "@web", order = 1)
//    public void webDriverManager() throws Throwable {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @Before(value = "@web", order = 2)
//    public void initWebDriver() throws Throwable {
//        driver = new ChromeDriver();
//    }
//
//    @Before(value = "@e-commerce", order = 10)
//    public void initEcommercePage() throws Throwable {
//        productPage = new ProductPage(driver);
//        customerPage = new CustomerPage(driver);
//        orderPage = new OrderPage(driver);
//        navigationPage = new NavigationPage(driver);
//    }
//
//    @Given("^web browser is on e-commerce page$")
//    public void aWebBrowserIsOnEcommercePage() throws Throwable {
//        navigationPage.navigateToEcommerce();
//    }
//
//    @After(value = "@web")
//    public void disposeWebDriver() throws Throwable {
//        driver.quit();
//    }
//
//    @And("^navigate to orders page$")
//    public void navigateToOrdersPage() throws Throwable {
//        navigationPage.navigateToOrders();
//    }
//
//    @And("^navigate to products page$")
//    public void navigateToProductsPage() throws Throwable {
//        navigationPage.navigateToProducts();
//    }
//
//    @And("^navigate to customers page$")
//    public void navigateToCustomersPage() throws Throwable {
//        navigationPage.navigateToCustomers();
//    }
//
//    @And("^add a new customer")
//    public void addANewCustomer() throws Throwable {
//        customerPage.addCustomer("Manolis",
//                "Vlastos",
//                "evlastos@gmail.com",
//                "papanikoli",
//                "rafina");
//    }
//
//    @And("^add a new product$")
//    public void addANewProduct() throws Throwable {
//        productPage.addItem("testProduct", "20");
//    }
//
//    @And("^add a new order$")
//    public void addANewOrder() throws Throwable {
//        orderPage.addOrderForCustomer("Vlastos Manolis");
//        orderPage.addProductToOrder("testProdu", "10");
//        orderPage.placeOrder();
//    }
//}
