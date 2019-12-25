package com.crasfeints.appium.pages.SignInPage;

import com.crasfeints.appium.helper.Config.Config;
import com.crasfeints.appium.pages.BaseSteps;
import com.crasfeints.appium.pages.SignInPage.SignInPageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SignInPage extends BaseSteps {

    SignInPageFactory signInPageFactory;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        this.signInPageFactory = new SignInPageFactory();
        verifyOnSignInPage();
    }

    public void verifyOnSignInPage() {
        verifyElementIsVisible(signInPageFactory.SIGN_IN_TITLE, Config.TIMEOUT);
    }

    public void tapOnUseEmailOrUsername() {
        tapOnElement(signInPageFactory.EMAIL_OR_USERNAME_BUTTON);
    }

    public void inputEmailOrUsername(String emailOrUsername) {
        inputOnElement(signInPageFactory.INPUT_EMAIL_OR_USERNAME, emailOrUsername);
    }

    public void closeSignInPage() {
        tapOnElement(signInPageFactory.CLOSE_BUTTON);
    }

}
