package com.appium.android.businessObjects;

import com.appium.android.pageObjects.SignInPageObject;
import io.appium.java_client.AppiumDriver;

/**
 * Created by vagrant on 11/18/17.
 */
public class SignInBusinessObject {

    SignInPageObject signIn;

    public SignInBusinessObject(AppiumDriver appiumDriver) {
        signIn = new SignInPageObject(appiumDriver);
    }

    public String signInGetErrorMessage(String userName, String password) {
        signIn.inputUserName(userName);
        signIn.inputPassword(password);
        signIn.pressSignIn();
        return signIn.getErrorMessage();
    }
}
