package com.appium.android.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by panagiotis_tsiakos on 11/7/17.
 */
public class TestBase {

    protected AppiumDriver appiumDriver;

    protected AppiumDriverLocalService service;


    @BeforeSuite
    public void startAppium(){
        AppiumServiceBuilder sb =new AppiumServiceBuilder();
        sb.withAppiumJS(new File( "/usr/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.LOG_LEVEL,"error").build();
        service = AppiumDriverLocalService.buildService(sb);
        service.start();
    }

    @Parameters({"app", "deviceName", "platformVersion", "appiumUrl"})
    @BeforeClass
    public void setup(String app, String deviceName, String platformVersion, String appiumUrl) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, app);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        appiumDriver = new AndroidDriver(new URL(appiumUrl), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
