package com.crasfeints.appium.pages;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;

public class BasePageFactory {

    public Locator CLOSE_BUTTON = new Locator(LocatorStrategy.ACCESSIBILITY_ID, "Close");
    public Locator EBAY_TOOLBAR = new Locator(LocatorStrategy.ACCESSIBILITY_ID, "eBay");
}
