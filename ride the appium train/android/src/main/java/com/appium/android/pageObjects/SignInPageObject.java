package com.appium.android.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vagrant on 11/18/17.
 */
public class SignInPageObject {

    public SignInPageObject(AppiumDriver appiumDriver){
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    //Page Elements
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'user_email')]")
    public AndroidElement emailInput;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'user_password')]")
    public AndroidElement emailPwd;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'sign_in_button')]")
    public AndroidElement signInBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'message')]")
    public AndroidElement validationMessage;


    public void inputUserName(String userName){
        emailInput.sendKeys(userName);
    }

    public void inputPassword(String password){
        emailPwd.sendKeys(password);
    }

    public void pressSignIn(){
        signInBtn.click();
    }

    public String getErrorMessage(){
        return validationMessage.getText();
    }

}
