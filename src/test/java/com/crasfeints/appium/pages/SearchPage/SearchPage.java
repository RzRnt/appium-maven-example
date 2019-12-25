package com.crasfeints.appium.pages.SearchPage;

import com.crasfeints.appium.helper.Config.Config;
import com.crasfeints.appium.pages.BaseSteps;
import com.crasfeints.appium.pages.SearchPage.SearchPageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.*;

public class SearchPage extends BaseSteps {

    SearchPageFactory searchPageFactory;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        this.searchPageFactory = new SearchPageFactory();
    }

    public void inputSearchBox(String products) {
        inputOnElement(searchPageFactory.SEARCH_INPUT_TEXT, products);
    }

    public void tapOnSuggestionResult() {
        List<AndroidElement> SUGGESTION_LIST = getElements(searchPageFactory.SEARCH_KEYWORD_RESULT, Config.TIMEOUT);
        SUGGESTION_LIST.get(0).click();
    }

    public void tapOnSuggestionResult(int postition) {
        List<AndroidElement> SUGGESTION_LIST = getElements(searchPageFactory.SEARCH_KEYWORD_RESULT, Config.TIMEOUT);
        SUGGESTION_LIST.get(postition).click();
    }
}
