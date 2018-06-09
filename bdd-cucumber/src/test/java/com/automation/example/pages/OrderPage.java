package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPage extends AbstractPage {

    @FindBy(id="addOrder")
    WebElement addItemButton;

    @FindAll(@FindBy(id="deleteOrder"))
    List<WebElement> deleteButton;

    @FindBy(id = "backToOrders")
    WebElement backToOrderList;

    @FindBy(id="customerId")
    WebElement customerSelect;

    @FindBy(id="addItem")
    WebElement addItemToOrderButton;

    @FindBy(id="orderLine0.itemId")
    WebElement productSelect;

    @FindBy(id="orderLine0.count")
    WebElement productQuantity;

    @FindBy(id="createOrder")
    WebElement createOrderButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addOrderForCustomer(String customerNAme) {
        addItemButton.click();
        Select select = new Select(customerSelect);//.selectByIndex(3);
        select.getOptions().forEach(customer->{
            if(customerNAme.equals(customer.getText())){
                customer.click();
            }
        });
    }

    public void addProductToOrder(String productName,String quantity){
        this.addItemToOrderButton.click();
        Select select = new Select(productSelect);//.selectByIndex(3);
        select.getOptions().forEach(product->{
            if(productName.equals(product.getText())){
                product.click();
            }
        });
        this.productQuantity.sendKeys(quantity);
    }

    public void placeOrder(){
        this.createOrderButton.click();
        goBack();
    }

    public void goBack(){
        this.backToOrderList.click();
    }
}
