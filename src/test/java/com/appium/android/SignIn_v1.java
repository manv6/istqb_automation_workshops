package com.appium.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by vagrant on 11/7/17.
 */
public class SignIn_v1 {

    AppiumDriver appiumDriver;

    @Parameters({"app", "deviceName", "platformVersion", "appiumUrl"})
    @BeforeClass
    public void setup(String app, String deviceName, String platformVersion, String appiumUrl) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, app);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        appiumDriver = new AndroidDriver(new URL(appiumUrl), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void signIn() throws Exception {
        appiumDriver.findElement(MobileBy.id("login.example.com.simpleloginapp:id/user_email")).sendKeys("pstsiakos");
        appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'user_password')]")).sendKeys("a11111111!");
        WebElement loginButton = appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'sign_in_button')]"));
        new TouchAction(appiumDriver).tap(loginButton).perform();
        Assert.assertEquals(appiumDriver.findElement(MobileBy.xpath("//*[contains(@resource-id,'message')]")).getText(), "Invalid email or password!");
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }
}
