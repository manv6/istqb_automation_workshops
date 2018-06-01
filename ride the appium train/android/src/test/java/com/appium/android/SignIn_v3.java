package com.appium.android;

import com.appium.android.common.TestBase;
import com.appium.android.pageObjects.SignInPageObject;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by vagrant on 11/7/17.
 */
public class SignIn_v3 extends TestBase {

    @Test
    public void signIn() throws Exception {
        SignInPageObject signInPageObject = new SignInPageObject(appiumDriver);
        signInPageObject.inputUserName("pstsiakos");
        signInPageObject.inputPassword("a11111111!");
        signInPageObject.pressSignIn();
        Assert.assertEquals(signInPageObject.getErrorMessage(), "Invalid email or password!");
    }


}
