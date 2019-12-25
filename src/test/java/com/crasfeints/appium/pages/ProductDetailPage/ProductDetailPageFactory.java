package com.crasfeints.appium.pages.ProductDetailPage;

import com.crasfeints.appium.helper.Locator.Locator;
import com.crasfeints.appium.helper.Locator.LocatorStrategy;
import com.crasfeints.appium.pages.BasePageFactory;

public class ProductDetailPageFactory extends BasePageFactory {

    Locator WATCH_BUTTON = new Locator(LocatorStrategy.ID, "button_watch");
    Locator PRODUCT_NAME = new Locator(LocatorStrategy.ID, "textview_item_name");
    Locator PRODUCT_IMAGE = new Locator(LocatorStrategy.ID, "imageview_image");
    Locator PRODUCT_PRICE = new Locator(LocatorStrategy.ID, "textview_item_price");

}
