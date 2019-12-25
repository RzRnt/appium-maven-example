package com.crasfeints.appium.pages.SearchResultPage;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import com.crasfeints.appium.pages.BasePageFactory;

public class SearchResultPageFactory extends BasePageFactory {

    Locator SORT_BUTTON = new Locator(LocatorStrategy.ID, "button_sort");
    Locator SORT_BY_TEXT = new Locator(LocatorStrategy.XPATH, "//android.widget.CheckedTextView[@text='%1s']");
    Locator PRODUCT_RESULT_CELLS = new Locator(LocatorStrategy.ID, "cell_collection_item");
    Locator POPUP_ONBOARDING = new Locator(LocatorStrategy.ACCESSIBILITY_ID, SearchResultCopy.POPUP_ONBOARD_COPY);
    Locator PRODUCT_TITLE = new Locator(
            LocatorStrategy.XPATH,
            "//android.widget.RelativeLayout[contains(@resource-id, 'cell_collection_item')][%1$s]" +
                    "//android.widget.TextView[contains(@resource-id, 'textview_item_title')]"
    );
    Locator PRODUCT_ATTRIBUTE = new Locator(
            LocatorStrategy.XPATH,
            "//android.widget.RelativeLayout[contains(@resource-id, 'cell_collection_item')][%1$s]" +
                    "//android.widget.TextView[contains(@resource-id, 'textview_item_subtitle')]"
    );
    Locator PRODUCT_PRICE = new Locator(
            LocatorStrategy.XPATH,
            "//android.widget.RelativeLayout[contains(@resource-id, 'cell_collection_item')][%1$s]" +
                    "//android.widget.TextView[contains(@resource-id, 'textview_item_price')]"
    );
    Locator PRODUCT_TOTAL_RESULT = new Locator(
            LocatorStrategy.ID,
            "textview_item_count"
    );
    Locator PRODUCT_CELL_BY_PRODUCT_NAME = new Locator(
            LocatorStrategy.XPATH,
            "//android.widget.TextView[contains(@resource-id, 'textview_item_title')]" +
                    "[@text='%1$s']");
}
