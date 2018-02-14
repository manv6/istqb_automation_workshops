package com.appium.android;

import com.appium.android.common.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by vagrant on 11/7/17.
 */
public class SignIn_Web_Facebook {

    AppiumDriver appiumDriver;
    protected AppiumDriverLocalService service;

    @BeforeSuite
    public void startAppium(){
        AppiumServiceBuilder sb =new AppiumServiceBuilder();
        sb.withAppiumJS(new File( "/usr/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.LOG_LEVEL,"info").build();
        service = AppiumDriverLocalService.buildService(sb);
        service.start();
    }

    @Parameters({"deviceName", "platformVersion", "appiumUrl"})
    @BeforeClass
    public void setup(String deviceName, String platformVersion, String appiumUrl) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

        appiumDriver = new AndroidDriver(new URL(appiumUrl), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void signIn() throws Exception {
        appiumDriver.get("https://www.linkedin.com/");
        appiumDriver.findElement(MobileBy.linkText("Sign in")).click();
        appiumDriver.findElement(MobileBy.id("loginuy-email")).sendKeys("ptsasdfasdfiakos77@gmail.com");
        appiumDriver.findElement(MobileBy.id("login-password")).sendKeys("asdfasdfasdfasdf!.");
        appiumDriver.findElement(MobileBy.id("login-submit")).click();
        Thread.sleep(20000);
    }

    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }

    @AfterSuite
    public void stopAppium(){
        service.stop();
    }
}
