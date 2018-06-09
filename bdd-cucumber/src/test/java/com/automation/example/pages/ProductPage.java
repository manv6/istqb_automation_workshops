package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(id="addItem")
    WebElement addItemButton;

    @FindAll(@FindBy(id="deleteItem"))
    List<WebElement> deleteButton;

    @FindBy(id = "backToProductCatalog")
    WebElement backToProductList;

    @FindAll(@FindBy(id="deleteItem"))
    List<WebElement> listOfProducts;

    @FindBy(id="name")
    WebElement productName;

    @FindBy(id="price")
    WebElement productPrice;

    @FindBy(id="saveItem")
    WebElement saveProductButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addItem(String productName, String productPrice) {
        addItemButton.click();
        this.productName.sendKeys(productName);
        this.productPrice.sendKeys(productPrice);
        this.saveProductButton.click();
        goBack();
    }

    public void goBack(){
        backToProductList.click();
    }
}
