package com.crasfeints.appium.helper.Locator;

import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Locator {

    public LocatorStrategy locatorStrategy;
    public String locatorValue;

    public Locator(LocatorStrategy _locatorStrategy, String locatorValue) {
        this.locatorStrategy = _locatorStrategy;
        this.locatorValue = locatorValue;
    }

    public Locator constructLocator(Object... formats) {
        return new Locator(this.locatorStrategy, String.format(this.locatorValue, formats));
    }

    public By getLocator() {
        switch(this.locatorStrategy) {
            case ID: return By.id(this.locatorValue);
            case CLASS: return By.className(this.locatorValue);
            case XPATH: return By.xpath(this.locatorValue);
            case ACCESSIBILITY_ID: return MobileBy.AccessibilityId(this.locatorValue);
            default: return null;
        }
    }



}
