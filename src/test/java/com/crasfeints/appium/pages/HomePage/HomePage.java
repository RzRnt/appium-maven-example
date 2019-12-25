package com.crasfeints.appium.pages.HomePage;

import com.crasfeints.appium.pages.BaseSteps;
import com.crasfeints.appium.pages.HomePage.HomePageFactory;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BaseSteps {

    HomePageFactory homePageFactory = new HomePageFactory();

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void tapOnSearchBox() {
        tapOnElement(homePageFactory.SEARCH_BOX);
    }

}
