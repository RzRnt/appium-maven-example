package com.crasfeints.appium.pages.SignInPage;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import com.crasfeints.appium.pages.BasePageFactory;

public class SignInPageFactory extends BasePageFactory {
    Locator EMAIL_OR_USERNAME_BUTTON = new Locator(LocatorStrategy.ID, "button_classic");
    Locator INPUT_EMAIL_OR_USERNAME = new Locator(LocatorStrategy.ID, "");
    Locator SIGN_IN_TITLE = new Locator(LocatorStrategy.ID, "title");


}
