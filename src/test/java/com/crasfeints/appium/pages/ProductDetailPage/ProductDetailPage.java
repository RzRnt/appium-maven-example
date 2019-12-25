package com.crasfeints.appium.pages.ProductDetailPage;

import com.crasfeints.appium.helper.Config.Config;
import com.crasfeints.appium.pages.BaseSteps;
import com.crasfeints.appium.pages.ProductDetailPage.ProductDetailPageFactory;

import io.appium.java_client.android.AndroidDriver;


public class ProductDetailPage extends BaseSteps {

    ProductDetailPageFactory productDetailPageFactory;
    String productName;
    String productPrice;

    public ProductDetailPage(AndroidDriver driver, String productName, String productPrice) {
        this.driver = driver;
        this.productDetailPageFactory = new ProductDetailPageFactory();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public void tapOnWatchProduct() {
        swipeTo(productDetailPageFactory.WATCH_BUTTON, Config.TIMEOUT);
        tapOnElement(productDetailPageFactory.WATCH_BUTTON);
    }

    public void verifyOnProductDetailPage() {
        goToTop();
        verifyProductName();
        verifyProductPrice();
    }

    public void goToTop() {
        /* Need Improvement to ensure to the top of product detail page */
        waitUntilElementIsVisible(productDetailPageFactory.EBAY_TOOLBAR, Config.TIMEOUT);
        SwipeDown();
    }

    public void verifyProductName() {
        verifyElementWithText(productDetailPageFactory.PRODUCT_NAME, this.productName, Config.TIMEOUT);
    }

    public void verifyProductPrice() {
        verifyElementWithText(productDetailPageFactory.PRODUCT_PRICE, this.productPrice, Config.TIMEOUT);
    }


}
