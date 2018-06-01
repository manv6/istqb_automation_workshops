package com.appium.android;

import com.appium.android.businessObjects.SignInBusinessObject;
import com.appium.android.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by vagrant on 11/7/17.
 */
public class SignIn_v4 extends TestBase {

    @Test
    public void signIn() throws Exception {
        SignInBusinessObject signInBusinessObject = new SignInBusinessObject(appiumDriver);
        Assert.assertEquals(signInBusinessObject.signInGetErrorMessage("ptsiakos","a11111111!"), "Invalid email or password!");
    }


}
