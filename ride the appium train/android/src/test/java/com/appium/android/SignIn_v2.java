package com.appium.android;

import com.appium.android.common.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by vagrant on 11/7/17.
 */
public class SignIn_v2 extends TestBase{

    @Test
    public void signIn() throws Exception {
        appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'user_email')]")).sendKeys("pstsiakos");
        appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'user_password')]")).sendKeys("a11111111!");
        WebElement loginButton = appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'sign_in_button')]"));
        new TouchAction(appiumDriver).tap(loginButton).perform();
        Assert.assertEquals(appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'message')]")).getText(), "Invalid email or password!");
    }

}
