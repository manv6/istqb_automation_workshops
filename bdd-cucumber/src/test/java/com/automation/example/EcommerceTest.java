//package com.automation.example;
//
//import com.automation.example.business.Ecommerce;
//import com.automation.example.framework.AbstractPage;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class EcommerceTest{
//
//    private WebDriver driver;
//    private Ecommerce ecommerce;
//
//
//    @org.junit.Before
//    public void initEcommercePage(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
////    @Test
//    public void test() throws Throwable {
//        Ecommerce ecommerce = new Ecommerce(driver);
//        ecommerce.navigateToProductsPage();
//        ecommerce.addANewProduct();
//        ecommerce.navigateToCustomersPage();
//        ecommerce.addANewCustomer("Manolis",
//                "Vlastos",
//                "evlastos@gmail.com",
//                "papanikoli",
//                "rafina");
//        ecommerce.navigateToOrdersPage();
//        ecommerce.addANewOrder();
//
//    }
//
//
//    @org.junit.After
//    public void disposeWebDriver() throws Throwable {
//        driver.quit();
//    }
//
//}
