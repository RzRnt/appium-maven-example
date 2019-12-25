package com.crasfeints.appium.pages.HomePage;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import com.crasfeints.appium.pages.BasePageFactory;

public class HomePageFactory extends BasePageFactory {

    Locator SEARCH_BOX = new Locator(LocatorStrategy.ID, "search_box");

}
