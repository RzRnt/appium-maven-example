package com.crasfeints.appium.pages.SearchPage;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import com.crasfeints.appium.pages.BasePageFactory;

public class SearchPageFactory extends BasePageFactory {
    Locator SEARCH_INPUT_TEXT = new Locator(LocatorStrategy.ID, "search_src_text");
    Locator SEARCH_KEYWORD_RESULT = new Locator(
            LocatorStrategy.XPATH,
            "//android.widget.ListView[contains(@resource-id, 'suggestionList')]//android.widget.TextView"
    );
}
