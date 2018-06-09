package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomerPage extends AbstractPage {

    @FindBy(id="addCustomer")
    WebElement addCustomerButton;

    @FindBys(@FindBy(id="deleteCustomer"))
    List<WebElement> deleteButton;

    @FindBy(id="name")
    WebElement customerFirstname;

    @FindBy(id="firstname")
    WebElement customerLastname;

    @FindBy(id="email")
    WebElement customerEmail;

    @FindBy(id="street")
    WebElement customerStreet;

    @FindBy(id="city")
    WebElement customerCity;

    @FindBy(id="saveCustomer")
    WebElement saveCustomerButton;

    @FindBy(id="backToCustomerList")
    WebElement backToCustomerList;

    public CustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void addCustomer(String firstName, String lastName, String email, String street, String city) {
        addCustomerButton.click();
        this.customerFirstname.sendKeys(firstName);
        this.customerLastname.sendKeys(lastName);
        this.customerEmail.sendKeys(email);
        this.customerStreet.sendKeys(street);
        this.customerCity.sendKeys(city);
        this.saveCustomerButton.click();
        goBack();
    }

    public void goBack(){
        this.backToCustomerList.click();
    }
}
