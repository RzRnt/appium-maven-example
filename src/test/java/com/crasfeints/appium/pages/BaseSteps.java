package com.crasfeints.appium.pages;

import com.crasfeints.appium.helper.Config.Config;
import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Utilities.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BaseSteps {


    public AndroidDriver driver;

    public void tapOnElement(Locator locator) {
        waitUntilElementIsVisible(locator, Config.TIMEOUT).click();
    }

    public void inputOnElement(Locator locator, String input) {
        waitUntilElementIsVisible(locator, Config.TIMEOUT).setValue(input);
    }

    public AndroidElement waitUntilElementIsVisible(Locator locator, int timeout) {
        return (AndroidElement) new WebDriverWait(this.driver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getLocator()));
    }

    public void verifyElementIsVisible(Locator locator, int timeout) {
        Assertions.assertTrue(waitUntilElementIsVisible(locator, timeout).isDisplayed());
    }

    public void verifyElementWithText(Locator locator, String text, int timeout) {

    }

    public boolean isElementVisible(Locator locator, int timeout) {
        Boolean visible = false;
        long _timeout = Instant.now().getEpochSecond() + Long.valueOf(timeout);
        while (Instant.now().getEpochSecond() < _timeout) {
            try {
                visible =  driver.findElement(locator.getLocator()).isDisplayed();
                if (visible) break;
            } catch (Exception e) {
                util.delay(200);
            }
        }
        return visible;
    }

    public List<AndroidElement> getElements(Locator locator, int timeout) {
        List<AndroidElement> elements = null;
        long _timeout = Instant.now().getEpochSecond() + Long.valueOf(timeout);
        while (Instant.now().getEpochSecond() < _timeout) {
            try {
                elements = driver.findElements(locator.getLocator());
                if (elements.size() != 0) break;
            } catch (Exception e) {
               util.delay(200);
            }
        }
        return elements;
    }

    public String getAttributeLocator(Locator locator, int timeout, String attribute) {
        return waitUntilElementIsVisible(locator, timeout).getAttribute(attribute);
    }

    public String getText(Locator locator, int timeout) {
        return waitUntilElementIsVisible(locator, timeout).getText();
    }

    public void SwipeUp() {
        Dimension size = driver.manage().window().getSize();

        int y0 = (int) (size.height * 0.6);
        int y1 = (int) (size.height * 0.4);
        int x = (size.width / 2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
            .press(new PointOption().withCoordinates(x, y0))
            .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
            .moveTo(new PointOption().withCoordinates(x, y1))
            .release()
            .perform();
    }

    public void SwipeDown() {
        Dimension size = driver.manage().window().getSize();

        int y0 = (int) (size.height * 0.6);
        int y1 = (int) (size.height * 0.4);
        int x = (size.width / 2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction
            .press(new PointOption().withCoordinates(x, y1))
            .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
            .moveTo(new PointOption().withCoordinates(x, y0))
            .release()
            .perform();
    }

    public void swipeTo(Locator locator, int timeout) {
        Boolean visible = false;
        long _timeout = Instant.now().getEpochSecond() + Long.valueOf(timeout);
        while (Instant.now().getEpochSecond() < _timeout) {
            try {
                visible = driver.findElement(locator.getLocator()).isDisplayed();
                if (visible) break;
            } catch (Exception e) {
                SwipeUp();
                util.delay(200);
            }
        }
    }

    public void swipeDownTo(Locator locator, int timeout) {
        Boolean visible = false;
        long _timeout = Instant.now().getEpochSecond() + Long.valueOf(timeout);
        while (Instant.now().getEpochSecond() < _timeout) {
            try {
                visible = driver.findElement(locator.getLocator()).isDisplayed();
                if (visible) break;
            } catch (Exception e) {
                SwipeDown();
                util.delay(200);
            }
        }
    }


}
