package com.crasfeints.appium;

import com.crasfeints.appium.helper.Config.Config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriver {


    public AndroidDriver SetUpDriver() throws AppiumServerHasNotBeenStartedLocallyException {

        AndroidDriver androidDriver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Config config = new Config();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, config.NEW_COMMAND_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, config.APP_ACTIVITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, config.APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, config.SYSTEM_PORT);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, config.APP_WAIT_ACTIVITY);

        try {
            androidDriver = new AndroidDriver(new URL(config.APPIUM_URL), capabilities);
        } catch (MalformedURLException e) {
            throw new AppiumServerHasNotBeenStartedLocallyException("BaseDriver - Failed to Get Appium Driver");
        }
        return androidDriver;
    }

    public void TearDown(AndroidDriver driver) {
        driver.quit();
    }

}
